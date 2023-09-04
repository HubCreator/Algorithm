class Solution {
    public long solution(int n) {
        int[] fibo = new int[n + 1];
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            makeFibo(fibo);
            return fibo[n];
        }
    }

    private void makeFibo(int[] fibo) {
        fibo[1] = 1;
        fibo[2] = 2;
        for (int i = 3; i < fibo.length; i++) {
            fibo[i] = (fibo[i - 2] + fibo[i - 1]) % 1234567;
        }
    }
}
