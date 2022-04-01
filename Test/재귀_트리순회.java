public class Main {

    static class Node {
        Node(String name) {
            this.name = name;
        }

        Node() {
        }

        String name;
        Node left;
        Node right;
    }

    public static void main(String args[]) {

        Node node1 = new Node("A");
        Node node2 = new Node("B");
        Node node3 = new Node("C");
        Node node4 = new Node("D");
        Node node5 = new Node("E");
        Node node6 = new Node("F");
        Node node7 = new Node("G");

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;
        node6.right = node7;

        next(node1);
    }

    static void pre(Node node) {
        if (node == null)
            return;

        System.out.println(node.name);
        pre(node.left);
        pre(node.right);
    }

    static void mid(Node node) {
        if (node == null)
            return;

        mid(node.left);
        System.out.println(node.name);
        mid(node.right);
    }

    static void next(Node node) {

        if (node == null)
            return;

        next(node.left);
        next(node.right);
        System.out.println(node.name);

    }

}