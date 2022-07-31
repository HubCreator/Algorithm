class Solution {
    static StringBuilder sb = new StringBuilder();

    static void hello(int n) {
        if (n == 1) {
            sb.append("1");
        } else if (n == 2) {
            sb.append("2");
        } else if (n == 3 || n == 0) {
            sb.append("4");
        } else {
            hello((n - 1) / 3);
            hello(n % 3);
        }
    }

    public String solution(int n) {
        hello(n);
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(10));
    }
}