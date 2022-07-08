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

    private int DFS(int level, Node root) {
        if (root.lt == null && root.rt == null) return level;
        else return Math.min(DFS(level + 1, root.lt), DFS(level + 1, root.rt));
    }

    public static void main(String[] args) {
        Main T = new Main();
        T.root = new Node(1);
        T.root.lt = new Node(2);
        T.root.rt = new Node(3);

        T.root.lt.lt = new Node(4);
        T.root.lt.rt = new Node(5);

        System.out.println(T.DFS(0, T.root));
    }
}