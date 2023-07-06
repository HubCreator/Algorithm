class Solution {

    public int[] solution(int[] sequence, int k) {
        for (int winSize = 1; winSize < sequence.length; winSize++) {
            int sum = 0;
            for (int i = 0; i < winSize - 1; i++) { // 초기 윈도우값 생성
                sum += sequence[i];
            }
            int lt = 0;
            for (int rt = winSize - 1; rt < sequence.length; rt++, lt++) {
                sum += sequence[rt];
                if (sum == k) return new int[]{lt, rt};
                sum -= sequence[lt];
            }
        }
        return null;
    }

    public static void main(String[] args) {
        final Solution T = new Solution();
        final int[] solution = T.solution(new int[]{1, 2, 3, 4, 5}, 7);
        System.out.println("[" + solution[0] + ", " + solution[1] + "]");
    }
}
