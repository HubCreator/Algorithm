import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // 공통 원소 오름차순 출력
    public List<Integer> solution(int n1, int[] arr1, int n2, int[] arr2) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n1; i++) {
            map.put(arr1[i], 1);
        }
        for (int i = 0; i < n2; i++) {
            if (map.get(arr2[i]) == null) {
                map.put(arr2[i], 1);
            } else
                map.put(arr2[i], map.get(arr2[i]) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                result.add(entry.getKey());
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n1 = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        int n2 = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];
        for (int i = 0; i < n1; i++) {
            arr1[i] = Integer.parseInt(st1.nextToken());
        }
        for (int i = 0; i < n2; i++) {
            arr2[i] = Integer.parseInt(st2.nextToken());
        }

        for (Integer x : T.solution(n1, arr1, n2, arr2)) {
            System.out.print(x + " ");
        }
    }
}