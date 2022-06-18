import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    결정 알고리즘 
    - lt ~ rt 사이에 예상하는 답이 무조건 있을 때 사용 (이분 검색을 활용)
    - lt ~ rt는 정렬되어 있어야 함
    - mid = lt + rt / 2

    1. mid를 답으로 쓸 수 있냐? (답이 아니라 가능 여부)
    2. 가능한 값들을 결정하고, 더 최적화 시키는 방향
*/
public class Main {
    /* DVD 한 장의 capacity를 기준으로
     몇 장의 DVD에 담을 수 있는지 return */
    private int count(int[] arr, int capacity) {
        int cnt = 1, sum = 0;
        for (int x : arr) {
            if (sum + x > capacity) {
                cnt++;
                sum = x; // 다음 DVD의 초기 용량
            } else sum += x;
        }
        return cnt;
    }

    private int solution(int n, int m, int[] arr) {
        int answer = 0;
        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();
        while (lt <= rt) {
            int mid = (lt + rt) / 2; // 결정 기준
            // 이분 검색
            if (count(arr, mid) <= m) {
                answer = mid;
                rt = mid - 1;
            } else lt = mid + 1;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }
        System.out.println(T.solution(n, m, arr));
    }
}