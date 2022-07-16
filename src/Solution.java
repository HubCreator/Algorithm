import java.util.List;
import java.util.ArrayList;

class Dungeon {
    int requiredStem, stemina;
    public Dungeon (int r, int s) {
        this.requiredStem = r;
        this.stemina = s;
    }
}
class Solution {
    int[] pm, ch;
    int curStem, dungeonSize, answer = Integer.MIN_VALUE;
    List<Dungeon> list;

    public void DFS(int L) {
        if (L == pm.length) {
            int cnt = 1;
            for (int x : pm) {
                if(list.get(x - 1).requiredStem > curStem) break;
                else {
                    curStem -= list.get(x - 1).stemina;
                    cnt++;
                }
            }
            answer = Math.max(answer, cnt);
        } else {
            for (int i = 1; i <= dungeonSize; i++) {
                if(ch[i] == 0) {
                    ch[i] = 1;
                    pm[L] = i; // L은 0부터 인덱스의 숫자와 함께 올라감
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
        for(int[] arr : dungeons) {
            list.add(new Dungeon(arr[0], arr[1]));
        }
        DFS(0);

        return answer;
    }
}