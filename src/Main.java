import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m, answer = Integer.MIN_VALUE;
    static int[] score, limit, ch;

    private void DFS(int L) {
        if (L == n) { // 모두 다 돌고, 제한 시간 안에 다 풀었다면
            int limitSum = 0, scoreSum = 0;
            for (int i = 0; i < n; i++) {
                if (ch[i] == 1) {
                    limitSum += limit[i];
                    scoreSum += score[i];
                }
            }
            if (limitSum <= m) answer = Math.max(answer, scoreSum);
        } else {
            ch[L] = 1;
            DFS(L + 1);
            ch[L] = 0;
            DFS(L + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken()); // 문제 개수
        m = Integer.parseInt(st.nextToken()); // 제한 시간
        score = new int[n + 1];
        limit = new int[n + 1];
        ch = new int[n + 1];
        for (int i = 0; i < n; i++) {
            StringTokenizer tmp = new StringTokenizer(br.readLine(), " ");
            score[i] = Integer.parseInt(tmp.nextToken());
            limit[i] = Integer.parseInt(tmp.nextToken());
        }
        T.DFS(0);
        System.out.println(answer);
    }
}