
class Solution {
    public int solution(int[] stones, int k) {
        int answer = Integer.MAX_VALUE;
        int cnt, tmp;

        for (int i = 0; i <= stones.length - k; i++) {
            cnt = 0;
            tmp = Integer.MIN_VALUE;

            while (cnt < k) {
                if (tmp < stones[i + cnt]) {
                    tmp = stones[i + cnt];
                }
                cnt++;
            }
            if (answer > tmp) {
                answer = tmp;
            }
        }
        return answer;
    }
}