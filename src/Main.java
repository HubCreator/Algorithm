import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st1.nextToken());
        int M = Integer.parseInt(st1.nextToken());
        int[] arr = new int[N];
        int lt = 0, rt = N-1, answer = 0;

        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st2.nextToken());

        Arrays.sort(arr);
        while(lt <= rt) {
            int mid = (lt + rt) / 2;
            if(arr[mid] == M) {
                answer = mid + 1;
                break;
            }
            else if (arr[mid] > M) rt = mid-1;
            else lt = mid+1;
        }

        System.out.println(answer);
    }
}