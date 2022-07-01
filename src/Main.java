import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private boolean isPrime(int v) {
        if(v == 1) return false;
        for (int i = 2; i < v; i++) {
            if(v % i == 0) return false; // 나누어 떨어지는 것이 있으면 소수가 아님
        }
        return true;
    }

    private List<Integer> solution(int n, int[] arr) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) { // 소수인지 체크
            if(isPrime(arr[i])) answer.add(arr[i]);
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder(st.nextToken());
            arr[i] = Integer.parseInt(String.valueOf(sb.reverse()));
        }
        for (Integer x : T.solution(n, arr)) System.out.print(x + " ");
    }
}