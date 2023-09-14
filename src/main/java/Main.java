import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[][] fibo = new int[41][];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        initFibo();
        for (int i = 0; i < t; i++) {
            int input = Integer.parseInt(br.readLine());
            int[] result = fibo[input];
            System.out.println(result[0] + " " + result[1]);
        }
    }

    private static void initFibo() {
        for (int i = 0; i < fibo.length; i++) {
            if (i == 0) {
                fibo[i] = new int[]{0, 1};
            } else if (i == 1) {
                fibo[i] = new int[]{1, 0};
            } else {
                fibo[i] = new int[]{
                        fibo[i-2][0] + fibo[i-1][0],
                        fibo[i-2][1] + fibo[i-1][1]
                };
            }
        }
    }
}
