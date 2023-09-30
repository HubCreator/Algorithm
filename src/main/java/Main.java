import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken());
        int K = Integer.parseInt(st1.nextToken());
        int M = Integer.parseInt(st1.nextToken());
        List<Set<Integer>> board = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            board.add(new HashSet<>());
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int[] arr = new int[K];
            for (int j = 0; j < K; j++) {
                arr[j] = Integer.parseInt(st2.nextToken());
            }
            for (int j = 0; j < arr.length; j++) {
                for (int k = 0; k < arr.length; k++) {
                    if (j == k) {
                        continue;
                    }
                    board.get(arr[j]).add(arr[k]);
                }
            }
        }
        System.out.println(bfs(board, N));
    }

    private static int bfs(List<Set<Integer>> board, int end) {
        Queue<Integer> queue = new ArrayDeque<>(board.get(1));
        List<Integer> check = new ArrayList<>();
        check.add(1);
        int count = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            count += 1;
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                if (poll == end) {
                    return count;
                }
                check.add(poll);
                Set<Integer> nextSteps = board.get(poll);
                for (Integer nextStep : nextSteps) {
                    if (!check.contains(nextStep)) {
                        queue.offer(nextStep);
                    }
                }
            }

        }
        return -1;
    }
}
