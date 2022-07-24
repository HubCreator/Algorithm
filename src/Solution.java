import java.util.*;

class Solution {
    public long solution(long n) {
        StringBuilder sb = new StringBuilder();
        String str = String.valueOf(n);
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < str.length(); i++)
            pQ.offer(Integer.parseInt(String.valueOf(str.charAt(i))));
        for(int i = 0; i < str.length(); i++)
            sb.append(pQ.poll());

        return Long.parseLong(sb.toString());
    }
}