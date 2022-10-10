import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

class Solution {

    private int bfs(String str, String target, String[] words) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(str);
        int tmp, cnt = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                if (Objects.equals(poll, target)) return cnt;
                for (String t : words) {
                    tmp = 0;
                    for (int k = 0; k < t.length(); k++)
                        if (poll.charAt(k) != t.charAt(k)) tmp++;
                    if (tmp == 1) queue.offer(t);

                }
            }
            cnt++;
        }
        return 0;
    }

    public int solution(String begin, String target, String[] words) {
        boolean flag = false;
        for (String word : words) {
            if (word.equals(begin)) return 1;
            if (word.equals(target)) {
                flag = true;
                break;
            }
        }
        if (!flag) return 0;
        return bfs(begin, target, words);
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        String[] arr = {"cog", "log", "lot", "dog", "dot", "hot"};
        System.out.println(T.solution("hit", "cog", arr));
    }
}