public class Solution {
    public int solution(int n) {
        int answer = 0;
        while(true){
            answer += n % 10; // 1의 자리를 answer에 count
            if (n < 10) break;
            n = n / 10; // 10으로 나눈 몫으로 갱신
        }
        return answer;
    }
}