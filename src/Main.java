import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static List<List<Integer>> list;
    public static int v, e;
    public static int ch[];
    public static int answer = 0;

    private void DFS(int val) {
        if (val == v) {
            answer++;
        } else {
            for (int t : list.get(val)) {
                if (ch[t] == 0) {
                    ch[t] = 1;
                    DFS(t);
                    ch[t] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        ch = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            list.add(new ArrayList<>(i));
        }
        StringTokenizer[] stArr = new StringTokenizer[e];
        for (int i = 0; i < e; i++) {
            stArr[i] = new StringTokenizer(br.readLine(), " ");
            int _v = Integer.parseInt(stArr[i].nextToken());
            int _e = Integer.parseInt(stArr[i].nextToken());
            list.get(_v).add(_e);
        }

        ch[1] = 1;
        T.DFS(1);
        System.out.println(answer);
    }
}