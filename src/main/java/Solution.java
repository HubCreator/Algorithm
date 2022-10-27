import java.util.Arrays;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> a[1] - b[1]); // 각 행을 정렬 (종료 지점 기준으로 오름차순 정렬)

        int ans = 0;
        int camPoint = Integer.MIN_VALUE;
        for (int[] ints : routes) {
            if (camPoint < ints[0]) { // 시작지점이 더 크다면
                ++ans;
                camPoint = ints[1]; // 종료 지점을 저장
            }
        }
        return ans;
    }
}