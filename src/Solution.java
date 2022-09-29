class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            for (long j = numbers[i] + 1; ; j++) {
                char[] chars = Long.toBinaryString(numbers[i] ^ j).toCharArray();
                int sum = 0;
                for (char c : chars) { // 여기서 실행시간 초과 오류가 일어날 것으로 예상
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