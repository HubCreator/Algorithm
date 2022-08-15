import java.util.Deque;
import java.util.LinkedList;

public  class Main {
    public static void main(String[] args) {
        int a = 2, b = 6;
        String s = Long.toBinaryString(a ^ b);
        System.out.println("s = " + s);
    }
}