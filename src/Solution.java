class Solution {
    public int solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] ch = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (int i = 0; i < s.length(); i++) {
            char t = s.charAt(i);
            if (Character.isDigit(t)) sb.append(t);
            else {
                for (int j = 0; j < ch.length; j++) {
                    if (s.substring(i).startsWith(ch[j])) {
                        sb.append(j);
                        i += ch[j].length() - 1;
                    }
                }
            }
        }
        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution("one4seveneight"));
    }
}