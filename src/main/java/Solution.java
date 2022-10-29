
class Solution {
    public int solution(int n, int[] stations, int w) {
        double answer = 0;
        int len = 2 * w + 1;

        int point = 1;
        for (int station : stations) {
            int tmp = (station - w) - point;
            answer += Math.ceil((double) tmp / len);
            point = station + w + 1;
        }
        if (stations[stations.length - 1] + w < n) {
            answer += Math.ceil((double) (n - point + 1) / len);

        }
        return (int) answer;
    }
}