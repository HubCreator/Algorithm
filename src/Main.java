import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] score, time, ch;
    static int n, m;
    static List<Integer> answer = new ArrayList<>();

    private void DFS(int L) {
        if (L == n + 1) {
            int scoreSum = 0, timeSum = 0;
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 1) {
                    scoreSum += score[i];
                    timeSum += time[i];
                }
            }
            if (timeSum <= m)
                answer.add(scoreSum);
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
        n = Integer.parseInt(st.nextToken()); // 문제의 갯수
        m = Integer.parseInt(st.nextToken()); // 제한 시간
        StringTokenizer[] stArr = new StringTokenizer[n + 1];
        score = new int[n + 1];
        time = new int[n + 1];
        ch = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            stArr[i] = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(stArr[i].nextToken());
            int t = Integer.parseInt(stArr[i].nextToken());
            score[i] = s;
            time[i] = t;
        }
        T.DFS(1);
        System.out.println(Collections.max(answer));
    }
}