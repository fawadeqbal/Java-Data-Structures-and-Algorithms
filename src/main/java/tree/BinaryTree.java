/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tree;

/**
 *
 * @author fawad
 */
class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

public class BinaryTree {
    Node root;

    public BinaryTree() {
        root = null;
    }

    public void inorderInsert(int key) {
        root = inorderInsertNode(root, key);
    }
    
    private Node inorderInsertNode(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }

        if (key < root.key) {
            root.left = inorderInsertNode(root.left, key);
        } else if (key >= root.key) {
            root.right = inorderInsertNode(root.right, key);
        }

        return root;
    }
    
    private void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }
    
     public void inorderTraversal() {
        inorder(root);
    }
}
