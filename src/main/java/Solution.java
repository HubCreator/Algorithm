
class Solution {
    public int solution(String input) {
        for (int window = input.length(); window >= 2; window--) { // 윈도우의 크기
            for (int index = 0; index <= input.length() - window; index++) { // 슬라이딩
                if (isPalindrome(input, index, window)) {
                    return window;
                }
            }
        }
        return 1;
    }

    private boolean isPalindrome(String str, int start, int window) {
        if (window == 2) {
            return str.charAt(start) == str.charAt(start + 1);
        }
        for (int i = start; i < start + window / 2; i++) {
            if (str.charAt(i) != str.charAt(start + (start + window - 1) - i)) {
                return false;
            }
        }
        return true;
    }
}