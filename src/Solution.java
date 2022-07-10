import java.util.LinkedList;
import java.util.Queue;

class Entry {
    int idx, priority;

    public Entry(int idx, int priority) {
        this.idx = idx;
        this.priority = priority;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Entry> queue = new LinkedList<>();
        int answer = 0;
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new Entry(i, priorities[i]));
        }
        while (!queue.isEmpty()) {
            Entry p = queue.poll();
            for (Entry entry : queue) {
                if (entry.priority > p.priority) {
                    queue.offer(p);
                    p = null;
                    break;
                }
            }

            if (p != null) {
                answer++;
                if (p.idx == location) return answer;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int[] p = {2, 1, 3, 2};
        int l = 2;
        System.out.println(T.solution(p, l));
    }
}