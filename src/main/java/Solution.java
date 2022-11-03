import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[]{1, Integer.MAX_VALUE};
        Set<String> entry = new HashSet<>(Arrays.asList(gems));
        Queue<String> target = new LinkedList<>();
        int lt = 0, rt = 0;

        while (lt <= rt && rt < gems.length) {
            target.add(gems[rt++]);

            boolean flag = false;
            while (entry.equals(new HashSet<>(target))) { // lt를 갱신
                target.poll();
                lt++;
                flag = true;
            }
            if (flag && rt - lt < answer[1] - answer[0]) { // lt를 갱신했는데, answer보다 길이가 작다면
                answer = new int[]{lt, rt}; // 다시 한 번 answer 갱신
            }
        }

        if (answer[1] == Integer.MAX_VALUE) {
            return new int[]{1, gems.length};
        }
        return answer;
    }
}