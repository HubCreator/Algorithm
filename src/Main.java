import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer[] st = new StringTokenizer[n];
        for(int i = 0; i < n; i++)
            st[i] = new StringTokenizer(br.readLine(), " ");
        int[][] nums = new int[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                nums[i][j] = Integer.parseInt(st[i].nextToken());

        int max = Integer.MIN_VALUE;
        int sum1, sum2;
        for(int i = 0; i < n; i++) {
            sum1 = sum2 = 0;
            for(int j = 0; j < n; j++) {
                sum1 += nums[i][j]; // 행 누적
                sum2 += nums[j][i]; // 열 누적
            }
            max = Math.max(sum1, max);
            max = Math.max(sum2, max);
        }
        sum1 = sum2 = 0;
        for(int i = 0; i < n; i++) {
            sum1 += nums[i][i];
            sum2 += nums[i][n-i-1];
            max = Math.max(sum1, max);
            max = Math.max(sum2, max);
        }

        System.out.println(max);
    }
}