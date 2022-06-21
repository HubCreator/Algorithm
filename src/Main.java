import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node lt, rt;

    public Node(int val) {
        this.data = val;
        lt = rt = null;
    }
}

// 레벨 탐색 (넓이 우선 탐색)
public class Main {
    Node root;

    // 이진트리 레벨탐색 (BFS)
    private void BFS(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node cur = queue.poll();
                System.out.print(cur.data + " ");
                if(cur.lt != null) queue.offer(cur.lt);
                if(cur.rt != null) queue.offer(cur.rt);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Main tree = new Main();
        tree.root = new Node(1);

        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);

        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);

        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);

        tree.BFS(tree.root);
    }
}