import java.util.*;

class Solution {
    public static Set<Integer> cached = new HashSet<>();

    public int solution(String begin, String target, String[] words) {
        return bfs(words, begin, target);
    }

    private int bfs(String[] words, String begin, String target) {
        Queue<List<Integer>> queue = new ArrayDeque<>();
        queue.add(getEntry(words, begin));
        int level = 0;
        while (!queue.isEmpty()) {
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                List<Integer> poll = queue.poll();
                for (Integer index : poll) {
                    if (words[index].equals(target)) return level + 1;
                    queue.offer(getEntry(words, words[index]));
                }
            }
            level++;
        }
        return 0;
    }

    private List<Integer> getEntry(String[] words, String input) {
        List<Integer> idxList = new ArrayList<>();

        for (int idx = 0; idx < words.length; idx++) {
            String word = words[idx];
            int cnt = 0;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == input.charAt(i)) cnt++;
            }
            if (cnt == word.length() - 1 && !cached.contains(idx)) idxList.add(idx);
        }
        cached.addAll(idxList);
        return idxList;
    }
}