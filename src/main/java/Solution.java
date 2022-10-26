import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

class Route implements Comparable<Route> {
    int start;
    int end;

    public Route(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Route o) {
        if (start == o.start) return end - o.end;
        return start - o.start;
    }
}

class Solution {
    public int solution(int[][] routes) {
        List<Route> list = new ArrayList<>();
        Stack<Route> camPoint = new Stack<>();

        for (int[] route : routes) {
            list.add(new Route(route[0], route[1]));
        }

        Collections.sort(list);

        for (Route route : list) {
            // 이전 경로의 종료지점보다 현재 경로의 시작지점이 더 크면 camPoint에 추가 
            if (camPoint.isEmpty() || camPoint.peek().end < route.start) {
                camPoint.push(route);
            }
            // camPoint에 저장한 경로가 현재 경로를 정확히 감싸고 있는 camPoint.pop()
            else if (route.start > camPoint.peek().start && route.end < camPoint.peek().end) {
                camPoint.pop();
                camPoint.push(route);
            }
        }
        return camPoint.size();
    }
}