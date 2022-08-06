class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                answer[i]++;
                // 자신보다 작은 값이 없는 동안 반복
                if (prices[i] > prices[j]) break;
            }
        }
        return answer;
    }
}