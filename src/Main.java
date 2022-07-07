import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private int canPut(int[] arr, int c) { // m : cd의 갯수, c : cd 하나의 용량
        int cnt = 1, sum = 0;
        int idx = 0;
        while (idx < arr.length) {
            sum += arr[idx];
            if (sum > c) {
                sum = arr[idx];
                cnt++;
            }
            idx++;
        }
        return cnt;
    }

    private int solution(int n, int m, int[] arr) {
        Arrays.sort(arr);
        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();
        int mid = 0;
        while (lt <= rt) {
            mid = (lt + rt) / 2;
            int t = canPut(arr, mid);
            if (t == m) return mid;
            else if (t > m) lt = mid + 1; // 용량을 더 키움
            else rt = mid - 1;
        }
        return mid;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringTokenizer tmp = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(tmp.nextToken());
        System.out.println(T.solution(n, m, arr));
    }
}