import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int[] ch;

    static void DFS(int L) { // 1부터 시작해서 n까지 찾아나감
        if (L == n + 1) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= n; i++)
                if (ch[i] == 1) {
                    sb.append(i);
                    sb.append(" ");
                }
            if (!sb.equals(""))
                System.out.println(sb);

        } else {
            // 사용 함
            ch[L] = 1;
            DFS(L + 1);
            // 사용하지 않음
            ch[L] = 0;
            DFS(L + 1);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ch = new int[n + 1];
        DFS(1);
    }

}