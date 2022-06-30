import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr, dy;
    private void solution(int n) {
        if(n == 0) dy[n] = 1;
        else {
            int cnt = 1;
            for (int i = 0; i < n; i++) {
                if(arr[n] > arr[i]) cnt = Math.max(cnt, dy[i] + 1);
            }
            dy[n] = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dy = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) T.solution(i);
        System.out.println(Arrays.stream(dy).max().getAsInt());;
    }
}