import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean[] prime = new boolean[10000001];
    public int count = 0;
    public Set<Integer> result = new HashSet<>();

    public int solution(String numbers) {
        char[] arr = new char[numbers.length()];

        makePrime();

        for (int i = 0; i < numbers.length(); i++) {
            arr[i] = numbers.charAt(i);
        }

        for (int i = 1; i <= arr.length; i++) {
            boolean[] check = new boolean[arr.length];
            int[] pm = new int[i];
            dfs(arr, pm, check, i, 0);
        }

        return result.size();
    }

    public void makePrime() {
        prime[0] = true;
        prime[1] = true;
        for (int i = 2; i < prime.length; i++) {
            if (!prime[i]) {
                for (int j = i + i; j < prime.length; j += i) {
                    prime[j] = true;
                }
            }
        }
    }

    public void dfs(char[] arr, int[] pm, boolean[] check, int end, int level) {
        if (level == end) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < pm.length; i++) {
                sb.append(arr[pm[i]]);
            }

            if (sb.length() != 0 && !prime[Integer.parseInt(sb.toString())]) {
                result.add(Integer.parseInt(sb.toString()));
            }
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (!check[i]) {
                    check[i] = true;
                    pm[level] = i;
                    dfs(arr, pm, check, end, level + 1);
                    check[i] = false;
                }
            }
        }
    }
}
