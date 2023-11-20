import java.util.*;

class Solution {
    private static Map<Character, Character> map = new HashMap<>();
    
    static {
        map.put('[', ']');
        map.put('(', ')');
        map.put('{', '}');
    }
    
    public int solution(String s) {
        int answer = 0;
        Queue<Character> queue = new ArrayDeque<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            queue.offer(s.charAt(i));
        }
        
        for (int i = 0; i < s.length(); i++) {
            if (check(new ArrayList<>(queue))) {
                answer++;
            }
            queue.offer(queue.poll());
        }
        return answer;
    }
    
    public boolean check(List<Character> list) {
        List<Character> stack = new ArrayList<>();
        
        for (int i = 0; i < list.size(); i++) {
            if (stack.isEmpty() || 
               map.get(stack.get(stack.size() - 1)) != list.get(i)) {
                stack.add(list.get(i));
                continue;
            }
            stack.remove((int)(stack.size() - 1));
        }
        
        return stack.isEmpty();
    }
}