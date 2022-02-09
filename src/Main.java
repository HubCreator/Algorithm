import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static int count = -1;

    public static void BFS(int s, int t) {
        count++;
        if (s == t) {
            return;
        } else {
            if (s + 3 < t) BFS(s + 5, t);
            else if (s < t) BFS(s + 1, t);
            else BFS(s - 1, t);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int S = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        BFS(S, T);
        System.out.println(count);
    }
}