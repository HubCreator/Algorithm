import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] student;
    static List<boolean[][]> areFriends = new ArrayList<>();
    static boolean[] ch;

    private int DFS(int maxStudent, boolean[][] friend, boolean[] ch) {
        // 남은 학생 중 가장 번호가 빠른 학생을 찾음
        int firstFree = -1;
        for (int i = 0; i < maxStudent; i++) {
            if (!ch[i]) { // false -> 확인 대상
                firstFree = i;
                break;
            }
        }
        // 기저 사례 : 모든 학생이 짝을 찾았으면 한 가지 방법을 찾았으니 종료함
        if (firstFree == -1) return 1; // 확인 대상이 없으면 종료
        int answer = 0;
        // 이 학생과 짝지을 학생을 결정함
        for (int pairWith = firstFree + 1; pairWith < maxStudent; pairWith++) {
            if (!ch[pairWith] && friend[firstFree][pairWith]) {
                ch[firstFree] = ch[pairWith] = true;
                answer += DFS(maxStudent, friend, ch);
                ch[firstFree] = ch[pairWith] = false;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        student = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            int p = Integer.parseInt(st1.nextToken());
            int pairsCnt = Integer.parseInt(st1.nextToken());
            student[i] = p; // 몇 명의 학생
            areFriends.add(new boolean[p][p]);

            for (int j = 0; j < pairsCnt; j++) {
                int f1 = Integer.parseInt(st2.nextToken());
                int f2 = Integer.parseInt(st2.nextToken());
                areFriends.get(i)[f1][f2] = true; // 둘은 친구임
                areFriends.get(i)[f2][f1] = true;
            }
        }
        for (int i = 0; i < n; i++) {
            int maxStudent = student[i];
            ch = new boolean[maxStudent];
            System.out.println(T.DFS(maxStudent, areFriends.get(i), ch));
        }
    }
}