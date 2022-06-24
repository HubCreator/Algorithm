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
    static int level = 1;
    static int[] ltArr = new int[1000];
    static int[] rtArr = new int[1000];

    private void DFS(Node root) {
        if (root.lt != null) {
            ltArr[level++] = 1;
            DFS(root.lt);
        }
        if (root.rt != null) {
            rtArr[level++] = 1;
            DFS(root.rt);
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);

        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);

        T.DFS(root);
        int answer = -1;
        for (int i = 1; i < ltArr.length; i++) {
            if (ltArr[i] == 0 || rtArr[i] == 0) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }
}