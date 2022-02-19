import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N];
        boolean flag = true;

        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        for(int i = 0; i < arr.length-1; i++)
            if(arr[i] == arr[i+1]) {
                flag = false;
                break;
            }

        System.out.print(flag ? "U" : "D");
    }
}