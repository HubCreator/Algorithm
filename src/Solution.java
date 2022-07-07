class Solution {
    public int solution(String s) {
        String[] ch = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (int i = 0; i < ch.length; i++) {
            s = s.replaceAll(ch[i], String.valueOf(i));
        }
        return Integer.parseInt(s);
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution("one4seveneight"));
    }
}