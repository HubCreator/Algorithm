import java.util.ArrayList;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> answer = new ArrayList<>();
        for(int x : arr) {
            if(x % divisor == 0) answer.add(x);
        }
        return answer.isEmpty() ?
                new int[]{-1} :
                answer.stream().sorted().mapToInt(i->i.intValue()).toArray();
    }
}