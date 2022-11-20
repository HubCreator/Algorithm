import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            String num = br.readLine();
            char[] ch = num.toCharArray();
            int min = Integer.parseInt(num);
            int max = min;

            for (int i = 0; i < ch.length - 1; i++) {
                for (int j = i + 1; j < ch.length; j++) {
                    char tmp = ch[i];
                    ch[i] = ch[j];
                    ch[j] = tmp;
                    if (ch[0] != '0') { // min, max 값 갱신
                        min = Math.min(min, Integer.parseInt(String.valueOf(ch)));
                        max = Math.max(max, Integer.parseInt(String.valueOf(ch)));
                    }
                    // 원본으로 돌려놓음
                    tmp = ch[i];
                    ch[i] = ch[j];
                    ch[j] = tmp;
                }
            }
            answer.append("#" + test_case + " " + min + " " + max + "\n");
        }
        System.out.println(answer);
    }
}