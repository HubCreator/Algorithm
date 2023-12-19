import java.util.HashSet;
import java.util.Set;

class Solution {
    public Set<Integer> answer = new HashSet<>();
    public boolean[] prime = new boolean[10000001];

    public int solution(String numbers) {
        int length = numbers.length();
        char[] charArr = new char[length];
        for (int i = 0; i < length; i++) {
            charArr[i] = numbers.charAt(i);
        }
        makePrime();

        for (int i = 1; i <= length; i++) {
            char[] pm = new char[i];
            boolean[] check = new boolean[length];
            dfs(charArr, pm, check, i, 0);
        }

        return answer.size();
    }

    public void dfs(char[] charArr, char[] pm, boolean[] check, int len, int level) {
        if (level == len) {
            StringBuilder result = new StringBuilder();
            for (char c : pm) {
                result.append(c);
            }
            int t = Integer.parseInt(result.toString());
            System.out.println(t);
            if (!prime[t]) {
                answer.add(t);
            }
        } else {
            for (int i = 0; i < charArr.length; i++) {
                if (!check[i]) {
                    check[i] = true;
                    pm[level] = charArr[i];
                    dfs(charArr, pm, check, len, level + 1);
                    check[i] = false;
                }
            }
        }
    }

    public void makePrime() {
        prime[0] = true;
        prime[1] = true;
        for (int i = 2; i < prime.length; i++) {
            if (!prime[i]) {
                for (int j = i * 2; j < prime.length; j += i) {
                    prime[j] = true;
                }
            }
        }
    }
}
