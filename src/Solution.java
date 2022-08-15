
class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            for (long j = numbers[i] + 1; ; j++) {
                char[] chars = Long.toBinaryString(numbers[i] ^ j).toCharArray();
                int sum = 0;
                for (char c : chars) {
                    if (c == '1') sum++;
                    if (sum > 2) break;
                }
                if (sum <= 2) {
                    answer[i] = j;
                    break;
                }
            }
        }
        return answer;
    }
}