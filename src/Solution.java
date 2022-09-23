class Solution {
    int[] arr;

    private int dfs(int n) {
        if (arr[n] > 0) return arr[n];
        if (n == 1) return arr[n] = 1;
        else if (n == 2) return arr[n] = 1;
        else return arr[n] = (dfs(n - 2) + dfs(n - 1)) % 1234567;
    }

    public int solution(int n) {
        arr = new int[n + 1];
        return dfs(n);
    }
}