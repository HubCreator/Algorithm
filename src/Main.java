import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 큰 수 출력하기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Integer[] arr = new Integer[n];
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        result.add(arr[0]);
        for (int i = 1; i < n; i++) {
            if(arr[i] > arr[i-1])
                result.add(arr[i]);
        }
        for (Integer integer : result) {
            System.out.print(integer + " ");
        }
    }
}