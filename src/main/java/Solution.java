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
        int idx = 0;
        while (s1.length() < s2.length() && s2.length() % s1.length() != 0) {
            s2 += s2.charAt(idx++);
        }
        while (s1.length() > s2.length() && s1.length() % s2.length() != 0) {
            s1 += s1.charAt(idx++);
        }

        int offsetA = 0, offsetB = 0;
        while (s1.indexOf(s2, offsetA) == offsetA) {
            offsetA += s2.length();
        }
        while (s2.indexOf(s1, offsetB) == offsetB) {
            offsetB += s1.length();
        }
        if (offsetA == s1.length() || offsetB == s2.length()) return "yes";

        return "no";
    }
}