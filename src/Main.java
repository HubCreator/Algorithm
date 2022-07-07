import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 재귀 피보나치
public class Main {
    int[] fiboArr;

    private int fibo(int v) {
        if(fiboArr[v] > 0) return fiboArr[v];
        if(v == 1) return fiboArr[v] =  1;
        else if(v == 2) return fiboArr[v] = 1;
        else return fiboArr[v] = fibo(v - 2) + fibo(v - 1);
    }

    private void solution(int n) {
        fiboArr = new int[n + 1];
        fibo(n);
        for (int i = 1; i < n; i++) System.out.print(fiboArr[i] + " ");
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        T.solution(n);
    }
}