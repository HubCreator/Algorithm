import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static StringTokenizer st;
    static StringBuilder answer = new StringBuilder();
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            answer.append("#").append(Integer.parseInt(br.readLine())).append(" ");
            st = new StringTokenizer(br.readLine());
            init();
            int length = st.countTokens();

            for (int i = 0; i < length; i++) {
                int t = Integer.parseInt(st.nextToken());
                list.set(t, list.get(t) + 1);
            }
            Integer max = Collections.max(list);
            answer.append(list.lastIndexOf(max)).append("\n");
        }
        System.out.println(answer);
    }

    private static void init() {
        list = new ArrayList<>(101);
        for (int i = 0; i < 101; i++) {
            list.add(0);
        }
    }
}