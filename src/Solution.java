import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(int n, int[] _arr1, int m, int[] _arr2) {
        List<Integer> answer = new ArrayList<>();
        int[] arr1 = _arr1.clone();
        int[] arr2 = _arr2.clone();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int p1 = 0, p2 = 0;
        while (p1 < n && p2 < m) {
            if (arr1[p1] == arr2[p2]) {
                answer.add(arr1[p1]);
                p1++;
                p2++;
            } else if (arr1[p1] < arr2[p2]) p1++;
            else p2++;
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int n = 5;
        int[] arr1 = {1, 3, 9, 5, 2};
        int m = 5;
        int[] arr2 = {3, 2, 5, 7, 8};

        for (int x : T.solution(n, arr1, m, arr2)) {
            System.out.print(x + " ");
        }
    }
}