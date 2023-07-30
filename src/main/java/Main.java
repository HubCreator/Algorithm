public class Main {
    public static void main(String[] args) {
        Main T = new Main();
        Node node2 = new Node(2, new Node(4, null, null), new Node(5, null, null));
        Node node3 = new Node(3, new Node(6, null, null), new Node(7, null, null));
        Node root = new Node(1, node2, node3);

        T.dfs(root);
    }

    private void dfs(Node root) {
        if (root.lt != null) {
            dfs(root.lt);
        }
        if (root.rt != null) {
            dfs(root.rt);
        }
        System.out.print(root.value + " ");
    }

    static class Node {
        private int value;
        private Node lt;
        private Node rt;

        public Node(int value, Node lt, Node rt) {
            this.value = value;
            this.lt = lt;
            this.rt = rt;
        }
    }
}
