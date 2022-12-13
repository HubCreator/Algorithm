class Solution {
    public int solution(String s) {
        for (int window = s.length(); window >= 1; window--) { // 윈도우의 크기
            for (int index = 0; index <= s.length() - window; index++) { // 슬라이딩
                String substring = s.substring(index, index + window);
                if (isPalindrome(substring)) {
                    return substring.length();
                }
            }
        }
        return 0;
    }

    private boolean isPalindrome(String str) {
        String str1 = str.substring(0, str.length() / 2);
        String str2 = str.length() == 2 ?
                new StringBuilder(str.substring(str.length() / 2)).reverse().toString() :
                new StringBuilder(str.substring(str.length() / 2 + 1)).reverse().toString();
        return str1.equals(str2);
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution("ecdabbcadc"));
    }
}