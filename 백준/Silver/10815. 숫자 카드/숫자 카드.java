import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] hand = new int[N];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            hand[i] = Integer.parseInt(st1.nextToken());
        }
        Arrays.sort(hand);

        int M = Integer.parseInt(br.readLine());
        answer = new int[M];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st2.nextToken());
            solution(i, hand, target);
        }

        StringBuilder sb = new StringBuilder();
        for (int a : answer) {
            sb.append(a).append(' ');
        }
        System.out.print(sb);
    }

    private static void solution(int idx, int[] hand, int target) {
        int lt = 0, rt = hand.length - 1, mid;
        while (lt <= rt) {
            mid = (lt + rt) / 2;
            if (hand[mid] < target) {
                lt = mid + 1;
            } else if (hand[mid] > target) {
                rt = mid - 1;
            } else {
                answer[idx] = 1;
                break;
            }
        }
    }
}