class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] people = new int[n + 2]; // 맨 왼쪽 오른쪽을 비워둠
        int answer = n;

        for (int l : lost) people[l]--;
        for (int r : reserve) people[r]++;

        for (int i = 1; i < people.length - 1; i++) {
            if (people[i] == -1) { // 잃어버린 놈
                if (people[i - 1] == 1) { // 잃어버린 놈과 빌려주는 놈을 모두 0으로 만듬
                    people[i]++;
                    people[i - 1]--;
                } else if (people[i + 1] == 1) {
                    people[i]++;
                    people[i + 1]--;
                } else
                    answer--;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};
        System.out.println(T.solution(n, lost, reserve));
    }
}