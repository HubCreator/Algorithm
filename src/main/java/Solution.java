import java.util.HashSet;
import java.util.Set;

public class Solution {
    private static final Set<Integer> set = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        go(0, user_id, banned_id, 0);
        return set.size();
    }

    private static void go(int index, String[] user_id, String[] banned_id, int bit) {
        if (index == banned_id.length) {
            set.add(bit);
            return;
        }
        String reg = banned_id[index].replaceAll("[*]", ".");
        for (int i = 0; i < user_id.length; ++i) {
            // (자기 자신을 가리키거나 || 해당 regex의 대상이 아니라면) continue;
            if ((((bit >> i) & 1) == 1) || !user_id[i].matches(reg)) continue;
            go(index + 1, user_id, banned_id, (bit | 1 << i)); // regex의 대상이라면 해당 bit를 on, index++
        }
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        String[] arr1 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] arr2 = {"fr*d*", "*rodo", "******", "******"};
        System.out.println(T.solution(arr1, arr2));
    }
}