class Solution {
    public long solution(int n, int[] times) {
        long lt = 0, rt = (long) 1e18;
        long answer = (long) 1e18;
        while (lt <= rt) {
            long cnt = 0;
            long mid = (lt + rt) / 2;
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
        int[] arr = {1, 5};
        System.out.println(T.solution(10, arr));
    }
}