import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PolymorpismTest {
    static class Parent {
        String parentName;
        String parentFoo() {
            return "parent";
        }
        String foo() {
            return "parent";
        }
    }

    static class Child extends Parent {
        String childName;
        String childFoo() {
            return "child";
        }
        @Override
        String foo() {
            return "child";
        }
    }

    @Test
    void instanceofTest() {
        Parent parent = new Parent();
        Child child = new Child();
        assertThat(child instanceof Child).isTrue();
        assertThat(child instanceof Parent).isTrue();
        assertThat(parent instanceof Parent).isTrue();
        assertThat(parent instanceof Child).isFalse();
    }

    @Test
    void referenceTest() {
        Parent p = new Child();
        Child c = new Child();

        assertThat(p.foo()).isEqualTo("child");
        assertThat(c.foo()).isEqualTo("child");
        Child cc = (Child) p;
        assertThat(cc.childFoo()).isEqualTo("child");
    }
}
