import java.util.PriorityQueue;

class Solution {
    int[] ch = new int[5];
    PriorityQueue<String> pqueue = new PriorityQueue<>();

    private void dfs(int L) {
        if (L == ch.length) {
            StringBuilder sb = new StringBuilder();
            for (int x : ch) {
                if (x == 1) sb.append('A');
                else if (x == 2) sb.append('E');
                else if (x == 3) sb.append('I');
                else if (x == 4) sb.append('O');
                else if (x == 5) sb.append('U');
            }
            if (!pqueue.contains(sb.toString())) pqueue.offer(sb.toString());
        } else {
            ch[L] = 0;
            dfs(L + 1);
            ch[L] = 1;
            dfs(L + 1);
            ch[L] = 2;
            dfs(L + 1);
            ch[L] = 3;
            dfs(L + 1);
            ch[L] = 4;
            dfs(L + 1);
            ch[L] = 5;
            dfs(L + 1);
        }
    }

    public int solution(String word) {
        int answer = -1;

        dfs(0);

        while (!pqueue.isEmpty()) {
            String poll = pqueue.poll();
            answer++;
            if (poll.equals(word)) break;
        }
        return answer;
    }
}