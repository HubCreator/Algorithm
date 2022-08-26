import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        int idx = 0;
        List<Integer> courseList = new ArrayList<>();
        List<String> list = new ArrayList<>();
        for (int x : course) courseList.add(x);
        Collections.addAll(list, orders);
        Collections.sort(list, (a, b) -> a.length() - b.length());
        while (idx < list.size()) {
            String s = list.get(idx);
            int cnt = 0;
            if (courseList.contains(s.length())) {
                for (int i = idx + 1; i < list.size(); i++) {
                    if (list.get(i).contains(s)) cnt++;
                }
            }
            if (cnt > 0) answer.add(s);
            idx++;
        }
        for (String s : answer) {
            System.out.println("s = " + s);
        }


        return null;
    }
}