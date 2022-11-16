import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static StringBuilder answer = new StringBuilder();
    static StringTokenizer st;
    static int T, length, min, max, sum;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            initialize(br);
            answer.append("#" + test_case + " " + solution() + "\n");
        }
        System.out.println(answer);
    }

    private static int solution() {
        for (int x : arr) {
            if (x != min && x != max) sum += x;
        }
        return Math.round(sum / (float) (length - 2));
    }

    private static void initialize(BufferedReader br) throws IOException {
        st = new StringTokenizer(br.readLine());
        length = st.countTokens();
        arr = new int[length];
        sum = 0;
        for (int i = 0; i < length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 최대 최소값 구하기
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        for (int x : arr) {
            min = Math.min(min, x);
            max = Math.max(max, x);
        }
    }
}