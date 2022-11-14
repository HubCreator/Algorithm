import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    static StringBuffer answer = new StringBuffer();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            char[] ch = br.readLine().toCharArray();
            int n = Integer.parseInt(ch[0] + "" + ch[1]);
            if (ch[2] - '0' >= 5) n += 1;
            int length = ch.length - 1;

            String resultNum = n + "";
            if (resultNum.length() > 2) length++;

            String result = resultNum.charAt(0) + "." + resultNum.charAt(1) + "*10^" + length;
            answer.append("#" + test_case + " " + result + "\n");
        }
        System.out.println(answer);
    }
}