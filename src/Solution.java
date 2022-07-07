import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(int[] answers) {
        int[] tmp = new int[3];
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        for (int i = 0; i < answers.length; i++) {
            if (a[i % a.length] == answers[i]) tmp[0]++;
            if (b[i % b.length] == answers[i]) tmp[1]++;
            if (c[i % c.length] == answers[i]) tmp[2]++;
        }

        int max = Arrays.stream(tmp).max().getAsInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < tmp.length; i++) {
            if(tmp[i] == max) list.add(i + 1);
        }
        return list.stream().mapToInt(i -> i.intValue()).toArray();
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int[] arr = {1, 3, 2, 4, 2};
        for (int x : T.solution(arr)) System.out.print(x + " ");
    }
}