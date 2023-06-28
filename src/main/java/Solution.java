class Solution {

    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        answer[numbers.length - 1] = -1;
        int target = numbers[numbers.length - 1];
        for (int i = numbers.length - 2; i >= 0; i--) {
            if (numbers[i] < numbers[i + 1]) {
                target = numbers[i + 1];
                answer[i] = target;
            } else {
                answer[i] = numbers[i] > target ? -1 : target;
            }
        }
        return answer;
    }
}
