import java.util.ArrayList;
import java.util.Stack;

class Function{
    int progress, speeds;

    public Function(int progress, int speeds) {
        this.progress = progress;
        this.speeds = speeds;
    }
}
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        Stack<Function> stack = new Stack<>();
        int cnt = 0;
        for (int i = progresses.length - 1; i >= 0; i--) {
            stack.push(new Function(progresses[i], speeds[i]));
        }
        while (!stack.isEmpty()) {
            while (!stack.isEmpty() && stack.peek().progress >= 100) {
                cnt++;
                stack.pop();
            }
            for (Function x : stack) x.progress += x.speeds;
            if(cnt != 0) answer.add(cnt);
            cnt = 0;
        }
        return answer.stream().mapToInt(i -> i.intValue()).toArray();
    }
}