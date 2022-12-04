import java.util.ArrayList;
import java.util.List;

class Solution {
    private boolean[] check;
    private int[] pm;
    private List<List<Integer>> answer = new ArrayList<>();

    public String[] solution(String[][] tickets) {
        check = new boolean[tickets.length];
        pm = new int[tickets.length];
        dfs(tickets, 0);
        return getAnswer(tickets);
    }

    private String[] getAnswer(String[][] tickets) {

        List<String> result = new ArrayList<>();
        if (answer.size() == 1) {
            List<Integer> list = answer.get(0);
            result.add(tickets[list.get(0)][0]);
            result.add(tickets[list.get(0)][1]);
            for (int i = 1; i < list.size(); i++) {
                result.add(tickets[list.get(i)][1]);
            }
        }
        return result.toArray(new String[0]);
    }

    private void dfs(String[][] tickets, int L) {
        if (L == check.length && pm[0] == 0 && isValid(pm, tickets)) {
            List<Integer> result = new ArrayList<>();
            for (int x : pm) {
                result.add(x);
            }
            answer.add(result);
            return;
        }
        for (int i = 0; i < check.length; i++) {
            if (!check[i]) {
                pm[L] = i;
                check[i] = true;
                dfs(tickets, L + 1);
                check[i] = false;
            }
        }
    }

    private boolean isValid(int[] pm, String[][] tickets) {
        for (int i = 0; i < pm.length - 1; i++) {
            if (!tickets[pm[i]][1].equals(tickets[pm[i + 1]][0])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        String[][] ticket = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        for (String s : T.solution(ticket)) {
            System.out.println(s);
        }
    }
}