import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        Arrays.stream(numbers).boxed().sorted((a, b) -> {
            Integer s1 = Integer.parseInt(a.toString().concat(b.toString()));
            Integer s2 = Integer.parseInt(b.toString().concat(a.toString()));
            return s2.compareTo(s1);
        }).forEach(answer::append);

        return Double.parseDouble(answer.toString()) == 0 ? "0" : answer.toString();
    }
}