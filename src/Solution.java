class Solution {
    int[] ch, arr;
    int cnt = 0, max = Integer.MIN_VALUE, maxEl = 0;

    private void dfs(int L, int s, int target) {
        if (L == ch.length) {
            int sum = 0, mult = 1, maxElement = Integer.MIN_VALUE;
            for (int x : ch) {
                if (x == 0) break;
                sum += arr[x];
                mult *= arr[x];
                if (x > maxElement) maxElement = x;
            }
            if (sum == target) {
                cnt++;
                for (int x : ch) System.out.print(x + " ");
                System.out.println();
                if (mult > max) {
                    max = mult;
                    maxEl = maxElement;
                }
            }
        } else {
            for (int i = s; i < arr.length; i++) {
                ch[L] = i;
                dfs(L + 1, i + 1, target);
            }
        }
    }

    public int[] solution(int n, int s) {
        if (n > s) return new int[]{-1};
        arr = new int[s + 1];
        for (int i = 0; i <= s; i++) arr[i] = i;
        ch = new int[n];
        dfs(0, 0, s);
        if (s % n == 0) {
            cnt++;
            maxEl = s / n;
        }
        return new int[]{cnt, maxEl};
    }
}