import org.junit.jupiter.api.Test;


import java.util.*;

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

    @Test
    void arrayDeepCopy() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] ints1 = Arrays.copyOf(arr, 3);
        ints1[0] = -1;
        assertThat(ints1).containsExactly(-1, 2, 3); // 처음 세 개 deep copy
        assertThat(arr[0]).isEqualTo(1);

        int[] ints2 = Arrays.copyOfRange(arr, 1, 3);
        assertThat(ints2).containsExactly(2, 3);

        int[] result = new int[5];
        System.arraycopy(arr, 0, result, 0, result.length);
        assertThat(result).containsExactly(1, 2, 3, 4, 5);

        result = new int[5];
        System.arraycopy(arr, 0, result, 3, result.length - 3);
        assertThat(result).containsExactly(0, 0, 0, 1, 2);
    }

    @Test
    void collectionNullTest() {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = null;
        List<Integer> list3 = Arrays.asList(1, 2, 3);

        assertThat(list1.isEmpty()).isTrue();
        assertThat(list2 == null).isTrue();
    }

    @Test
    void setTest() {
        Set<int[]> set = new HashSet<>();
        set.add(new int[]{1, 2});
        set.add(new int[]{1, 2});
        set.add(new int[]{1, 2});
        assertThat(set.size()).isEqualTo(3);
    }

    @Test
    void arrayReference() {
        Integer[][] arr1 = {{1, 2}, {3, 4}};
        int t = arr1[0][0];
        t = -1;
        assertThat(arr1[0][0]).isEqualTo(1);
    }

    @Test
    void test() {
        Child child = new Child(1);
        String h1 = child.hello();
        int h2 = child.hello(1, 2, 3);
        assertThat(h1).isEqualTo("1");
        assertThat(h2).isEqualTo(6);
    }

    static class Paranet {
        int a;

        public Paranet(int a) {
            this.a = a;
        }
    }

    static class Child extends Paranet{

        public Child(int a) {
            super(a);
        }

        public String  hello() {
            return "1";
        }

        public int hello(int a) {
            return a;
        }

        public int hello(int a, int b, int c) {
            return a + b + c;
        }
    }

    @Test
    void integerCompare() {
        assertThat(Integer.compare(1, 1)).isEqualTo(0);
        assertThat(Integer.compare(1, 100)).isEqualTo(-1);
        assertThat(Integer.compare(100, 1)).isEqualTo(1);
    }
}
