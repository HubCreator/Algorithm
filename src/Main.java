import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeSet;

// K 번째 큰 수 구하기
public class Main {
    private int solution(int n, int k, int[] arr) {
        TreeSet<Integer> tset = new TreeSet<>(Collections.reverseOrder()); // 내림차순 자동 정렬
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int l = j + 1; l < n; l++) {
                    tset.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }
        int cnt = 0;
        for (Integer x : tset) {
            cnt++;
            if(cnt == k) return x;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st1.nextToken());
        int k = Integer.parseInt(st1.nextToken());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }
        System.out.println(T.solution(n, k, arr));
        
    }
}