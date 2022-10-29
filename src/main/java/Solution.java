class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        boolean[] arr = new boolean[n + 1];
        int len = 2 * w + 1;

        // 초기화
        for (int station : stations) {
            for (int i = station - w; i <= station + w; i++) {
                if (i > arr.length - 1) break;
                arr[i] = true;
            }
        }

        int cnt = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i]) {
                if (cnt > 0) {
                    answer += (int) Math.ceil((double) (cnt) / (double) len);
                    cnt = 0;
                }
                continue;
            }
            cnt++;
        }

        if (!arr[arr.length - 1] && cnt > 1) {
            answer += (int) Math.ceil((double) (cnt - 1) / (double) len);
        }

        return answer;
    }
}