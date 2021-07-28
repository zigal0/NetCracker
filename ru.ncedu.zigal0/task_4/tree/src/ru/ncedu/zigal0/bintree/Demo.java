package ru.ncedu.zigal0.bintree;

public class Demo {
    public static void main(String[] args) {
        MyBinTree tree = new MyBinTree();
        tree.addNode(6);
        tree.addNode(8);
        tree.addNode(5);
        tree.addNode(8);
        tree.addNode(2);
        tree.addNode(9);
        tree.addNode(7);
        tree.addNode(4);
        tree.addNode(10);
        tree.addNode(3);
        tree.addNode(1);
        tree.addNode(11);

        tree.inorder(tree.getRootNode());
        System.out.println();
        tree.preorder(tree.getRootNode());
        System.out.println();
        tree.postorder(tree.getRootNode());
        System.out.println();

        tree.printTree();
        System.out.println(tree.deleteNode(5));
        System.out.println(tree.findNodeValue(5));
        System.out.println(tree.findNodeValue(6));
        System.out.println(tree.findNodeValue(20));
        tree.printTree();
        System.out.println(tree.computeHeight(tree.getRootNode()));
    }
}
