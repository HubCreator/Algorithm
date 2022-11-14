import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    static StringBuffer answer = new StringBuffer();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            answer.append("#" + test_case + " ");
            String enc = br.readLine();
            StringBuilder transformed = new StringBuilder();
            transform(enc, transformed);
            String binaryString = transformed.toString();
            int i;
            for (i = 0; i < binaryString.length() - 8; i += 8) {
                answer.append((char) Integer.parseInt(binaryString.substring(i, i + 8), 2));
            }
            answer.append(".\n");
        }
        System.out.println(answer);
    }

    private static void transform(String enc, StringBuilder result) {
        char[] chars = enc.toCharArray();
        for (char ch : chars) {
            if (Character.isUpperCase(ch)) {
                String s = Integer.toBinaryString((int) ch - 65);
                result.append(String.format("%06d", Integer.parseInt(s)));
            } else if (Character.isLowerCase(ch)) {
                String s = Integer.toBinaryString((int) ch - 71);
                result.append(String.format("%06d", Integer.parseInt(s)));
            } else if (Character.isDigit(ch)) {
                String s = Integer.toBinaryString(Integer.parseInt(String.valueOf(ch)) + 52);
                result.append(String.format("%06d", Integer.parseInt(s)));
            } else if (ch == '+') {
                String s = Integer.toBinaryString(62);
                result.append(String.format("%06d", Integer.parseInt(s)));
            } else if (ch == '/') {
                String s = Integer.toBinaryString(63);
                result.append(String.format("%06d", Integer.parseInt(s)));
            }
        }
    }
}