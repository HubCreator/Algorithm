import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution {
    int answer = 0;
    char[] operators = new char[]{'*', '+', '-'};
    int[] pm = new int[operators.length];
    boolean[] ch = new boolean[operators.length];
    List<String> entry = new ArrayList<>();

    public long solution(String expression) {
        long answer = 0L;
        dfs(0); // operation들의 조합 가져오기
        String target = expression;

        for (String e : entry) {
            List<String> chunk = split(target);
            for (int i = 0; i < e.length(); i++) {
                char operation = e.charAt(i);
                for (int j = 0; j < chunk.size(); j++) {
                    if (chunk.get(j).equals(operation + "")) {
                        evaluate(chunk, j, operation);
                        j--;
                    }
                }
            }
            answer = Math.max(answer, Math.abs(Long.parseLong(chunk.get(0))));
        }


        return answer;
    }

    private void evaluate(List<String> chunk, int idx, char operation) {
        long result = 0L;
        if (operation == '*') {
            result = Long.parseLong(chunk.get(idx - 1)) * Long.parseLong(chunk.get(idx + 1));
        } else if (operation == '+') {
            result = Long.parseLong(chunk.get(idx - 1)) + Long.parseLong(chunk.get(idx + 1));
        } else if (operation == '-') {
            result = Long.parseLong(chunk.get(idx - 1)) - Long.parseLong(chunk.get(idx + 1));
        }
        chunk.set(idx, result + "");

        chunk.remove(idx - 1);
        chunk.remove(idx);
    }

    private List<String> split(String expression) {
        StringTokenizer st = new StringTokenizer(expression, "*+-", true);
        List<String> strings = new ArrayList<>();
        while (st.hasMoreTokens()) {
            strings.add(st.nextToken());
        }
        return strings;
    }

    private void dfs(int L) {
        if (L == operators.length) {
            StringBuilder result = new StringBuilder();
            for (int x : pm) {
                result.append(operators[x]);
            }
            entry.add(result.toString());
        } else {
            for (int i = 0; i < ch.length; i++) {
                if (!ch[i]) {
                    ch[i] = true;
                    pm[L] = i;
                    dfs(L + 1);
                    ch[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution("100-200*300-500+20"));
    }
}