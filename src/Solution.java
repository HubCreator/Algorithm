import java.util.*;

class Solution {
    static HashMap<String, ArrayList<Integer>> map;
    static int score;
    static String[] strings, sInfoArr;

    static void dfs(int L) { // key를 이룰 수 있는 모든 경우의 수를 구함
        if (L == 4) {
            String str = String.join("", strings);
            if (!map.containsKey(str)) map.put(str, new ArrayList<>());
            map.get(str).add(score);
        } else {
            strings[L] = sInfoArr[L];
            dfs(L + 1);
            strings[L] = "-";
            dfs(L + 1);
        }
    }

    static int binarySearch(ArrayList<Integer> list, int val) {
        int left = 0, right = list.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (list.get(mid) < val) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }

    public static int[] solution(String[] info, String[] query) {
        int idx = 0;
        int[] answer = new int[query.length];
        map = new HashMap<>();

        for (String s : info) {
            strings = new String[4];
            sInfoArr = s.split(" ");
            score = Integer.parseInt(sInfoArr[4]);
            dfs(0);
        }

        for (String key : map.keySet()) Collections.sort(map.get(key)); // 점수들이 들어있는 value(ArrayList)에 대해 오름차순 정렬

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