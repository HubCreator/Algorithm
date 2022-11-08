
class Solution {
    public int solution(int[] stones, int k) {
        int min = Integer.MAX_VALUE, max, cnt, tmp;

        int i = 0, initValue = (int) Math.pow(2, k + 1);
        while (i <= stones.length - k) {
            max = Integer.MIN_VALUE;
            cnt = 0;
            tmp = initValue;

            while (cnt < k) {
                if (max < stones[i + cnt]) {
                    max = stones[i + cnt];
                    tmp ^= (int) Math.pow(2, cnt);
                }
                cnt++;
            }

            min = Math.min(min, max);

            int first = Long.toBinaryString(tmp).lastIndexOf("1");
            if (first <= k) i += k - first - 1;
            else i++;
        }
        return min;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int[] arr = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        System.out.println(T.solution(arr, 3));
    }
}