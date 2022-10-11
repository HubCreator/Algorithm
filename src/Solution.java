import java.util.LinkedList;
import java.util.Queue;

class Solution {

    private boolean isValid(String poll, String t) {
        int tmp = 0;
        for (int i = 0; i < t.length(); i++)
            if (poll.charAt(i) != t.charAt(i)) tmp++;
        return tmp == 1;
    }

    private int bfs(String str, String target, String[] words) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(str);
        int cnt = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                for (String t : words) {
                    if (isValid(poll, t)) {
                        queue.offer(t);
                        if (t.equals(target)) return cnt + 1;
                    }
                }
            }
            if (queue.size() > 1) cnt += queue.size();
            else cnt++;
        }
        return cnt;
    }

    public int solution(String begin, String target, String[] words) {
        boolean flag = false;
        for (String word : words) {
            if (word.equals(begin)) return 1;
            if (word.equals(target)) flag = true;
        }
        if (!flag) return 0;
        return bfs(begin, target, words);
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        String[] arr = {"hot", "dot", "dog", "lot", "log"};
        System.out.println(T.solution("hit", "cog", arr));
    }
}