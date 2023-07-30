import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Main T = new Main();
        Node node2 = new Node(2, new Node(4, null, null), new Node(5, null, null));
        Node node3 = new Node(3, new Node(6, null, null), new Node(7, null, null));
        Node root = new Node(1, node2, node3);

        T.bfs(root);
    }

    private void bfs(Node root) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                Node poll = queue.poll();
                System.out.print(poll.value + " ");
                if (poll.lt != null) {
                    queue.offer(poll.lt);
                }
                if (poll.rt != null) {
                    queue.offer(poll.rt);
                }
            }
        }
    }

    static class Node {
        private int value;
        private Node lt, rt;

        public Node(int value, Node lt, Node rt) {
            this.value = value;
            this.lt = lt;
            this.rt = rt;
        }
    }
}
