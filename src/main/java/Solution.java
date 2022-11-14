import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.MessageFormat;

class Solution {
    static StringBuffer answer = new StringBuffer();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            answer.append("#").append(test_case).append(" ");
            char[] ch = br.readLine().toCharArray();
            int length = ch.length - 1;
            int n = Integer.parseInt(ch[0] + "" + ch[1]);

            if (ch[2] - '0' >= 5) n += 1;
            String resultNum = String.valueOf(n);
            if (resultNum.length() > 2) length = ch.length;

            String result = MessageFormat.format("{0}.{1}*10^{2}", resultNum.charAt(0), resultNum.charAt(1), length);
            answer.append(result).append("\n");
        }
        System.out.println(answer);
    }
}