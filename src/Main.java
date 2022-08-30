import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>(List.of(1, 2));
        System.out.println("set.add(1) = " + set.add(1));
        System.out.println("set.add(3) = " + set.add(3));
    }
}