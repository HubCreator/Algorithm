import java.util.List;
import java.util.ArrayList;

class Dungeon {
    int curTired, needTired;

    public Dungeon(int ct, int nt) {
        this.curTired = ct;
        this.needTired = nt;
    }
}

class Solution {
    int[] pm, ch;
    int curStem, dungeonSize, answer = Integer.MIN_VALUE;
    List<Dungeon> list;

    public void DFS(int L) {
        if (L == pm.length) {
            int cnt = 0, tmp = curStem;
            for (int x : pm) {
                if (list.get(x - 1).curTired > tmp) break;
                else {
                    tmp -= list.get(x - 1).needTired;
                    cnt++;
                }
            }
            answer = Math.max(answer, cnt);
        } else {
            for (int i = 1; i <= dungeonSize; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    pm[L] = i;
                    DFS(L + 1);
                    ch[i] = 0;
                }
            }
        }
    }

    public int solution(int k, int[][] dungeons) {
        curStem = k;
        dungeonSize = dungeons.length;
        pm = new int[dungeonSize];
        ch = new int[dungeonSize + 1];
        list = new ArrayList<>();
        for (int[] arr : dungeons) list.add(new Dungeon(arr[0], arr[1]));
        DFS(0);
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int k = 80;
        int[][] dungeons = {
                {80, 20},
                {50, 40},
                {30, 10}
        };
        System.out.println(T.solution(k, dungeons));
    }
}