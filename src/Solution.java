import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] arr) {
        if(arr.length == 1) return new int[]{-1};
        ArrayList<Integer> list = new ArrayList<>();
        Integer min = Arrays.stream(arr).min().getAsInt();
        for (int i : arr) {
            if(i == min) continue;
            list.add(i);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}