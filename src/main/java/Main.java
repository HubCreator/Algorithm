import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] split = input.split(" ");
        int N = Integer.parseInt(split[0]);
        int K = Integer.parseInt(split[1]);

        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Queue<Integer> queue = new ArrayDeque<>(N);
        int lt = 0, cnt = 0, answer = Integer.MIN_VALUE;

        for (int rt = 0; rt < N; rt++) {
            if (queue.contains(arr[rt])) {
                cnt++;
            }
            while (cnt == K) {
                if (arr[lt] == arr[lt + 1]) {
                    cnt--;
                    break;
                }
                lt++;
            }
            queue.offer(arr[rt]);
            answer = Math.max(answer, rt - lt + 1);
        }
        System.out.println(answer);
    }
}