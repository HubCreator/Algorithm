import java.util.Arrays;

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        Arrays.fill(answer, Long.MAX_VALUE);
        for (int i = 0; i < numbers.length; i++) {
            for (long j = numbers[i] + 1; ; j++) {
                int cnt = 0;
                long l1 = Long.parseLong(Long.toBinaryString(numbers[i]));
                long l2 = Long.parseLong(Long.toBinaryString(j));
                String format = "%0" + Math.max((int) Math.log10(l1) + 1, (int) Math.log10(l2) + 1) + "d";
                String s1 = String.format(format, l1);
                String s2 = String.format(format, l2);

                for (int k = 0; k < s1.length(); k++) {
                    if (s1.charAt(k) != s2.charAt(k)) cnt++;
                }
                if (cnt <= 2) answer[i] = Math.min(answer[i], j);
                if (answer[i] < Long.MAX_VALUE && cnt > 2) break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        long[] arr = {2, 7};
        for (long x : T.solution(arr)) {
            System.out.println("x = " + x);
        }
    }
}