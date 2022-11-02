import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class CodingTest {

    @Test
    void bitTest() {
        int a = 1;
        assertThat(a << 1).isEqualTo(2);
        assertThat(a << 2).isEqualTo(4);
        assertThat(a >> 1).isEqualTo(0);
        assertThat(a >> 2).isEqualTo(0);
    }

}
