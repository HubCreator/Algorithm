class Solution {
    public int[] solution(int n, int s) {
        if (n > s) return new int[]{-1};
        int[] answer = new int[n];
        int mid = s / n;
        int sum = s - (mid * n);
        System.out.println("sum = " + sum);
        for (int i = 0; i < n; i++) {
            if (i >= n - sum) answer[i] = mid + 1;
            else answer[i] = mid;
        }
        return answer;
    }
}