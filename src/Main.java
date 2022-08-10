import java.util.Deque;
import java.util.LinkedList;

public  class Main {
    public static void main(String[] args) {
        Deque<Integer> deque1 = new LinkedList<>();
        Deque<Integer> deque2 = new LinkedList<>();
        Deque<Integer> deque3 = new LinkedList<>();

        for (int i = 0; i < 10; i++) deque1.offer(i);
        for (int i = 0; i < 10; i++) deque2.offerFirst(i);
        for (int i = 0; i < 10; i++) deque3.offerLast(i);


        for (Integer x : deque1) {
            System.out.print(x + " ");
        }

        System.out.println();
        System.out.println();

        for (Integer x : deque2) {
            System.out.print(x + " ");
        }

        System.out.println();
        System.out.println();

        for (Integer x : deque3) {
            System.out.print(x + " ");
        }
    }
}