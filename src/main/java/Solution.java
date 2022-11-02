import java.util.*;

class Solution {
    Set<TreeSet<String>> answer = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        int idx = 0;
        List<List<String>> bannedList = new ArrayList<>();
        for (String banId : banned_id) {
            bannedList.add(new ArrayList<>());
            bannedList.get(idx++).addAll(getBannedTarget(user_id, banId));
        }

        for (String s : bannedList.get(0)) {
            TreeSet<String> tSet = new TreeSet<>();
            tSet.add(s);
            dfs(bannedList, tSet, 1);
        }

        return (int) answer.stream().filter((t) -> t.size() == bannedList.size()).count();
    }

    private void dfs(List<List<String>> bannedList, TreeSet<String> tSet, int L) {
        // 기저 조건
        if (L == bannedList.size()) {
            answer.add(new TreeSet<>(tSet));
            return;
        }
        for (String s : bannedList.get(L)) {
            if (tSet.add(s)) {
                dfs(bannedList, tSet, L + 1);
                tSet.remove(s);
            }
        }
    }

    private List<String> getBannedTarget(String[] user_id, String banId) {
        List<String> result = new ArrayList<>();
        banId = banId.replaceAll("[*]", ".");
        for (String userId : user_id) {
            if (userId.matches(banId)) {
                result.add(userId);
            }
        }
        return result;
    }
}