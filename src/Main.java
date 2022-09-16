
public class Main {
    public static void main(String[] args) {
        int a = 10;
        String s = Integer.toString(a, 2);
        String s1 = Long.toString(a, 2);
        System.out.println("s = " + s);
        System.out.println("s1 = " + s1);
        int x = Integer.parseInt(s, 3);
        System.out.println("x = " + x);
    }
}