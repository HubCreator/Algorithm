class Solution {
    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isAlphabetic(s.charAt(i))) {
                char t = s.charAt(i);
                if (Character.isUpperCase(t) && t + n > 'Z') t -= 26;
                else if (Character.isLowerCase(t) && t + n > 'z') t -= 26;
                answer.append((char) (t + n));
            } else answer.append(" ");
        }

        return answer.toString();
    }
}