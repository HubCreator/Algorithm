import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CodingTest {

    @Test
    void bitTest() {
        int a = 1;
        assertThat(a << 1).isEqualTo(2);
        assertThat(a << 2).isEqualTo(4);
        assertThat(a >> 1).isEqualTo(0);
        assertThat(a >> 2).isEqualTo(0);
        assertThat(7 ^ 8).isEqualTo(15);
//        System.out.println(Integer.toBinaryString((7 ^ 8) >> 2));
//        System.out.println(Integer.toBinaryString((7 ^ 8) >>> 2));

        int tmp = (int) Math.pow(2, 3);
        System.out.println(Integer.toBinaryString(tmp));
        tmp ^= (int) Math.pow(2, 0);
        System.out.println(Integer.toBinaryString(tmp));
        int first = tmp & (-tmp);
        System.out.println("first = " + first);


        int asdf = 0;
        asdf ^= (int) Math.pow(2, 3);
        System.out.println("Integer.toBinaryString(asdf) = " + Integer.toBinaryString(asdf));


    }

    @Test
    void setTest() {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 3, 3, 4, 4, 5));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(5, 5, 4, 4, 3, 3, 3, 2, 2, 1));
        assertThat(set1).isEqualTo(set2);
        assertThat(set1).isEqualTo(new HashSet<>(Arrays.asList(5, 5, 4, 3, 2, 1)));
    }

    @Test
    void stringBufferTest() {
        StringBuffer sb1 = new StringBuffer("asdf");
        StringBuffer sb2 = new StringBuffer("asdf");
        assertThat(sb1.equals(sb2)).isFalse();
    }

    @Test
    void charToIntTest() {
        assertThat('9' - '0').isEqualTo(9);
        assertThat('8' - '0').isEqualTo(8);
        assertThat('7' - '0').isEqualTo(7);
        assertThat('6' - '0').isEqualTo(6);
    }

    @Test
    void transformTest() {
        assertThat((int) 'A' - 65).isEqualTo(0);
        assertThat((int) 'Z' - 65).isEqualTo(25);
        assertThat((int) 'a' - 71).isEqualTo(26);
        assertThat((int) 'z' - 71).isEqualTo(51);
        System.out.println((int)'+');
        System.out.println((int)'/');
    }

    @Test
    void containTest() {
        List<int[]> list = Arrays.asList(new int[]{1, 2}, new int[]{3, 4});
        assertThat(list.contains(new int[]{1, 2})).isFalse();
    }

    @Test
    void immutableListTest() {
        List<Integer> immutable = List.of(3, 1, 2);
        assertThatThrownBy(() -> Collections.sort(immutable))
                .isInstanceOf(UnsupportedOperationException.class);

        List<Integer> mutable = Arrays.asList(3, 1, 2);
        Collections.sort(mutable);
        assertThat(mutable).containsExactly(1, 2, 3);
    }

    @Test
    void stringbuilderTest() {
        StringBuilder sb = new StringBuilder();
        sb.append("abcd");
        assertThat(sb.reverse().toString()).isEqualTo("dcba");
    }
}
