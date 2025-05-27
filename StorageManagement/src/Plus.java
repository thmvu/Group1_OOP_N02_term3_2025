package StorageManagement;

public class Plus extends Binop {
    public Plus(Node left, Node right) {
        super(left, right);
    }

    @Override
    public double eval() {
        return left.eval() + right.eval();
    }
}
