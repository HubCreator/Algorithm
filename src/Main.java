import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        StringBuilder res = new StringBuilder();

        int cnt = 1;
        for(int i = 0; i < n; i++) {
            String tmp = str.substring(7*(cnt-1), 7*cnt)
                    .replace('#', '1').replace('*', '0');
            int num = Integer.parseInt(tmp, 2); // 2진수를 10진수로 변환
            res.append((char)num);
            cnt++;
        }
        System.out.println(res);
    }
}