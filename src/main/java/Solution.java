import java.util.Arrays;

class Solution {
    public int[] solution(int n) {
        int[] answer = new int[(n * (n + 1)) / 2];
        int[] levelStatus = new int[n];
        int curIdx = 0, level = 0, cnt = n;
        int flag = 0;

        for (int i = 0; i < levelStatus.length; i++) levelStatus[i] = i + 1; // 각 레벨에 몇 개의 요소가 있는지 나타내는 상태값

        for (int i = 0; i < answer.length; i++) {
            int num = i + 1;

            answer[curIdx] = num;
            cnt--;
            if (cnt == 0) {
                cnt = --n;
                flag = (flag + 1) % 3;
            }

            if (flag == 0 && cnt > 0) {
                curIdx += levelStatus[level++];
            }
            if (flag == 1 && cnt > 0) {
                curIdx++;
            }
            if (flag == 2 && cnt > 0) {
                curIdx -= levelStatus[level--];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int[] solution = T.solution(6);
        for (int i = 0; i < solution.length; i++) {
            System.out.print(solution[i] + " ");
            if (Arrays.asList(0, 2, 5, 9, 14).contains(i)) System.out.println();
        }
    }
}