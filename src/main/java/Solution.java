class Solution {
    int[] ch;

    public int solution(int n) {
        ch = new int[n + 1];
        return fibo(n);
    }

    private int fibo(int n) {
        if (ch[n] > 0) return ch[n];
        if (n == 1) return ch[n] = 1;
        if (n == 2) return ch[n] = 2;
        return ch[n] = (fibo(n - 1) + fibo(n - 2)) % 1000000007;
    }
}