package StorageManagement;

public abstract class Binop implements Node {
    protected Node left;
    protected Node right;

    public Binop(Node left, Node right) {
        this.left = left;
        this.right = right;
    }
}
