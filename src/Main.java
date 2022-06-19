class Node {
    int data;
    Node lt, rt;

    public Node(int val) {
        this.data = val;
        lt = rt = null;
    }
}
/*
* 부모를 기준으로,
* 부모가 처음이면 전위, 중간이면 중위, 후면 후위
* */
public class Main {
    Node root;
    public void DFS(Node root) {
        if(root == null) return;
        System.out.print(root.data + " ");
        DFS(root.lt);
        DFS(root.rt);
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

        tree.DFS(tree.root);
    }
}