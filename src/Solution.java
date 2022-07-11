import java.util.ArrayList;
import java.util.List;

class Solution {
    String nums;
    List<Integer> primeList = new ArrayList<>();
    int[] ch;
    int len;

    public boolean isPrime(int v) {
        if (v <= 1) return false;
        for (int i = 2; i < v; i++) {
            if (v % i == 0) return false;
        }
        return true;
    }

    private void DFS(int L) { // 순열 구하기
        if (L == len) {
            List<Integer> visited = new ArrayList<>();
            StringBuilder tmp = new StringBuilder();
            for (int x : ch) {
                if (visited.contains(x)) return; // 중복된 인덱스 값을 허용하지 않음
                visited.add(x);
                tmp.append(nums.charAt(x));
            }
            Integer t = Integer.parseInt(String.valueOf(tmp));
            if (!primeList.contains(t) && isPrime(t)) primeList.add(t);
        } else {
            for (int i = 0; i < nums.length(); i++) {
                ch[L] = i;
                DFS(L + 1);
            }
        }
    }

    public int solution(String numbers) {
        nums = numbers;
        for (int i = 1; i <= numbers.length(); i++) {
            len = i;
            ch = new int[len];
            DFS(0);
        }
        return primeList.size();
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution("17"));
    }
}