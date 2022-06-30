import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Time implements Comparable<Time> {
    int start, end;

    Time(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Time o) {
        return this.end - o.end; // 끝나는 시간으로 정렬
    }
}

public class Main {
    private int solution(int n, List<Time> list) {
        int answer = 0;
        int lt = 0, rt = 0;
        while (lt <= rt && rt < n) {
            if (list.get(lt).end <= list.get(rt).start) {
                answer++;
                lt = rt;
            }
            rt++;
        }
        return answer + 1;
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
            list.add(new Time(start, end));
        }
        Collections.sort(list);
        System.out.println(T.solution(n, list));
    }
}