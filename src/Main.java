import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 재귀 -> 팩토리얼
public class Main {
    private int DFS(int n) {
        if(n == 1) return 1;
        else return n * DFS(n - 1);
    }
    
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(T.DFS(n));;
    }
}