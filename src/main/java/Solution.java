import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        String str;
        char tmp;

        for (int test_case = 1; test_case <= T; test_case++) {
            str = br.readLine();
            tmp = 'a';
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == tmp) tmp++;
                else break;
            }
            sb.append("#").append(test_case).append(' ').append(tmp - 'a').append("\n");
        }
        System.out.println(sb);
    }
}