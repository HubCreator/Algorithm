class Solution {
    private int max = Integer.MIN_VALUE;

    public String solution(int[] numbers) {
        int[] pm = new int[numbers.length];
        boolean[] check = new boolean[numbers.length];
        dfs(numbers, pm, check, "", 0);
        return String.valueOf(max);
    }

    public void dfs(int[] numbers, int[] pm, boolean[] check, String result, int level) {
        if (pm.length == level) {
            max = Math.max(max, Integer.parseInt(result));
        } else {
            for (int i = 0; i < numbers.length; i++) {
                if (!check[i]) {
                    check[i] = true;
                    pm[level] = numbers[i];
                    dfs(numbers, pm, check, result + numbers[i], level + 1);
                    check[i] = false;
                }
            }
        }
    }
}
