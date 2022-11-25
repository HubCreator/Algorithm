import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        StringBuilder answer = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        for (String s : cmd) {
            StringTokenizer st = new StringTokenizer(s);
            String command = st.nextToken();
            if (command.equals("D")) {
                k += Integer.parseInt(st.nextToken());
            } else if (command.equals("U")) {
                k -= Integer.parseInt(st.nextToken());
            } else if (command.equals("C")) {
                stack.push(new int[]{k, list.get(k)});
                list.remove(k);
                if (k == list.size()) k--;
            } else if (command.equals("Z")) {
                int[] pop = stack.pop();
                list.add(pop[0], pop[1]);
                if (k >= pop[0]) k++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (list.contains(i)) answer.append('O');
            else answer.append('X');
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int n = 8;
        int k = 2;
        String[] arr = new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"};
        System.out.println(T.solution(n, k, arr));
    }
}