import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        boolean flag = false;
        boolean[] check = new boolean[people.length];
        Arrays.sort(people);

        for (int i = 0; i < people.length; i++) {
            if (check[i]) {
                continue;
            }
            for (int j = check.length - 1; j >= 0; j--) {
                if (check[j]) {
                    continue;
                }
                if (people[i] + people[j] <= limit) {
                    check[i] = true;
                    check[j] = true;
                    answer++;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                check[i] = true;
                answer++;
            } else {
                flag = false;
            }
        }

        return answer;
    }
}