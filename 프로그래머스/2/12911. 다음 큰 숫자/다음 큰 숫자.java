class Solution {
    public int solution(int n) {
        int oneCount = Integer.bitCount(n);
        
        while (true) {
            if (Integer.bitCount(++n) == oneCount) {
                break;
            }
        }
        return n;
    }
}