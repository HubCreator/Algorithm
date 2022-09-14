import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String[] arr = new String[]{"1", "100", "90"};
        Arrays.sort(arr);
        for (String s : arr) {
            System.out.println("s = " + s);
        }
    }
}