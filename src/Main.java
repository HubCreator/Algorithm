import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int count(int[] arr, int dist) { // 유효한지 판별
        int cnt = 1;        // 배치한 말의 마리 수
        int ep = arr[0];    // 말을 배치한 좌표
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] - ep >= dist) {
                cnt++;
                ep = arr[i];
            }
        }
        return cnt;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st1.nextToken());
        int C = Integer.parseInt(st1.nextToken()) ;
        int[] arr = new int[N];
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st2.nextToken());

        Arrays.sort(arr); // 오름차순 정렬
        int lt = 1, rt = arr[arr.length-1];
        int answer = 0;

        while(lt <= rt) { // 이분 검색
            int mid = (lt + rt) / 2;
            if(count(arr, mid) >= C) {
                answer = mid;
                lt = mid + 1;
            } else rt = mid - 1;
        }

        System.out.println(answer);
    }
}