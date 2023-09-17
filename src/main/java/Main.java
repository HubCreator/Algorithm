import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int result = 0, idx = 0, lastIdx = arr.length - 1;
        while (arr[lastIdx] != 0) {
            Arrays.sort(arr);
            if (idx == lastIdx) {
                result += arr[lastIdx];
                break;
            }
            arr[idx] -= 1;
            arr[lastIdx] -= 1;
            if (arr[idx] == 0) {
                idx += 1;
            }
            result += 1;
        }
        int answer = result > 1440 ?
                -1 :
                result;
        System.out.println(answer);
    }
}
