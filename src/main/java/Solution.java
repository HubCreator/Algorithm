
class Solution {
    public int solution(int n, int[] stations, int w) {
        double answer = 0;
        double len = 2 * w + 1;

        int point = 1;
        for (int station : stations) {
            double tmp = (station - w) - point;
            answer += Math.ceil(tmp / len);
            point = station + w + 1;
        }
        if (stations[stations.length - 1] + w < n) {
            answer += Math.ceil((n - point + 1) / len);
        }
        return (int) answer;
    }
}