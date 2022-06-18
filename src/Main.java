import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 재귀
public class Main {
    private void solution(int n) {
        if(n == 0) return;
        solution(n - 1);
        System.out.print(n + " ");
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        T.solution(n);
    }
}