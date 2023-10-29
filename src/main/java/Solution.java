import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(String msg) {
        StringBuilder dict1 = new StringBuilder();
        StringBuilder dict2 = new StringBuilder();
        List<String> dict = new ArrayList<>();
        List<Integer> indexes = new ArrayList<>();
        for (char c = 'A'; c <= 'Z'; c++) {
            dict1.append(String.valueOf(c));
        }

        for (int i = 0; i < msg.length() - 1; i++) {
            StringBuilder curr = new StringBuilder();
            curr.append(msg.charAt(i));

            while (i < msg.length() -1 &&
                    dict2.indexOf(curr.toString() + msg.charAt(i + 1)) != -1) {
                curr.append(msg.charAt(i + 1));
                i++;
            }

            if (i < msg.length() - 1) {
                char next = msg.charAt(i + 1);
                dict2.append(curr.toString() + next);
            }
            if (curr.toString().length() > 1) {
                indexes.add(dict2.indexOf(curr.toString()) + 27);
            } else {
                indexes.add(dict2.indexOf(curr.toString()) + 1);
            }
        }
        int[] answer = new int[indexes.size()];
        for (int i = 0; i < indexes.size(); i++) {
            answer[i] = indexes.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i : solution.solution("ABABABABABABABAB")) {
            System.out.print(i + " ");
        }
    }
}
