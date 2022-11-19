import java.util.HashSet;
import java.util.Set;

class Solution {
    static String numbers;
    static int len;
    static int[] pm;
    static boolean[] check;
    static Set<Integer> answer = new HashSet<>();

    public int solution(String _numbers) {
        numbers = _numbers;
        check = new boolean[numbers.length()];

        for (int i = 1; i <= numbers.length(); i++) {
            len = i;
            pm = new int[i];
            check = new boolean[numbers.length()];
            dfs(0);
        }

        return answer.size();
    }

    private void dfs(int L) {
        if (L == len) {
            StringBuilder sb = new StringBuilder();
            for (int x : pm) sb.append(numbers.charAt(x));
            int t = Integer.parseInt(sb.toString());
            if (isPrime(t)) answer.add(t);
            return;
        }
        for (int i = 0; i < numbers.length(); i++) {
            if (!check[i]) {
                check[i] = true;
                pm[L] = i;
                dfs(L + 1);
                check[i] = false;
            }
        }
    }

    private boolean isPrime(int value) {
        if (value <= 1) return false;
        for (int i = 2; i < value; i++) {
            if (value % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution("17"));
    }
}