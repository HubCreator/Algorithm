import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");

        int S = Integer.parseInt(st1.nextToken());
        int N = Integer.parseInt(st1.nextToken());
        int[] arr = new int[N];
        int[] cache = new int[S];
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st2.nextToken());


        for(int x : arr) {
            int pos = -1;
            for(int i = 0; i < S; i++)
                if(cache[i] == x) pos = i; // 같은 요소가 있는지 확인

            if(pos == -1) { // 같은 요소가 없다면 하나씩 오른쪽으로 밀어라
                for(int i = S-1; i >= 1; i--)
                    cache[i] = cache[i-1];
                cache[0] = x; // 맨 왼쪽에 요소 삽입
            } else { // 같은 요소가 있다면
                for(int i = pos; i >= 1; i--) // 그 요소의 인덱스부터 밀어라
                    cache[i] = cache[i-1];
                cache[0] = x;
            }
        }

        Arrays.stream(cache).forEach(x->System.out.print(x + " "));
    }
}