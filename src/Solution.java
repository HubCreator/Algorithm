class Solution {
    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(Character.isAlphabetic(s.charAt(i))) {
                char t = s.charAt(i);
                int tmp = t + n;

                if(Character.isUpperCase(t)) {
                    if(tmp > 'Z') tmp -= 26;
                } else if(Character.isLowerCase(t)) {
                    if(tmp > 'z') tmp -= 26;
                }
                answer.append((char) tmp);
            } else answer.append(" ");
        }
        return answer.toString();
    }
}