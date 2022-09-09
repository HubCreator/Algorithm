class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        String[] arr = s.toLowerCase().split("");
        boolean flag = true;

        for (String ss : arr) {
            if (flag) answer.append(ss.toUpperCase());
            else answer.append(ss);
            flag = ss.equals(" ");
        }

        return answer.toString();
    }
}