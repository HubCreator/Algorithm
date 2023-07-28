import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 시간 복잡도 : O(n)
// 공간 복잡도 : O(n)
public class Main {
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] result = T.solution(arr);
        System.out.println(result[0] + " " + result[1]);
    }

    private int[] solution(int[] arr) {
        int[] copied = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copied);
        int[] result = new int[2];
        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != copied[i]) {
                result[index++] = i + 1;
            }
        }
        return result;
    }
}
