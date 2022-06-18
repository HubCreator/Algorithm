import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 메모이제이션
public class Main {
    public static int[] fibo;

    private int DFS(int n) {
        if (fibo[n] > 0) return fibo[n]; // 값을 이미 구해놨으면 재귀를 돌지말고 바로 값 리턴
        if (n == 1) return fibo[n] = 1;
        else if (n == 2) return fibo[n] = 1;
        else return fibo[n] = DFS(n - 2) + DFS(n - 1);
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        fibo = new int[n + 1];
        T.DFS(n);

        for (int i = 1; i <= n; i++) {
            System.out.print(fibo[i] + " ");
        }
    }
}