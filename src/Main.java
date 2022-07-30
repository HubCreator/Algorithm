public class Main {
    public static void main(String[] args) {
        int a = 10;
        String b = Integer.toString(a, 2);
        System.out.println(b);
        System.out.println(Integer.parseInt(b, 2));
    }
}