class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        char[] charArray = s.toLowerCase().toCharArray();
        boolean flag = true;
        for (char c : charArray) {
            if (flag) {
                answer.append(Character.toUpperCase(c));
            } else {
                answer.append(Character.toLowerCase(c));
            }
            flag = Character.isSpaceChar(c);
        }
        return answer.toString();
    }
}
