import java.util.HashMap;

class Solution {
    public int solution(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) map.put(n, map.getOrDefault(n, 0) + 1);
        return Math.min(map.size(), nums.length / 2);
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        int[] arr = {3, 3, 3, 2, 2, 4};
        System.out.println(T.solution(arr));
    }
}