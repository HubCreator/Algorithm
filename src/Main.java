import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String str = "a b      c";
        String[] s = str.split(" ");
        for (String s1 : s) {
            System.out.println("s1 = " + s1);
        }
    }
}