import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    static StringBuilder answer = new StringBuilder();

    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            answer.append("#").append(test_case).append(" \n");
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];
            int cnt = 1, dirIdx = 0;
            int[] coords = {0, 0};
            while (cnt <= Math.pow(n, 2)) {
                arr[coords[0]][coords[1]] = cnt++;
                if (coords[0] + dir[dirIdx][0] < 0 || coords[0] + dir[dirIdx][0] >= n ||
                        coords[1] + dir[dirIdx][1] < 0 || coords[1] + dir[dirIdx][1] >= n || // arr 2차원 배열의 범위를 벗어나는지 체크
                        arr[coords[0] + dir[dirIdx][0]][coords[1] + dir[dirIdx][1]] != 0) { // 이미 초기화 되었는지 체크
                    dirIdx = (dirIdx + 1) % dir.length;
                }
                coords[0] += dir[dirIdx][0];
                coords[1] += dir[dirIdx][1];
            }
            for (int[] ints : arr) {
                for (int x : ints) {
                    answer.append(x).append(" ");
                }
                answer.append("\n");
            }

        }
        System.out.println(answer);
    }
}