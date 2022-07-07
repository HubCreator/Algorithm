class Solution {
    int[] ch, arr;
    int answer = 0;

    boolean isPrime(int v) {
        for (int i = 2; i < v - 1; i++) {
            if (v % i == 0) return false;
        }
        return true;
    }

    private void DFS(int L, int s) {
        if (L == 3) {
            int sum = 0;
            for (int x : ch) sum += arr[x];
            if (isPrime(sum)) answer++;

        } else {
            for (int i = s; i < arr.length; i++) {
                ch[L] = i;
                DFS(L + 1, i + 1);
            }
        }
    }

    public int solution(int[] nums) {
        arr = nums;
        ch = new int[3];
        DFS(0, 0);

        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int[] asdf = {1, 2, 7, 6, 4};
        System.out.println(T.solution(asdf));
    }
}