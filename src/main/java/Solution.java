
class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            // 짝수일 때
            if (numbers[i] % 2 == 0) {
                answer[i] = numbers[i] + 1;
                continue;
            }
            // 홀수일 때
            StringBuilder target = new StringBuilder(Long.toBinaryString(numbers[i]));
            int idx = target.lastIndexOf("0");
            if (idx != -1) {
                target.replace(idx, idx + 1, "1");
                target.replace(idx + 1, idx + 2, "0");
            } else {
                target.insert(0, '1');
                target.replace(1, 2, "0");
            }
            answer[i] = Long.parseLong(target.toString(), 2);
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        for (long l : T.solution(new long[]{1001})) {
            System.out.println("l = " + l);
        }
    }
}