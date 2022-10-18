import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.*;


public class JavaGrammarTest {
    @Test
    void 진수_계산() {
        int a = 5;
        String s1 = Integer.toBinaryString(a);
        String s2 = Integer.toString(a, 2);
        String s3 = Integer.toString(a, 3);
        assertThat(s1).isEqualTo("101");
        assertThat(s2).isEqualTo("101");
        assertThat(s3).isEqualTo("12");

        int v1 = Integer.parseInt(s1, 2);
        int v2 = Integer.parseInt(s2, 2);
        int v3 = Integer.parseInt(s3, 3);
        assertThat(v1).isEqualTo(5);
        assertThat(v2).isEqualTo(5);
        assertThat(v3).isEqualTo(5);
    }
}
