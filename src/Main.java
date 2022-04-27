import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st1.nextToken());
        int K = Integer.parseInt(st1.nextToken());
        int[] num = new int[N];

        for(int i = 0; i < N; i++)
            num[i] = Integer.parseInt(st2.nextToken());

        int lt = 0, cnt = 0, answer = 0;
        for(int rt = 0; rt < N; rt++) {
            if(num[rt] == 0) cnt++;
            while(cnt > K) {
                if(num[lt] == 0) cnt--;
                lt++;
            }
            answer = Math.max(answer, rt - lt + 1);
        }
        System.out.println(answer);
    }
}