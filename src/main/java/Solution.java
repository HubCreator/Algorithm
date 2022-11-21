import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int N, K;
    static final List<String> entry = Arrays.asList("A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0");
    static List<Double> scores;
    static StringBuilder answer = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            initialize(br);
            answer.append("#" + test_case + " " + solution() + "\n");
        }
        System.out.println(answer);
    }

    private static String solution() {
        double target = scores.get(K - 1);
        Collections.sort(scores, Collections.reverseOrder());
        return entry.get(scores.indexOf(target) / (N / 10));
    }

    private static void initialize(BufferedReader br) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        scores = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            double totalScore = getTotalScore(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));
            scores.add(totalScore);
        }
    }

    private static double getTotalScore(int midEx, int finalEx, int hw) {
        return (midEx * 0.35 + finalEx * 0.45 + hw * 0.2);
    }
}