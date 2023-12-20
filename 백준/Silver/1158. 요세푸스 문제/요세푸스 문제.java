import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()) - 1;
        int index = 0;
        List<Integer> list = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(i + 1);
        }
        while (!list.isEmpty()) {
            index = (index + K) % list.size();
            result.add(list.get(index));
            list.remove(index);
        }

        StringJoiner answer = new StringJoiner(", ", "<", ">");
        for (Integer r : result) {
            answer.add(String.valueOf(r));
        }
        System.out.print(answer);
    }
}