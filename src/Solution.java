class Solution {
    public int[] solution(long n) {
        int[] answer = new int[(int)Math.log10(n) + 1];
        String s = String.valueOf(n);
        for(int i = 0; i < answer.length; i++) {
            answer[i] = Integer.parseInt(String.valueOf(s.charAt(answer.length - 1 - i)));
        }

        return answer;
    }
}