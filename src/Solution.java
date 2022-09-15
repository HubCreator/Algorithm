class Solution {
    long[] ch;

    private long foo(int val) {
        if (ch[val] > 0) return ch[val];
        if (val == 1) return ch[val] = 1;
        else if (val == 2) return ch[val] = 1;
        else return ch[val] = (foo(val - 2) + foo(val - 1))  % 1234567;
    }

    public long solution(int n) {
        ch = new long[n + 2];
        foo(n + 1);
        return ch[n + 1];
    }
}