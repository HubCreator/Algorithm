class Solution {
    public int solution(String name) {
        int answer = 0;
        int[] diff = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        for (char c : name.toCharArray()) // 상하 조작
            answer += diff[c - 'A'];

        int length = name.length();
        int min = length - 1;

        for (int i = 0; i < length; i++) {
            int next = i + 1;
            while (next < length && name.charAt(next) == 'A') {
                next++; // A가 연속되어 나온다면 이를 카운트하고 바로 그 다음까지 인덱스를 올려라
            }
            min = Math.min(min, i + length - next + Math.min(i, length - next));
        }

        return answer + min;
    }
}