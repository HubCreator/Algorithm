import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(String msg) {
        List<String> dict = new ArrayList<>();
        List<Integer> indexes = new ArrayList<>();
        for (char c = 'A'; c <= 'Z'; c++) {
            dict.add(String.valueOf(c));
        }
        for (int i = 0; i < msg.length(); i++) {
            StringBuilder curr = new StringBuilder();
            curr.append(msg.charAt(i));

            while (i < msg.length() - 1 && dict.contains(curr.toString() + msg.charAt(i + 1))) {
                curr.append(msg.charAt(i + 1));
                i++;
            }
            if (i < msg.length() - 1) {
                dict.add(curr.toString() + msg.charAt(i + 1));
            }
            indexes.add(dict.indexOf(curr.toString()) + 1);
        }

        int[] answer = new int[indexes.size()];
        for (int i = 0; i < indexes.size(); i++) {
            answer[i] = indexes.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i : solution.solution("KAKAO")) {
            System.out.print(i + " ");
        }
    }
}
