import java.util.*;

class Solution {
    public static Set<Integer> cached = new HashSet<>();

    public int solution(String begin, String target, String[] words) {
        List<Integer> entry = getEntry(words, begin);
        return bfs(words, entry, target);
    }

    private int bfs(String[] words, List<Integer> entry, String target) {
        Queue<List<Integer>> queue = new ArrayDeque<>();
        queue.add(entry);
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

    private List<Integer> getEntry(String[] words, String target) {
        List<Integer> indexList = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int cnt = 0;
            for (int j = 0; j < word.length(); j++) {
                if (word.charAt(j) == target.charAt(j)) cnt++;
            }
            if (cnt == 2 && !cached.contains(i)) indexList.add(i);
        }
        cached.addAll(indexList);
        return indexList;
    }
}