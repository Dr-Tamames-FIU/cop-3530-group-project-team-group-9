public class AVLTree {

    private class Node {
        T data;
        Node left;
        Node right;
        int height;

        Node(T data) {
            this.data = data;
            this.height = 1;
        }
    }

    private Node root;

    // Geth the height of a node
    private int height(Node node) {
        if (node == null)
            return 0;
        return node.height;
    }

    // Get balance factor of a node
    private int getBalance(Node node) {
        if (node == null)
            return 0;
        return height(node.left) - height(node.right);
    }

    // Perform a right rotation
    private Node rightRotate(Node y){
        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(yx.left), height(x.right)) + 1;

        // Return new root
        return x;
    }

    // Perform a left rotation
    private Node leftRotate(Node y){
        Node x = y.right;
        Node T2 = x.left;

        // Perform rotation
        x.left = y;
        y.right = T2;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(yx.left), height(x.right)) + 1;

        // Return new root
        return y;
    }

    // Insert a new node
    public void insert(T data) {
        root = insert(root, data);
    }

    private Node insert(Node node, T data){
        // Perform normal BST insertion
        if (node == null)
            return new Node(data);
        
            if (data.compareTo(node.data) < 0)
                node.left = insert(node.left, data);
            else if (data.compareTo(node.data) > 0)
                node.right = insert(node.right, data);
            else // Duplicate keys not allowed
                return node;
            
            // Update height of this ancestor node
            node.height = 1 + Math.max(height(node.left), height(node.right));

            // Get the balance factor to check if rotation is needed
            int balance =  getBalance(node);

            // Left Left Case
            if (balance > 1 && data.compareTo(node.left.data) < 0)
                return rightRotate(node);
            
            // Right Right Case
            if (balance > 1 && data.compareTo(node.right.data) < 0)
                return rightRotate(node);
            
            // Left Right Case
        if (balance > 1 && data.compareTo(node.left.data) > 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && data.compareTo(node.right.data) < 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        // No rotation needed, return the unchanged node
        return node;
    }

    
}
