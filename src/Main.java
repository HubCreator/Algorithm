import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<Integer>> list = new ArrayList<>();
    static int[] answer;

    private void BFS(int val) { // val 은 목표지점
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> ch = new ArrayList<>();
        int cnt = 0;
        for (int i = 0; i < list.get(1).size(); i++) {
            queue.offer(list.get(1).get(i)); // 1번 노드에서 출발하는 노드들을 queue에 추가 (초기 설정)
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer t = queue.poll();
                if (t == val) {
                    answer[val] = cnt + 1;
                    return;
                }
                ch.add(t);
                for (int j = 0; j < list.get(t).size(); j++) {
                    if (!ch.contains(list.get(t).get(j)) && !queue.contains(list.get(t).get(j)))
                        queue.offer(list.get(t).get(j));
                }
            }
            cnt++;
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        answer = new int[v + 1];
        for (int i = 0; i <= v; i++) {
            list.add(new ArrayList<>(i));
        }
        StringTokenizer[] stArr = new StringTokenizer[e];
        for (int i = 0; i < e; i++) {
            stArr[i] = new StringTokenizer(br.readLine(), " ");
            int _v = Integer.parseInt(stArr[i].nextToken());
            int _e = Integer.parseInt(stArr[i].nextToken());
            list.get(_v).add(_e);
        }

        for (int i = 2; i <= v; i++) {
            T.BFS(i);
        }

        for (int i = 2; i < answer.length; i++) {
            System.out.println(i + " : " + answer[i]);
        }
    }
}