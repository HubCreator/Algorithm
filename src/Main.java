import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Time implements Comparable<Time> {
    int time;
    char status;

    Time(int time, char status) {
        this.time = time;
        this.status = status;
    }

    @Override
    public int compareTo(Time o) {
        if (this.time == o.time) return this.status - o.status;
        else return this.time - o.time; // 끝나는 시간으로 정렬
    }
}

public class Main {
    private int solution(int n, List<Time> list) {
        Collections.sort(list);
        int answer = Integer.MIN_VALUE;
        int cnt = 0;
        for (Time time : list) {
            if(time.status == 's') cnt++;
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
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Time(start, 's'));
            list.add(new Time(end, 'e'));
        }
        System.out.println(T.solution(n, list));
    }
}