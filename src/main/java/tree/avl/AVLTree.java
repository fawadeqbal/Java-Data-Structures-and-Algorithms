/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tree.avl;

/**
 *
 * @author fawad
 */
class Node {
    int key;
    int height;
    Node left;
    Node right;

    Node(int key) {
        this.key = key;
        this.height = 1;
        this.left = null;
        this.right = null;
    }
}

public class AVLTree {
    private Node root;

    public AVLTree() {
        root = null;
    }

    // Calculate the height of a node
    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    // Calculate the balance factor of a node
    private int balanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    // Update the height of a node based on its children's heights
    private void updateHeight(Node node) {
        if (node != null) {
            node.height = 1 + Math.max(height(node.left), height(node.right));
        }
    }

    // Perform a right rotation to balance the tree
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T = x.right;

        x.right = y;
        y.left = T;

        updateHeight(y);
        updateHeight(x);

        return x;
    }

    // Perform a left rotation to balance the tree
    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T = y.left;

        y.left = x;
        x.right = T;

        updateHeight(x);
        updateHeight(y);

        return y;
    }

    // Insert a key into the AVL tree
    public void insert(int key) {
        root = insert(root, key);
    }

    private Node insert(Node node, int key) {
        if (node == null) {
            return new Node(key);
        }

        if (key < node.key) {
            node.left = insert(node.left, key);
        } else if (key > node.key) {
            node.right = insert(node.right, key);
        } else {
            // Duplicate keys are not allowed in this implementation
            return node;
        }

        updateHeight(node);

        int balance = balanceFactor(node);

        // Perform rotations if the AVL property is violated
        if (balance > 1) {
            if (key < node.left.key) {
                return rightRotate(node);
            } else {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        if (balance < -1) {
            if (key > node.right.key) {
                return leftRotate(node);
            } else {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }

        return node;
    }

    // In-order traversal of the AVL tree
    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    private void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.key + " ");
            inOrderTraversal(node.right);
        }
    }

    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();

        avlTree.insert(10);
        avlTree.insert(20);
        avlTree.insert(30);
        avlTree.insert(40);
        avlTree.insert(50);
        avlTree.insert(25);

        System.out.println("In-order traversal of the AVL tree:");
        avlTree.inOrderTraversal();
    }
}
