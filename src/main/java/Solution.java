import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

class Solution {
    static StringBuilder answer = new StringBuilder();
    static List<Character> entry = Arrays.asList('3', '6', '9');

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            String s = i + "";
            int cnt = 0;
            for (int j = 0; j < s.length(); j++) {
                if (entry.contains(s.charAt(j))) cnt++;
            }
            if (cnt == 0) {
                answer.append(i + " ");
                continue;
            }
            while (cnt > 0) {
                answer.append('-');
                cnt--;
            }
            answer.append(" ");
        }
        System.out.println(answer);
    }
}