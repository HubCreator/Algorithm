import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        Arrays.stream(numbers).boxed().sorted((a, b) -> {
            int s1 = Integer.parseInt(a.toString().concat(b.toString()));
            int s2 = Integer.parseInt(b.toString().concat(a.toString()));
            if (s1 < s2) return 1;
            else if (s1 > s2) return -1;
            else return 0;
        }).forEach(answer::append);

        return Double.parseDouble(answer.toString()) == 0 ? "0" : answer.toString();
    }
}