class Solution {
    public int solution(int n) {
        int oneCount = getOneCount(n);

        while (true) {
            if (getOneCount(++n) == oneCount) {
                break;
            }
        }
        return n;
    }

    private int getOneCount(int n) {
        String binary = Integer.toBinaryString(n);
        char[] arr = binary.toCharArray();
        int result = 0;
        for (char c : arr) {
            if (c == '1') result += 1;
        }
        return result;
    }
}
