import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

class Solution {
    public static StringBuilder answer = new StringBuilder();

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        long T = sc.nextLong();

        for (long test_case = 0; test_case < T; test_case++) {
            solution(sc, test_case);
        }

        System.out.println(answer);
    }

    private static void solution(Scanner sc, long test_case) {
        List<Long> list = new ArrayList<>();
        long length, tmp, sum = 0;

        answer.append("#").append(test_case + 1);
        length = sc.nextLong();
        tmp = sc.nextLong();

        for (int i = 1; i <= length; i++) {
            long target = i == length ?
                    Long.MIN_VALUE :
                    sc.nextLong();
            if (tmp <= target) {
                list.add(tmp);
            } else if (!list.isEmpty()) {
                for (Long x : list) sum += tmp - x;
                list.clear();
            }
            tmp = target;
        }
        answer.append(" ").append(sum).append("\n");
    }
}