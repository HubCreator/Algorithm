import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static StringBuilder answer = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            String s1 = st.nextToken();
            String s2 = st.nextToken();
            answer.append("#" + test_case + " " + solution(s1, s2) + "\n");
        }
        System.out.println(answer);
    }

    private static String solution(String s1, String s2) {

        if (s1.equals(s2)) return "yes";
        if (s1.indexOf(s2) == 0) {
            int idx = 0;
            StringBuilder sb = new StringBuilder(s1);
            while (sb.length() % s2.length() != 0) {
                sb.append(s1.charAt(idx++));
            }
            if (sb.lastIndexOf(s2) == sb.length() - s2.length()) return "yes";
        } else if (s2.indexOf(s1) == 0) {
            int idx = 0;
            StringBuilder sb = new StringBuilder(s2);
            while (sb.length() % s1.length() != 0) {
                sb.append(s2.charAt(idx++));
            }
            if (sb.lastIndexOf(s1) == sb.length() - s1.length()) return "yes";
        }
        return "no";
    }
}