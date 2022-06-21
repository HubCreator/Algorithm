import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = A.length - 1, j = B.length - 1; i >= 0; i--) {
            if (A[i] < B[j]) {
                answer++;
                j--;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int[] a = new int[]{5, 1, 3, 7};
        int[] b = new int[]{2, 2, 6, 8};
        int[] c = new int[]{2, 2, 2, 2};
        int[] d = new int[]{1, 1, 1, 1};
        System.out.println(T.solution(a, b)); // 3
        System.out.println(T.solution(c, d)); // 0
    }
}