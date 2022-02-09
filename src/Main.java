import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node lt, rt;
    Node(int data) {
        this.data = data;
        this.lt = null;
        this.rt = null;
    }
}

// 말단노드까지의 길이 구하기 (BFS 탐색)
class Main {
    public static void main(String[] args) {
        Node root = new Node(1);

        root.lt = new Node(2);
        root.rt = new Node(3);

        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);

        System.out.println(BFS(root));
    }

    private static int BFS(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int L = 0;
        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int i = 0; i < len; i++) {
                Node cur = queue.poll();
                if(cur.lt == null && cur.rt == null) return L;
                if(cur.lt != null) queue.offer(cur.lt);
                if(cur.rt != null) queue.offer(cur.rt);
            }
            L++;
        }
        return 0;
    }
}