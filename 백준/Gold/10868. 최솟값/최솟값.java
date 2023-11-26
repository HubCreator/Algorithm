import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[] arr, minTree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        minTree = new int[N * 4];

        initMinTree(1, N, 1);

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st2.nextToken());
            int right = Integer.parseInt(st2.nextToken());
            answer.append(minFind(1, N, 1, left, right)).append('\n');
        }

        System.out.print(answer);
    }

    // left ~ right 범위 내에 최솟값을 찾음
    private static int minFind(int start, int end, int node, int left, int right) {
        if (right < start || end < left) { // 범위를 벗어난 경우
            return Integer.MAX_VALUE;
        }
        if (left <= start && end <= right) { // 범위를 정확하게 포함하는 경우
            return minTree[node];
        }

        int mid = (start + end) / 2;
        return Math.min(
                minFind(start, mid, node * 2, left, right),
                minFind(mid + 1, end, node * 2 + 1, left, right)
        );
    }

    // 각 구간 별로 최솟값을 저장
    private static int initMinTree(int start, int end, int node) {
        if (start == end) {
            return minTree[node] = arr[start];
        }
        int mid = (start + end) / 2;
        return minTree[node] = Math.min(
                initMinTree(start, mid, node * 2),
                initMinTree(mid + 1, end, node * 2 + 1)
        );
    }
}