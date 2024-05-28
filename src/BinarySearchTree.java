public class BinarySearchTree {
    private TreeNode root;

    public BinarySearchTree() {
        root = null;
    }

    // Método público para inserção
    public void insert(int key) {
        root = insertRec(root, key);
    }

    private TreeNode insertRec(TreeNode root, int key) {
        if (root == null) {
            root = new TreeNode(key);
            return root;
        }
        if (key < root.getVal())
            root.setLeft(insertRec(root.getLeft(), key));
        else if (key > root.getVal())
            root.setRight(insertRec(root.getRight(), key));

        return root;
    }

    // Método público para remoção
    public void deleteKey(int key) {
        root = deleteRec(root, key);
    }

    private TreeNode deleteRec(TreeNode root, int key) {
        if (root == null) return root;

        if (key < root.getVal())
            root.setLeft(deleteRec(root.getLeft(), key));
        else if (key > root.getVal())
            root.setRight(deleteRec(root.getRight(), key));
        else {
            // Nó com um ou nenhum filho
            if (root.getLeft() == null)
                return root.getRight();
            else if (root.getRight() == null)
                return root.getLeft();

            // Nó com dois filhos: obtém o sucessor em ordem (menor na subárvore direita)
            root.setVal(minValue(root.getRight()));

            // Remove o sucessor em ordem
            root.setRight(deleteRec(root.getRight(), root.getVal()));
        }

        return root;
    }

    private int minValue(TreeNode root) {
        int minv = root.getVal();
        while (root.getLeft() != null) {
            minv = root.getLeft().getVal();
            root = root.getLeft();
        }
        return minv;
    }

    // Método para buscar um nó específico
    public TreeNode search(int key) {
        return searchRec(root, key);
    }

    private TreeNode searchRec(TreeNode root, int key) {
        if (root == null || root.getVal() == key)
            return root;

        if (key < root.getVal())
            return searchRec(root.getLeft(), key);

        return searchRec(root.getRight(), key);
    }

    // Travessia em ordem para imprimir a árvore
    public void inorder() {
        inorderRec(root);
        System.out.println();
    }

    private void inorderRec(TreeNode root) {
        if (root != null) {
            inorderRec(root.getLeft());
            System.out.print(root.getVal() + " ");
            inorderRec(root.getRight());
        }
    }

    // Travessia pré-ordem
    public void preorder() {
        preorderRec(root);
        System.out.println();
    }

    private void preorderRec(TreeNode root) {
        if (root != null) {
            System.out.print(root.getVal() + " ");
            preorderRec(root.getLeft());
            preorderRec(root.getRight());
        }
    }

    // Travessia pós-ordem
    public void postorder() {
        postorderRec(root);
        System.out.println();
    }

    private void postorderRec(TreeNode root) {
        if (root != null) {
            postorderRec(root.getLeft());
            postorderRec(root.getRight());
            System.out.print(root.getVal() + " ");
        }
    }

    // Método para verificar se um nó é folha
    public boolean isLeaf(TreeNode node) {
        return node != null && node.getLeft() == null && node.getRight() == null;
    }

    // Getter para o root
    public TreeNode getRoot() {
        return root;
    }
}
