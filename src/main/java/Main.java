import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Main T = new Main();
        // arr에서 2개를 더해서 합이 target이 되는 인덱스의 배열을 반환하라.
        int[] arr = new int[]{1, 2, 3, 4, 6};
        int target = 6;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        int[] answer = T.solution(arr, map, target);
        System.out.println(answer[0] + " " + answer[1]);
    }

    private int[] solution(int[] arr, Map<Integer, Integer> map, int target) {
        for (int i = 0; i < arr.length; i++) {
            int remain = target - arr[i];
            if (remain != arr[i] && map.containsKey(remain)) {
                return new int[]{i, map.get(remain)};
            }
        }
        return null;
    }
}
