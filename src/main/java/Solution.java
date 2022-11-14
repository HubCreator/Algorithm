import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static int n;
    static int[] data;
    static int cnt;
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            cnt = 0;
            n = Integer.parseInt(br.readLine()); // n*n크기의 체스판
            data = new int[n]; // n크기의 1차원 배열

            queen(0); // depth 0을 넣어줌
            answer.append("#" + test_case + " " + cnt + "\n");
        }
        System.out.println(answer);
    }

    public static void queen(int depth) {
        if (depth == n) {
            cnt++;
            return;
        }
        for (int i = 0; i < n; i++) {
            data[depth] = i;
            if (check(depth)) queen(depth + 1);
        }
    }

    public static boolean check(int depth) {
        for (int i = 0; i < depth; i++) {
            if (data[depth] == data[i]) return false;
            else if (Math.abs(depth - i) == Math.abs(data[depth] - data[i])) return false;
        }
        return true;
    }
}