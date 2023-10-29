import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean flag = false;
        for (String word : words) {
            if (word.equals(target)) {
                flag = true;
            }
        }
        if (!flag) {
            return 0;
        }
        int answer = 0;
        boolean[] check = new boolean[words.length];
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(begin);
        while (!queue.isEmpty()) {
            int size = queue.size();
            answer++;
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                if (poll.equals(target)) {
                    return answer - 1;
                }
                for (int j = 0; j < words.length; j++) {
                    if (!check[j] && isValid(poll, words[j])) {
                        check[j] = true;
                        queue.offer(words[j]);
                    }
                }
            }
        }
        return 0;
    }

    private boolean isValid(String word1, String word2) {
        int count = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int answer = solution.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
        System.out.println("answer = " + answer);
    }
}
