package ru.ncedu.zigal0.bintree;

public class Demo {
    public static void main(String[] args) {
        String separator = "*****************************************************************";
        MyBinTree tree = new MyBinTree();
        tree.addNode(11);
        tree.addNode(13);
        tree.addNode(10);
        tree.addNode(15);
        tree.addNode(7);
        tree.addNode(14);
        tree.addNode(11);
        tree.addNode(9);
        tree.addNode(15);
        tree.addNode(8);
        tree.addNode(6);
        tree.addNode(16);

        tree.print();

        // Shows different traversals
        System.out.println(separator);
        System.out.println("inorder");
        tree.inorder(tree.getRootNode());
        System.out.println();
        System.out.println(separator);
        System.out.println("preorder");
        tree.preorder(tree.getRootNode());
        System.out.println();
        System.out.println(separator);
        System.out.println("postorder");
        tree.postorder(tree.getRootNode());
        System.out.println();
        System.out.println(separator);

        // Shows remove and find functions
        System.out.println("Try to remove Node with value 7");
        System.out.println(tree.removeNode(7));
        System.out.println(separator);
        System.out.println("Try to find Node with value 10");
        System.out.println(tree.findNode(10));
        System.out.println(separator);
        System.out.println("Try to find Node with value 20");
        System.out.println(tree.findNode(20));
        System.out.println(separator);

        tree.print();

        // Calculates height of tree
        System.out.println(separator);
        System.out.println("Height of Tree is " + tree.height(tree.getRootNode()));
    }
}
