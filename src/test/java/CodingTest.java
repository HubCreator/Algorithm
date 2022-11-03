import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class CodingTest {

    @Test
    void bitTest() {
        int a = 1;
        assertThat(a << 1).isEqualTo(2);
        assertThat(a << 2).isEqualTo(4);
        assertThat(a >> 1).isEqualTo(0);
        assertThat(a >> 2).isEqualTo(0);
        assertThat(7 ^ 8).isEqualTo(15);
        System.out.println(Integer.toBinaryString((7 ^ 8) >> 2));
        System.out.println(Integer.toBinaryString((7 ^ 8) >>> 2));
    }

    @Test
    void setTest() {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 3, 3, 4, 4, 5));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(5, 5, 4, 4, 3, 3, 3, 2, 2, 1));
        assertThat(set1).isEqualTo(set2);
        assertThat(set1).isEqualTo(new HashSet<>(Arrays.asList(5, 5, 4, 3, 2, 1)));
    }
}
