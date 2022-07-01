import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Work implements Comparable<Work> {
    int money;
    int date;

    public Work(int money, int date) {
        this.money = money;
        this.date = date;
    }

    @Override
    public int compareTo(Work o) {
        return o.date - this.date;
    }
}
public class Main {
    private int solution(List<Work> list, int n) {
        int answer = 0;
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder()); // 큰 값의 우선순위가 제일 높게
        Collections.sort(list); // 날짜 내림차순 정렬
        int max = list.get(0).date;
        int j = 0;
        for (int i = max; i > 0; i--) {
            for (; j < n; j++) {
                if(list.get(j).date < i) break;
                pQueue.offer(list.get(j).money);
            }
            if(!pQueue.isEmpty()) answer += pQueue.poll();
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Work> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int m = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            list.add(new Work(m, d));
        }
        System.out.println(T.solution(list, n));
    }
}