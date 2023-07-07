package tree;


class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
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
        } else if (key > root.key) {
            root.right = inorderInsertNode(root.right, key);
        }

        return root;
    }

    public void preorderInsert(int key) {
        root = preorderInsertNode(root, key);
    }

    private Node preorderInsertNode(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }

        if (key < root.key) {
            root.left = preorderInsertNode(root.left, key);
        }

        root.right = preorderInsertNode(root.right, key);

        return root;
    }

    public void postorderInsert(int key) {
        root = postorderInsertNode(root, key);
    }

    private Node postorderInsertNode(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }

        root.left = postorderInsertNode(root.left, key);
        root.right = postorderInsertNode(root.right, key);

        return root;
    }

    public void inorderTraversal() {
        inorder(root);
    }

    private void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }

    public void preorderTraversal() {
        preorder(root);
    }

    private void preorder(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    public void postorderTraversal() {
        postorder(root);
    }

    private void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.key + " ");
        }
    }
}

    
