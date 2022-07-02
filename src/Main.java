import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private int solution(int n, int t, int[][] arr) {
        int answer = 0;
        for (int a = 0; a < n - 1; a++) {
            for (int b = a + 1; b < n; b++) { // a 번째 학생과 b 번째 학생을 비교해나감
                int st1 = arr[0][a]; // a 번째 학생
                int st2 = arr[0][b]; // b 번째 학생
                int st1Inx = 0, st2Inx = 0;
                boolean flag = true;
                for (int i = 1; i < t; i++) { // 첫 번째 테스트는 건너 뛰고, 각 테스트를 돔
                    for (int j = 0; j < n; j++) { // a, b 학생이 각 테스트마다 몇 번째 인덱스에 위치해 있는지 파악
                        if (arr[i][j] == st1) st1Inx = j;
                        if (arr[i][j] == st2) st2Inx = j;
                    }
                    if (st1Inx > st2Inx) { // 순위가 어그러지면
                        flag = false;
                        break; // 해당 학생들의 케이스에 대한 비교는 break
                    }
                }
                if (flag) answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int[][] arr = new int[t][n];
        for (int i = 0; i < t; i++) {
            StringTokenizer tmp = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) arr[i][j] = Integer.parseInt(tmp.nextToken());
        }
        System.out.println(T.solution(n, t, arr));
    }
}