import java.util.HashSet;
import java.util.Set;

class Solution {
    public Set<Integer> answer = new HashSet<>();
    public int solution(int[] elements) {
        int totalSum = 0;
        for (int i = 0; i < elements.length; i++) {
            totalSum += elements[i];
            answer.add(elements[i]);
        }
        answer.add(totalSum);

        for (int i = 2; i < elements.length; i++) {
            solution(elements, i);
        }
        return answer.size();
    }

    public void solution(int[] elements, int size) {
        int sum = 0, len = elements.length;
        for(int i = 0; i < size - 1; i++) {
            sum += elements[i];
        }
        for (int i = size - 1; i < len + size; i++) {
            sum += elements[i % len];
            answer.add(sum);
            sum -= elements[(i - (size - 1)) % len];
        }
    }
}
