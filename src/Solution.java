import java.util.Arrays;

class Solution {
    public int solution(int n, int m, int[] arr) {
        Arrays.sort(arr);
        int lt = 0, rt = n - 1, mid;

        while (lt <= rt) {
            mid = (lt + rt) / 2;
            if (arr[mid] == m) return mid + 1;
            else if (arr[mid] < m) lt = mid + 1;
            else rt = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int n = 8;
        int m = 32;
        int[] arr = {23, 87, 65, 12, 57, 32, 99, 81};
        System.out.println(T.solution(n, m, arr));
    }
}