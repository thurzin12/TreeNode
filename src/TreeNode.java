public class TreeNode {
    private int val;
    private TreeNode left, right;

    public TreeNode(int item) {
        val = item;
        left = right = null;
    }

    // Getters e Setters para encapsulamento
    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
