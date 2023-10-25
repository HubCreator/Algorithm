import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken());
        int M = Integer.parseInt(st1.nextToken());
        Queue<int[]> queue = new ArrayDeque<>();
        List<int[]> area1 = new ArrayList<>();
        List<int[]> area2 = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            queue.offer(new int[]{Integer.parseInt(st2.nextToken()), Integer.parseInt(st2.nextToken())});
        }
        int answer = 0;
        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            boolean flag = false;
            for (int[] ints : queue) {
                if (arr[0] < ints[0]) {
                    queue.offer(arr);
                    answer += arr[1];
                    flag = true;
                    break;
                }
            }
            if (flag) continue;
            if (area1.isEmpty()) {
                area1.add(arr);
                answer += arr[1];
            } else {
                while (!area1.isEmpty() &&
                        area1.get(area1.size() - 1)[0] <= arr[0] &&
                        area1.get(area1.size() - 1)[1] < arr[1]) {
                    int[] removed = area1.remove(area1.size() - 1);
                    answer += removed[1];
                    area2.add(removed);
                }
                area1.add(arr);
                answer += arr[1];
                while (!area2.isEmpty()) {
                    int[] removed = area2.remove(area2.size() - 1);
                    answer += removed[1];
                    area1.add(removed);
                }
            }
        }
        System.out.println(answer);
    }
}
