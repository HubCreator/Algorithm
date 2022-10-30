import java.util.Arrays;

class Solution {
    int a1 = 0;
    int curIdx = 0;
    int triLen = 1;


    public int[] solution(int n) {
        int[] answer = new int[(n * (n + 1)) / 2];
        Arrays.fill(answer, -1);
        int flag = 1;
        boolean isFirst = true;

        for (int i = 0; i < answer.length; i++) {
            int target = i + 1;
            if (flag == 1) {
                boolean isValid = true;
                if (isFirst) {
                    a1 = curIdx;
                    isFirst = false;
                }
                if (foo1(target) >= answer.length || (foo1(target) < answer.length && answer[foo1(target)] != -1)) {
                    flag = 2;
                    isFirst = true;
                    isValid = false;
                }
                if (isValid) {
                    curIdx = foo1(target);
                    answer[curIdx] = target;
                }
            }
            if (flag == 2) {
                boolean isValid = true;
                if (foo2() >= answer.length || (foo2() < answer.length && answer[foo2()] != -1)) {
                    flag = 3;
                    isValid = false;
                }
                if (isValid) {
                    curIdx = foo2();
                    triLen++;
                    a1 = curIdx;
                    answer[curIdx] = target;
                }
            }
            if (flag == 3) {
                boolean isValid = true;
                if (foo3(curIdx -1) < 0 || (foo3(curIdx -1) < answer.length && answer[foo3(curIdx - 1)] == -1)) {
                    flag = 1;
                    isValid = false;
                }

                if (isValid) {
                    curIdx = foo3(curIdx);
                    answer[curIdx - 1] = target;
                }
            }
        }
        return answer;
    }

    private int foo1(int n) {
        return a1 + ((n * (n - 1)) / 2);
    }

    private int foo2() {
        return curIdx + 1;
    }

    private int foo3(int n) {
        return n - (triLen--);
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