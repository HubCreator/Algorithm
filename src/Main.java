import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Schedule implements Comparable<Schedule>{
    int start, end;

    public Schedule(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Schedule o) {
        if(this.end == o.end) return this.start - o.start;
        return this.end - o.end;
    }
}
public class Main {
    private int solution(List<Schedule> list) {
        int answer = 1;
        Collections.sort(list);
        int lt = 0, rt = 0;
//        Schedule curSchedule = list.get(0);
//        for (int i = 1; i < list.size(); i++) {
//            if (curSchedule.end <= list.get(i).start) {
//                curSchedule = list.get(i);
//                answer++;
//            }
//        }
        while (lt <= rt && rt < list.size()) {
            if (list.get(lt).end <= list.get(rt).start) {
                answer++;
                lt = rt;
            }
            rt++;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Schedule> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Schedule(start, end));
        }
        System.out.println(T.solution(list));
    }
}