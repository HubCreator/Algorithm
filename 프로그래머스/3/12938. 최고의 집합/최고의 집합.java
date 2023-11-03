class Solution {
    public int[] solution(int n, int s) {
        if (n > s) {
            return new int[]{-1};
        }
        int[] answer = new int[n];
        int idx = 0;
        while (n > 0) {
            int target = s / n;
            answer[idx++] = target;
            s -= target;
            n--;
        }
        return answer;
    }
}
