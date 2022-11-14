import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static int n;
    static int[] ch;
    static int cnt;
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            cnt = 0;
            n = Integer.parseInt(br.readLine()); // n*n크기의 체스판
            ch = new int[n]; // n크기의 1차원 배열
            dfs(0); // depth 0을 넣어줌
            answer.append("#" + test_case + " " + cnt + "\n");
        }
        System.out.println(answer);
    }

    public static void dfs(int L) {
        // 기저 조건
        if (L == n) {
            cnt++;
            return;
        }
        for (int i = 0; i < n; i++) {
            ch[L] = i; // check 배열의 각 인덱스엔 몇 번째 col을 넣을지 저장
            if (isValid(L)) dfs(L + 1);
        }
    }

    public static boolean isValid(int L) {
        for (int i = 0; i < L; i++) {
            if (ch[L] == ch[i]) {
                // 같은 열을 선택했는지 체크
                return false;
            } else if (Math.abs(L - i) == Math.abs(ch[L] - ch[i])) {
                 // 대각선 상에 있는지 체크 (기울기 1 : x증가량 == y증가량)
                return false;
            }
        }
        return true;
    }
}