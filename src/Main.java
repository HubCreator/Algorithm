import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        List<Integer> result = new ArrayList<>();
        StringBuilder[] sb = new StringBuilder[n];
        int length = st.countTokens();
        for (int i = 0; i < length; i++) {
            sb[i] = new StringBuilder(st.nextToken()).reverse();
        }
        for (StringBuilder s : sb) {
            int t = Integer.parseInt(String.valueOf(s));
            int cnt = 0;
            for (int j = 1; j <= t; j++) {
//                if(cnt > 2) break;
                if (t % j == 0) cnt++;
            }
            if (cnt == 2) result.add(t);
        }

        for (Integer integer : result) {
            System.out.print(integer + " ");
        }
    }
}