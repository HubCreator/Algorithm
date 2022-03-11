import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer[] tmp = new StringTokenizer[N];
        int[][] arr = new int[N][N];
        Stack<Integer>[] stacks = new Stack[N];
        int answer = 0;
        Stack<Integer> bucket = new Stack<>();

        for(int i = 0; i < N; i++)
            tmp[i] = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                arr[i][j] = Integer.parseInt(tmp[i].nextToken());

        int M = Integer.parseInt(br.readLine());
        int[] moves = new int[M];
        StringTokenizer tmp2 = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < M; i++)
            moves[i] = Integer.parseInt(tmp2.nextToken());

        for(int i = 0; i < N; i++) // stack 생성
            stacks[i] = new Stack<>();

        for(int i = 0; i < N; i++) { // stack에 값 push
            for (int j = N-1; j >= 0; j--) {
                if (arr[j][i] == 0) continue;
                stacks[i].add(arr[j][i]);
            }
        }

        for(int i = 0; i < M; i++) {
            if(stacks[moves[i]-1].isEmpty()) continue;

            int target = stacks[moves[i]-1].pop();
            if(!bucket.isEmpty()) {
                if(target == bucket.peek()) {
                    bucket.pop();
                    answer += 2;
                }
                else
                    bucket.push(target);
            } else
                bucket.push(target);
        }
        System.out.println(answer);
    }
}