package bst;

class Node {
    Node left, right;
    int data;

    public Node(int data) {
        left = null;
        right = null;
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

}

class Operasi_BST {
    Node root;

    public Operasi_BST() {
        root = null;
    }

    private Node insert(Node node, int data) {

        if (node == null) {
            node = new Node(data);
        } else {
            if (data <= node.getData()) {
                node.left = insert(node.left, data);
            } else {
                node.right = insert(node.right, data);
            }
        }
        return node;
    }

    public void insert(int data) {
        root = insert(root, data);
    }

    private Node findMin(Node node) {

        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private Node deleteMin(Node node) {

        if (node == null) {
            return null;
        } else if (node.left != null) {
            node.left = deleteMin(node.left);
            return node;
        } else {
            return node.right;
        }
    }

    public Node delete_succesor(Node node, int data) {

        if (node == null) {
            return null;
        } else {
            if (data < node.getData()) {
                node.left = delete_succesor(node.left, data);
            } else if (data > node.getData()) {
                node.right = delete_succesor(node.right, data);
            } else if (node.left != null && node.right != null) {
                node.data = findMin(node.right).data;
                node.right = deleteMin(node.right);
            } else {
                node = (node.left != null ? node.left : node.right);
            }
        }
        return node;
    }

    public void delete_succesor(int data) {

        root = delete_succesor(root, data);
    }

    // Tambahkan method Inorder, Preorder, Postorder
    void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }

    void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data + " ");
        }
    }

    public void hasilTransversal() {
        System.out.println("-----------Inorder-------------");
        inOrder(root);
        System.out.println();
        System.out.println("\n-----------Preorder------------ ");
        preOrder(root);
        System.out.println();
        System.out.println("\n-----------Postorder------------");
        postOrder(root);
    }

    // Tambahkan delete predeccesor
    private Node findMax(Node node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    private Node deleteMax(Node node) {
        if (node == null) {
            return null;
        } else if (node.right != null) {
            node.right = deleteMax(node.right);
            return node;
        } else {
            return node.left;
        }
    }

    public Node delete_predecessor(Node node, int data) {
        if (node == null) {
            return null;
        } else {
            if (data < node.getData()) {
                node.left = delete_predecessor(node.left, data);
            } else if (data > node.getData()) {
                node.right = delete_predecessor(node.right, data);
            } else if (node.left != null && node.right != null) {
                node.data = findMax(node.left).data;
                node.left = deleteMax(node.left);
            } else {
                node = (node.left != null ? node.left : node.right);
            }
        }
        return node;
    }

    public void delete_predecessor(int data) {
        root = delete_predecessor(root, data);
    }

}

public class Implementasi_BST {

    public static void main(String[] args) {

        /**
         * Input data berikut :
         * 25, 20, 36, 10, 22, 30, 40, 5, 12, 28, 38, 38, 48, 1, 8, 15, 45, 50
         * Tampilkan Inorder, Preorder, Postorder
         *
         * Delete node : 25 Secara Succesor
         * Tampilkan Inorder, Preorder, Postorder
         *
         * Delete node : 28 Secara Predeccesor
         * Tampilkan Inorder, Preorder, Postorder
         *
         * Salin program BST yang sudah Anda buat ke Ms. Word beserta Screenshot
         * Console/Output
         * Penamaan Ms. Word : BST_NPM
         * Convert file word anda menjadi PDF kemudian upload pada SPON (Tugas 3 - Tree)
         */
        Operasi_BST bst = new Operasi_BST();

        int[] inputData = { 25, 20, 36, 10, 22, 30, 40, 5, 12, 28, 38, 38, 48, 1, 8, 15, 45, 50 };

        for (int data : inputData) {
            bst.insert(data);
        }

        System.out.println("Insert : 25, 20, 36, 10, 22, 30, 40, 5, 12, 28, 38, 38, 48, 1, 8, 15, 45, 50");
        System.out.println();
        bst.hasilTransversal();

        System.out.println();
        System.out.println();

        System.out.println("================Delete Node 25 secara successor===================");
        bst.delete_succesor(25);
        bst.hasilTransversal();

        System.out.println();
        System.out.println();

        System.out.println("==================Delete Node 28 secara predeccesor================");
        bst.delete_predecessor(28);
        bst.hasilTransversal();
    }
}