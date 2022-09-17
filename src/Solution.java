class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        char[] arr = s.toLowerCase().toCharArray();
        boolean flag = true;

        for (char ch : arr) {
            if (flag) answer.append(Character.toUpperCase(ch));
            else answer.append(ch);
            flag = Character.isSpaceChar(ch);
        }
        return answer.toString();
    }
}