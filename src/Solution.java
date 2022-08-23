
class Solution {
    // k일간 최대 매출액
    public int solution(int n, int k, int[] arr) {
        int sum = 0, max = Integer.MIN_VALUE;
        // 초기 윈도우 설정
        for (int i = 0; i < k - 1; i++) sum += arr[i];

        for (int i = k - 1; i < n; i++) {
            sum += arr[i];
            max = Math.max(max, sum);
            sum -= arr[i - k + 1];
        }
        return max;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int n = 10;
        int k = 3;
        int[] arr = {20, 15, 11, 20, 25, 10, 20, 19, 13, 15};
        System.out.println(T.solution(n, k, arr));
    }
}