import java.util.Arrays;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        Arrays.sort(routes, (a, b) -> a[1] - b[1]);
        int cam = -30001;
        for (int i = 0; i < routes.length; i++) {
            int[] curr = routes[i];
            if (cam > curr[1]) {
                continue;
            }
            answer++;
            cam = curr[1];
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int answer = solution.solution(new int[][]{{-100, 100}, {50, 170}, {150, 200}, {-50, -10}, {10, 20}, {30, 40}});
        System.out.println("answer = " + answer);
    }
}
