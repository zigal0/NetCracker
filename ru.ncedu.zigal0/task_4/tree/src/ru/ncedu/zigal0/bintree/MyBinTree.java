package ru.ncedu.zigal0.bintree;

import java.util.Stack;

/**
 * Class MyBinTree represents own realization of binary tree.
 *
 * @author zigal0
 */
public class MyBinTree {
    private Node rootNode;

    /**
     * Default constructor which initialize root = null;
     */
    public MyBinTree() {
        rootNode = null;
    }

    public Node getRootNode() {
        return this.rootNode;
    }

    /**
     * Finds Node of Tree with a given value.
     *
     * @param value - int
     * @return the Node whose value is equal to the given.
     */
    public Node findNode(int value) {
        Node currentNode = rootNode;
        while (currentNode.getValue() != value) {
            if (value < currentNode.getValue()) {
                currentNode = currentNode.getLeftChild();
            } else {
                currentNode = currentNode.getRightChild();
            }
            if (currentNode == null) {
                return null;
            }
        }
        return currentNode;
    }

    /**
     * Adds new Node to the tree.
     *
     * @param value - int
     */
    public void addNode(int value) {
        Node newNode = new Node(value);
        if (rootNode == null) {
            rootNode = newNode;
        } else {
            Node currentNode = rootNode;
            while (true) {
                if (value == currentNode.getValue()) {
                    return;
                }
                if (value < currentNode.getValue()) {
                    if (currentNode.getLeftChild() == null) {
                        currentNode.setLeftChild(newNode);
                        return;
                    } else {
                        currentNode = currentNode.getLeftChild();
                    }
                } else {
                    if (currentNode.getRightChild() == null) {
                        currentNode.setRightChild(newNode);
                        return;
                    } else {
                        currentNode = currentNode.getRightChild();
                    }
                }
            }
        }
    }

    /**
     * Removes a Node with a given value.
     *
     * @param value - int
     * @return true if the Node was removed, otherwise, false.
     */
    public boolean removeNode(int value) {
        Node currentNode = rootNode;
        Node parentNode = rootNode;
        boolean isLeftChild = true;
        // Finds required node with a given value and his paren
        // (Algorithm is similar to findNode however we need parent as well)
        while (currentNode.getValue() != value) {
            parentNode = currentNode;
            if (value < currentNode.getValue()) {
                isLeftChild = true;
                currentNode = currentNode.getLeftChild();
            } else {
                isLeftChild = false;
                currentNode = currentNode.getRightChild();
            }
            if (currentNode == null) {
                return false;
            }
        }
        // Rebuilding a tree
        if (currentNode.getLeftChild() == null && currentNode.getRightChild() == null) {
            // No children for the node to be removed
            if (currentNode == rootNode) {
                rootNode = null;
            } else if (isLeftChild) {
                parentNode.setLeftChild(null);
            } else {
                parentNode.setRightChild(null);
            }
        } else if (currentNode.getRightChild() == null) {
            // The node to be removed has left child
            if (currentNode == rootNode) {
                rootNode = currentNode.getLeftChild();
            } else if (isLeftChild) {
                parentNode.setLeftChild(currentNode.getLeftChild());
            } else {
                parentNode.setRightChild(currentNode.getLeftChild());
            }
        } else if (currentNode.getLeftChild() == null) {
            // The node to be removed has right child
            if (currentNode == rootNode) {
                rootNode = currentNode.getRightChild();
            } else if (isLeftChild) {
                parentNode.setLeftChild(currentNode.getRightChild());
            } else {
                parentNode.setRightChild(currentNode.getRightChild());
            }
        } else {
            // The node to be removed has 2 children
            Node heir = findHeir(currentNode);
            if (currentNode == rootNode) {
                rootNode = heir;
            } else if (isLeftChild) {
                parentNode.setLeftChild(heir);
            } else {
                parentNode.setRightChild(heir);
            }
        }
        return true;
    }

    /**
     * Finds an heir in place of a given node.
     *
     * @param node - Node.
     * @return Node heir.
     */
    private Node findHeir(Node node) {
        Node parentNode = node;
        Node heirNode = node;
        Node currentNode = node.getRightChild();
        while (currentNode != null) {
            parentNode = heirNode;
            heirNode = currentNode;
            currentNode = currentNode.getLeftChild();
        }
        if (heirNode != node.getRightChild()) {
            parentNode.setLeftChild(heirNode.getRightChild());
            heirNode.setRightChild(node.getRightChild());
            heirNode.setLeftChild(node.getLeftChild());
        }
        return heirNode;
    }

    /**
     * Finds height of subTree using recursion.
     *
     * @param root - the Node to which height will be calculated.
     * @return int - height of subTree.
     */
    public int height(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.getLeftChild()), height(root.getRightChild()));
    }

    /**
     * Performs inorder traversal and display value of every Node(recursion).
     * Explanation: all nodes in the left subtree -> root node -> all nodes in the right subtree.
     *
     * @param root - Node where traversal will be started.
     */
    public void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.getLeftChild());
        System.out.print(root.getValue() + "  ");
        inorder(root.getRightChild());
    }

    /**
     * Performs preorder traversal and display value of every Node (recursion).
     * Explanation: root node -> all nodes in the left subtree ->  all nodes in the right subtree.
     *
     * @param root - Node where traversal will be started.
     */
    public void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.getValue() + "  ");
        preorder(root.getLeftChild());
        preorder(root.getRightChild());
    }

    /**
     * Performs postorder traversal and display value of every Node (recursion).
     * Explanation: all nodes in the left subtree -> all nodes in the right subtree -> root node.
     *
     * @param root - Node where traversal will be started.
     */
    public void postorder(Node root) {
        if (root == null) {
            return;
        }
        postorder(root.getLeftChild());
        postorder(root.getRightChild());
        System.out.print(root.getValue() + "  ");
    }

    /**
     * Prints scheme of MyBinTree. [] instead of empty space.
     */
    public void print() {
        // Global stack
        Stack<Node> globalStack = new Stack<>();
        globalStack.push(rootNode);
        // Scales gaps between nodes
        int gaps = (int) Math.pow(2, height(rootNode));
        boolean isEnd = false;
        while (!isEnd) {
            Stack<Node> localStack = new Stack<>();
            isEnd = true;
            // Prints gaps
            for (int j = 0; j < gaps; j++)
                System.out.print(' ');
            while (!globalStack.isEmpty()) {
                Node current = globalStack.pop();
                if (current != null) {
                    System.out.print(current.getValue());
                    localStack.push(current.getLeftChild());
                    localStack.push(current.getRightChild());
                    if (current.getLeftChild() != null || current.getRightChild() != null) {
                        isEnd = false;
                    }
                } else {
                    // Prints [] instead empty space
                    System.out.print("[]");
                    localStack.push(null);
                    localStack.push(null);
                }
                // Prints gaps
                for (int j = 0; j < gaps * 2 - 2; j++) {
                    System.out.print(' ');
                }
            }
            System.out.println();
            gaps /= 2;
            // Transfers nodes from localStack to GlobalStack with correct order
            while (!localStack.isEmpty()) {
                globalStack.push(localStack.pop());
            }
        }
    }
}
