class Solution {
    public String solution(int[] food) {
        StringBuilder answer = new StringBuilder();
        StringBuilder buffer = new StringBuilder();
        for (int i = 1; i < food.length; i++) {
            buffer.append(String.valueOf(i).repeat(Math.max(0, food[i] / 2)));
        }
        answer.append(buffer);
        answer.append(0);
        answer.append(buffer.reverse());
        return answer.toString();
    }
}