import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            int t = Integer.parseInt(st.nextToken());
            treeMap.put(t, treeMap.getOrDefault(t, 0) + 1);
        }

        boolean flag;
        do {
            flag = false;
            for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
                if (entry.getValue() > 0) {
                    treeMap.put(entry.getKey(), entry.getValue() - 1);
                    flag = true;
                }
            }
            if (flag) {
                answer++;
            }
        } while (flag);
        System.out.print(answer);
    }
}
