import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st1.nextToken());
        int K = Integer.parseInt(st1.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N];
        for (int index = 0; index < N; index++) {
            arr[index] = Integer.parseInt(st2.nextToken());
        }

        Map<Integer, Integer> map = new HashMap<>();
        int rt, lt = 0, answer = Integer.MIN_VALUE;

        for (rt = 0; rt < N; rt++) {
            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
            if (map.get(arr[rt]) > K) {
                while (arr[lt] != arr[rt]) {
                    lt++;
                }
                lt++;
                map.put(arr[rt], map.get(arr[rt]) - 1);
            }
            answer = Math.max(answer, rt - lt + 1);
        }
        System.out.println(answer);
    }
}