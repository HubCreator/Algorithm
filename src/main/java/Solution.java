import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            String str = br.readLine();
            answer.append("#" + test_case + " " + solution(str) + "\n");
        }
        System.out.println(answer);
    }

    private static int solution(String str) {
        char[] chars = str.toCharArray();
        boolean flag = false;
        int count = 0;

        for (int i = 0; i < chars.length; i++) {
            int idx = i;
            if (chars[idx] == '1') {
                flag = true;
                while (idx < chars.length) {
                    chars[idx] = chars[idx] == '1' ? '0' : '1';
                    idx++;
                }
            }
            if (flag) {
                count++;
                flag = false;
            }
        }
        return count;
    }
}