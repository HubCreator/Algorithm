import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private List<Integer> solution(int n, int[] arr) {
        List<Integer> answer = new ArrayList<>();
        int[] cloned = arr.clone();
        Arrays.sort(cloned);
        for (int i = 0; i < n; i++) {
            if(arr[i] != cloned[i]) answer.add(i + 1);
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        for (Integer x : T.solution(n, arr)) System.out.print(x + " ");
    }
}