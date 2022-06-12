import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 매출액의 종류
public class Main {
    private List<Integer> solution(int n, int k, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        int lt = 0;

        for (int i = 0; i < n - k + 1; i++) {
            for (int j = i; j < i + k; j++) {
                map.put(arr[j], map.getOrDefault(map.get(arr[j]), 0) + 1);
            }
            answer.add(map.size());
            map.remove(arr[lt++]);
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st1.nextToken());
        int k = Integer.parseInt(st1.nextToken());
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        List<Integer> solution = T.solution(n, k, arr);
        for (Integer x : solution) {
            System.out.print(x + " ");
        }
    }
}