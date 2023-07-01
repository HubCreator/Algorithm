import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void test() {
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(3);

        assertThat(hashSet).hasSize(3);
        hashSet.clear();
        assertThat(hashSet).hasSize(0);
    }

}
