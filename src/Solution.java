class Solution {
    public long solution(int n, int[] times) {
        long lt = 0, rt = (long) 1e18;
        long answer = 0;
        while (lt <= rt) { // 범위 내에서 계속해서 찾아나감
            long mid = (lt + rt) / 2; // mid = 총 소요 시간
            long cnt = 0;             // cnt = 각 심사대에서 몇 명의 사람을 받을 수 있는가 (mid / time)
            for (int time : times) {
                cnt += mid / time;
                if (cnt >= n) {
                    rt = mid - 1;
                    answer = mid;
                    break;
                }
            }
            if (cnt < n) lt = mid + 1;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int n = 6;
        int[] arr = {7, 10};
        System.out.println(T.solution(n, arr));
    }
}