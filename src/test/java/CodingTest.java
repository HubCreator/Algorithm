import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class CodingTest {

    @Nested
    class InvalidUser {

        @Test
        void case1() {
            String[] userIds = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
            String[] bannedIds = {"fr*d*", "abc1**"};
            assertThat(getTarget(userIds, "fr*d*").size()).isEqualTo(2);
            assertThat(getTarget(userIds, "fr*d*")).containsExactly("frodo", "fradi");
        }

        @Test
        void getAnswer() {
            assertThat(solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "abc1**"})).isEqualTo(2);
            assertThat(solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"*rodo", "*rodo", "******"})).isEqualTo(2);
            assertThat(solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "*rodo", "******", "******"})).isEqualTo(3);

        }

        private TreeSet<String> getTarget(String[] userIds, String bannedId) {
            TreeSet<String> result = new TreeSet<>();
            bannedId = bannedId.replaceAll("[*]", "[a-z|0-9]");
            for (String userId : userIds) {
                if (userId.matches(bannedId)) {
                    result.add(userId);
                }
            }
            return result;
        }
        private int solution(String[] userIds, String[] bannedIds) {
            Set<TreeSet<String>> result = new HashSet<>();
            for (String bannedId : bannedIds) {
                result.add(getTarget(userIds, bannedId));
            }
            return result.size();
        }
    }



}
