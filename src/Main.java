import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Time implements Comparable<Time> {
    char status;
    int time;

    public Time(char status, int time) {
        this.status = status;
        this.time = time;
    }

    @Override
    public int compareTo(Time o) {
        if (this.time == o.time) return this.status - o.status;
        return this.time - o.time;
    }
}

public class Main {
    private int solution(List<Time> list) {
        int cnt = 0, answer = Integer.MIN_VALUE;
        Collections.sort(list);
        for (Time t : list) {
            if (t.status == 's') cnt++;
            else cnt--;
            answer = Math.max(answer, cnt);
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Time> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list.add(new Time('s', s));
            list.add(new Time('e', e));
        }
        System.out.println(T.solution(list));
    }
}