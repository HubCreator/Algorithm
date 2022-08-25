
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        int[] arr = new int[n + 2];
        for (int x : lost) arr[x] -= 1;
        for (int x : reserve) arr[x] += 1;
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] == -1) {
                // 좌 우를 찾아봐야함
                if (arr[i - 1] == 1) arr[i - 1] = arr[i] = 0;
                else if (arr[i + 1] == 1) arr[i + 1] = arr[i] = 0;
                else answer--;
            }
        }
        return answer;
    }
}