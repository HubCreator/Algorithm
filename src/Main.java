import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    static int n, k;
    static int[] arr, ch;
    static TreeSet<Integer> tSet = new TreeSet<>(Collections.reverseOrder());

    private void DFS(int L, int s) {
        if (L == k) {
            int sum = 0;
            for (int x : ch) sum += arr[x];
            tSet.add(sum);
        } else {
            for (int i = s; i < arr.length; i++) {
                ch[L] = i;
                DFS(L + 1, i + 1);
            }
        }
    }

    private int solution() {
        int cnt = 0;
        for (Integer x : tSet) {
            cnt++;
            if(cnt == k) return x;
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st1.nextToken());
        k = Integer.parseInt(st1.nextToken());
        arr = new int[n];
        ch = new int[k];
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st2.nextToken());
        T.DFS(0, 0);
        System.out.println(T.solution());;

    }
}