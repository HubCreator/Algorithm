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
    static int level = 0;
    static int answer = 0;
    static Queue<Node> queue = new LinkedList<>();
    private void BFS(Node root) {
        level++;
        for (int i = 0; i < queue.size(); i++) {
            Node x = queue.poll();
            if(x.lt == null && x.rt == null) answer = level;
            if(x.lt != null) queue.offer(x.lt);
            if(x.rt != null) queue.offer(x.rt);
        }
        if(answer > 0) return;
    }

    public static void main(String[] args) {
        Main T = new Main();
        T.root = new Node(1);
        T.root.lt = new Node(2);
        T.root.rt = new Node(3);

        T.root.lt.lt = new Node(4);
        T.root.lt.rt = new Node(5);

        queue.offer(T.root);
        T.BFS(T.root);
        System.out.println(answer);
    }
}