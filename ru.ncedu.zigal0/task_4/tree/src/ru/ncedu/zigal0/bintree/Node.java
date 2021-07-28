package ru.ncedu.zigal0.bintree;

public class Node {
    private Node leftChild;
    private Node rightChild;
    private int value;

    public Node(int value) {
        this.value = value;
        leftChild = null;
        rightChild = null;
    }

    public Node(){}

    public void printNode() {
        System.out.println("This node has value: " + value);
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", leftChild=" + leftChild +
                ", rightChild=" + rightChild +
                '}';
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getLeftChild() {
        return this.leftChild;
    }

    public Node getRightChild() {
        return this.rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }
}

