class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder(s.toLowerCase());
        if (Character.isLowerCase(answer.charAt(0)))
            answer.replace(0, 1, String.valueOf(Character.toUpperCase(answer.charAt(0))));
        for (int i = 1; i < answer.length(); i++) {
            if (answer.charAt(i - 1) == ' ' && Character.isLowerCase(answer.charAt(i))) {
                answer.replace(i, i + 1, String.valueOf(Character.toUpperCase(answer.charAt(i))));
            }
        }

        return answer.toString();
    }
}