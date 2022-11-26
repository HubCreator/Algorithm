class Solution {
    public String solution(int[] food) {
        StringBuilder answer = new StringBuilder();
        StringBuilder buffer = new StringBuilder();
        for (int i = 1; i < food.length; i++) {
            for (int j = 0; j < food[i] / 2; j++) {
                buffer.append(i);
            }
        }
        answer.append(buffer);
        answer.append(0);
        answer.append(buffer.reverse());
        return answer.toString();
    }
}