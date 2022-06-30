import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dy;
    private void solution(int n) {
        if(n == 1) dy[n] = 1;
        else if(n == 2) dy[n] = 2;
        else {
            dy[n] = dy[n - 2] + dy[n - 1];
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dy = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            T.solution(i);
        }
        System.out.println(dy[n]);
    }
}