import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        char[] str = st.nextToken().toCharArray();
        char chr = st.nextToken().charAt(0);
        int[] answer = new int[str.length];

        int cnt = 1000;
        for(int i = 0; i < str.length; i++) {
            if(str[i] == chr) {
                cnt = 0;
                answer[i] = 0;
            } else {
                cnt += 1;
                answer[i] = cnt;
            }
        }
        cnt = 1000;
        for (int i = str.length-1; i >= 0; i--) {
            if(str[i] == chr) cnt = 0;
            else {
                cnt += 1;
                answer[i] = Math.min(cnt, answer[i]);
            }
        }
        for(int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}