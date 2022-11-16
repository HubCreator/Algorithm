import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static StringBuilder answer = new StringBuilder();
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine().trim());
        for (int test_case = 1; test_case <= T; test_case++) {
            answer.append("#" + test_case + " " + solution(br) + "\n");
        }
        System.out.println(answer);
    }

    private static int solution(BufferedReader br) throws IOException {
        String str = br.readLine().trim();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length() - 1; i++) {
            sb.append(str.charAt(i));
            if (isValid(str, sb)) {
                return sb.length();
            }
        }
        return -1;
    }

    private static boolean isValid(String str, StringBuilder sb) {
        return new StringTokenizer(str, sb.toString()).countTokens() == 0;
    }
}