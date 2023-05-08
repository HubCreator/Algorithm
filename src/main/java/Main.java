import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

class Myclass {
    private final String name;
    private final int age;

    Myclass(final String name, final int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Myclass{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class Main {
    public static void main(String args[]) throws Exception {
        final Class<Boolean> clazz = Boolean.class;
        final Field field = clazz.getDeclaredField("FALSE");
        field.setAccessible(true);

        final Field modifier = Field.class.getDeclaredField("modifiers");
        modifier.setAccessible(true);
        modifier.setInt(field, field.getModifiers() & ~Modifier.FINAL);
        System.out.println("modifier = " + field.getModifiers());

        field.set(null, true);

        System.out.format("Everything is %s", false); // "Everything is true"
        System.out.println();
        System.out.println(false); //false
        System.out.println(Boolean.FALSE); //true
    }
}


class MyClass2 {
    public static final String HELLO = new String("hello");
    public static final int hi = 10;
}

class Hello {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        final Class<MyClass2> clazz = MyClass2.class;
        final Field field = clazz.getDeclaredField("hi");
        field.setAccessible(true);

        final Field modifier = Field.class.getDeclaredField("modifiers");
        modifier.setAccessible(true);
        modifier.setInt(field, field.getModifiers() & ~Modifier.FINAL);
        System.out.println("field.getModifiers() = " + field.getModifiers());

        field.set(null, 1000);

        System.out.println(MyClass2.hi);
    }
}
