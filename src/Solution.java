import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<String, ArrayList<Integer>> map;
    String[] strings, sInfoArr;
    int score;

    private void dfs(int L) {
        if (L == 4) {
            String str = String.join("", strings); // String 배열을 모두 합쳐 String으로 반환
            if (!map.containsKey(str)) map.put(str, new ArrayList<>()); // value가 ArrayList<>일 때 핸들링
            map.get(str).add(score); // 얕은 복사임 (map.put(str, map.get(str).add(score))를 하면 안됨)
        } else {
            strings[L] = sInfoArr[L];
            dfs(L + 1);
            strings[L] = "-";
            dfs(L + 1);
        }
    }

    private int binarySearch(ArrayList<Integer> list, int val) { // list 요소 중 val 이상인 요소의 최소 인덱스를 찾아라
        int lt = 0, rt = list.size() - 1;
        int mid;
        while (lt <= rt) {
            mid = (lt + rt) / 2;
            if (list.get(mid) < val) lt = mid + 1;
            else rt = mid - 1;
        }
        return lt;
    }

    public int[] solution(String[] info, String[] query) {
        int idx = 0;
        int[] answer = new int[query.length];
        map = new HashMap<>();
        // 모든 경우의수로 Map을 구성
        for (String s : info) {
            strings = new String[4];
            sInfoArr = s.split(" ");
            score = Integer.parseInt(sInfoArr[4]);
            dfs(0);
        }

        for (String key : map.keySet()) Collections.sort(map.get(key)); // 각 키에 달려있는 ArrayList의 요소들을 오름차순 정렬함

        for (String q : query) {
            String[] strs = q.split(" and | ");
            String key = new StringBuilder(strs[0]).append(strs[1]).append(strs[2]).append(strs[3]).toString();
            if (!map.containsKey(key)) answer[idx++] = 0;
            else {
                ArrayList<Integer> list = map.get(key);
                answer[idx++] = list.size() - binarySearch(list, Integer.parseInt(strs[4]));
            }
        }
        return answer;
    }
}