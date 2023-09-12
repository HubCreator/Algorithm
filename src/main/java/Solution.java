import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] students = new int[n + 2];
        Arrays.fill(students, 1);
        for (int i = 0; i < reserve.length; i++) {
            students[reserve[i]] += 1;
        }
        for (int i = 0; i < lost.length; i++) {
            students[lost[i]] -= 1;
        }

        for (int i = 1; i < students.length - 1; i++) {
            if (students[i] == 0 && students[i + 1] >= 2) {
                students[i] += 1;
                students[i + 1] -= 1;
            }
            else if (students[i] >= 2 && students[i + 1] == 0) {
                students[i] -= 1;
                students[i + 1] += 1;
            }

        }
        for (int i = 1; i < students.length - 1; i++) {
            if (students[i] >= 1) {
                answer += 1;
            }
        }
        return answer;
    }
}
