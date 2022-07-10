class Solution {
    static int[] arr, ch;
    static int n, tNum, answer = 0;

    private void DFS(int L) {
        if (L == n) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                int t = arr[i];
                sum += ch[i] == 1 ? t : (-1) * t;
            }
            if (sum == tNum) answer++;
        } else {
            ch[L] = 1;
            DFS(L + 1);
            ch[L] = 0;
            DFS(L + 1);
        }
    }

    public int solution(int[] numbers, int target) {
        n = numbers.length;
        arr = numbers;
        tNum = target;
        ch = new int[n];
        DFS(0);
        return answer;
    }
}