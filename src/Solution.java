class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int pCnt = 0, yCnt = 0;
        s = s.toLowerCase();

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'y') yCnt++;
            if(s.charAt(i) == 'p') pCnt++;
        }

        return pCnt == yCnt || (pCnt == 0 && yCnt == 0);
    }
}