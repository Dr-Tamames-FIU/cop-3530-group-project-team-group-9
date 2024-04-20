package Main;

public class AVLTree {
    private Node root;

    private class Node {
        Flight flight;
        Node left;
        Node right;
        int height;

        Node(Flight flight) {
            this.flight = flight;
            this.height = 1;
        }
    }

    public void insert(Flight flight) {
        root = insert(root, flight);
    }

    private Node insert(Node node, Flight flight) {
        if (node == null) {
            return new Node(flight);
        }

        if (flight.getFlightNumber().compareTo(node.flight.getFlightNumber()) < 0) {
            node.left = insert(node.left, flight);
        } else if (flight.getFlightNumber().compareTo(node.flight.getFlightNumber()) > 0) {
            node.right = insert(node.right, flight);
        } else {
            // Duplicate flight number, do nothing
            return node;
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = getBalance(node);

        // Left Left Case
        if (balance > 1 && flight.getFlightNumber().compareTo(node.left.flight.getFlightNumber()) < 0) {
            return rightRotate(node);
        }

        // Right Right Case
        if (balance < -1 && flight.getFlightNumber().compareTo(node.right.flight.getFlightNumber()) > 0) {
            return leftRotate(node);
        }

        // Left Right Case
        if (balance > 1 && flight.getFlightNumber().compareTo(node.left.flight.getFlightNumber()) > 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && flight.getFlightNumber().compareTo(node.right.flight.getFlightNumber()) < 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    private int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    public void inorder() {
        inorder(root);
    }

    private void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.println(node.flight.getFlightNumber());
            inorder(node.right);
        }
    }
}
