import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Solution {
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            answer.append('#').append(i).append(' ');
            StringBuilder s = new StringBuilder(br.readLine());
            long square = s.length() - 1;
            while (s.charAt(s.length() - 1) == '0') {
                s.setLength(s.length() - 1);
            }
            double num = Double.parseDouble(s.toString());
            DecimalFormat df = new DecimalFormat("0.0");
            double result = Double.parseDouble(df.format(num / (long) Math.pow(10, (long) Math.log10(num))));
            if (String.valueOf(result).charAt(0) != String.valueOf(num).charAt(0)) {
                square++;
                result /= 10d;
            }
            answer.append(result).append("*10^").append(square).append("\n");
        }
        System.out.println(answer);
    }
}