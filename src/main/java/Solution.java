import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] answer = new int[T];

        for (int test_case = 1; test_case <= T; test_case++) {
            String str = br.readLine();
            char tmp = 'a';
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == tmp) {
                    tmp++;
                    continue;
                }
                break;
            }
            answer[test_case - 1] = tmp - 'a';
        }

        for (int i = 0; i < T; i++) {
            System.out.println("#" + (i + 1) + " " + answer[i]);
        }
    }
}