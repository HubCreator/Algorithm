
class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            long num = numbers[i] + 1;
            while (Long.bitCount(num ^ numbers[i]) > 2) {
                num++;
            }
            answer[i] = num;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        for (long l : T.solution(new long[]{2, 7})) {
            System.out.println("l = " + l);
        }
    }
}