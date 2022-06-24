import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node lt;
    Node rt;

    public Node(int data) {
        this.data = data;
        lt = null;
        rt = null;
    }
}

public class Main {
    Node root;

    private int BFS(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root); // 초기값
        int level = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node x = queue.poll();
                if (x.lt == null && x.rt == null) return level;
                if (x.lt != null) queue.offer(x.lt);
                if (x.rt != null) queue.offer(x.rt);
            }
            level++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Main T = new Main();
        T.root = new Node(1);
        T.root.lt = new Node(2);
        T.root.rt = new Node(3);

        T.root.lt.lt = new Node(4);
        T.root.lt.rt = new Node(5);

        System.out.println(T.BFS(T.root));
    }
}