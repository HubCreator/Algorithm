import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 배열 깊은복사, 정렬 비교
public class Main {
    private List<Integer> solution(int n, int[] arr) {
        List<Integer> answer = new ArrayList<>();
        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        for (int i = 0; i < n; i++) {
            if(arr[i] != sorted[i])
                answer.add(i + 1);
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int x : T.solution(n, arr)) {
            System.out.print(x + " ");
        }
    }
}