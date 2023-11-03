import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static int[] dirs = new int[]{-1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        List<int[]> history = new ArrayList<>();

        for (int k = 0; k < n; k++) {
            for (int l = 0; l < n; l++) {
                history.clear();
                history.add(new int[]{k, l});

                OuterLoop:
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (checkHistory(history, i, j)) {
                            history.add(new int[]{i, j});
                        }
                        if (history.size() == n) {
                            answer++;
                            break OuterLoop;
                        }
                    }
                }

            }
        }

        System.out.println(answer);
    }

    private static boolean checkHistory(List<int[]> history, int i, int j) {
        for (int[] ints : history) {
            if (i == ints[0] ||
                    j == ints[1] ||
                    Math.abs(i - ints[0]) == Math.abs(j - ints[1])) {
                return false;
            }
        }
        return true;
    }
}