import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] checkBit = new int[n+1];
        int cnt = 0;
        if(n < 2 || n > 2000000) return;

        for(int i = 2; i <= n; i++) {
            if(checkBit[i] == 0) {
                cnt++;
                for(int j = i; j <= n; j = j + i)
                    checkBit[j] = 1;
            }
        }

        System.out.println(cnt);
    }
}