import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        boolean[] check = new boolean[people.length];
        Arrays.sort(people);
        
        int lt = 0;
        for (int i = people.length - 1; i >= 0; i--) {
            if (lt > i) {
                break;
            }
            if (people[i] >= limit) {
                answer++;
                continue;
            }
            if (people[i] + people[lt] <= limit) {
                lt++;
            }
            answer++;
        }
        return answer;
    }
}