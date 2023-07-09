import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시간 복잡도 : O(1)
// 공간 복잡도 : O(1)
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] price = new int[3];
        for (int i = 0; i < price.length; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int answer = (price[0] * x) + (price[1] * y);
        if (x < y) {
            answer = Math.min(answer, (price[2] * 2 * x) + (price[1] * (y - x)));
        } else if (x > y) {
            answer = Math.min(answer, (price[2] * 2 * y) + (price[0] * (x - y)));
        }
        answer = Math.min(answer, (price[2] * 2) * Math.max(x, y));
        System.out.println(answer);
    }
}
