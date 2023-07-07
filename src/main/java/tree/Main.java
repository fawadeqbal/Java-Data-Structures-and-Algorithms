package tree;

import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 *
 * @author fawad
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        BinarySearchTree tree = new BinarySearchTree();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 4) {
            System.out.println("\nBinary Search Tree Menu:");
            System.out.println("1. Inorder Insertion");
            System.out.println("2. Preorder Insertion");
            System.out.println("3. Postorder Insertion");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the key to insert: ");
                    int inorderInsertKey = scanner.nextInt();
                    tree.inorderInsert(inorderInsertKey);
                    System.out.println("Key " + inorderInsertKey + " inserted into the tree using inorder insertion.");
                    break;
                case 2:
                    System.out.print("Enter the key to insert: ");
                    int preorderInsertKey = scanner.nextInt();
                    tree.preorderInsert(preorderInsertKey);
                    System.out.println("Key " + preorderInsertKey + " inserted into the tree using preorder insertion.");
                    break;
                case 3:
                    System.out.print("Enter the key to insert: ");
                    int postorderInsertKey = scanner.nextInt();
                    tree.postorderInsert(postorderInsertKey);
                    System.out.println("Key " + postorderInsertKey + " inserted into the tree using postorder insertion.");
                    break;
                case 4:
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }

        System.out.println("Inorder traversal:");
        tree.inorderTraversal();

        System.out.println("\nPreorder traversal:");
        tree.preorderTraversal();

        System.out.println("\nPostorder traversal:");
        tree.postorderTraversal();

        scanner.close();
    }
    
}
