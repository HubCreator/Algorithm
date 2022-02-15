import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N];
        ArrayList<Integer> answer = new ArrayList<>();

        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int[] arr_sorted = arr.clone(); // 깊은 복사
        Arrays.sort(arr_sorted);

        for(int i = 0; i < N; i++)
            if(arr[i] != arr_sorted[i])
                answer.add(i+1);

        answer.forEach(x->System.out.print(x+" "));
    }
}