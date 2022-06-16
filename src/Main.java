import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 삽입 정렬
public class Main {
    private int[] solution(int n, int[] arr) {
        for (int i = 1; i < n; i++) {
            int tmp = arr[i], j;
            for (j = i - 1; j >= 0; j--) {              // i기준 왼쪽 요소들을 체크
                if(arr[j] > tmp) arr[j + 1] = arr[j];   // i번째 요소보다 크면 오른쪽으로 한 칸 밀어라
                else break;
            }
            arr[j + 1] = tmp;
        }
        return arr;
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
        for (int i : T.solution(n, arr)) {
            System.out.print(i + " ");
        }
    }
}