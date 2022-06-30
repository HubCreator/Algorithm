import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Time implements Comparable<Time> {
    int start, end;

    Time(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public boolean inBetween(int time) {
        return time >= start && time < end;
    }

    @Override
    public int compareTo(Time o) {
        return this.end - o.end; // 끝나는 시간으로 정렬
    }
}

public class Main {
    private int solution(int n, List<Time> list, Set<Integer> set) {
        int answer = Integer.MIN_VALUE;
        for (Integer t : set) {
            int cnt = 0;
            for (Time time : list) {
                if(time.inBetween(t)) cnt++;
            }
            answer = Math.max(answer, cnt);
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Time> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Time(start, end));
            set.add(start);
            set.add(end);
        }
        Collections.sort(list);
        System.out.println(T.solution(n, list, set));
    }
}