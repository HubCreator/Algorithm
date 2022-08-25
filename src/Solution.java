
class Solution {
    public String solution(String new_id) {
        // 1단계
        String s = new_id.toLowerCase();

        // 2단계
        s = s.replaceAll("[^a-z0-9-_.]", "");

        // 3단계
        s = s.replaceAll("[.]{2,}", ".");

        // 4단계
        s = s.replaceAll("^[.]", "");

        // 5단계
        if (s.length() == 0) s = "a";

        // 6단계
        if (s.length() > 15) s = s.substring(0, 15);
        s = s.replaceAll("[.]$", "");

        // 7단계
        if (s.length() <= 2) {
            char t = s.charAt(s.length() - 1);
            while (s.length() < 3) {
                s = s + t;
            }
        }

        return s;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        String str = "...!@BaT#*..y.abcdefghijklm";
        System.out.println(T.solution(str));
    }
}