package StorageManagement;

public class Const implements Node {
    private double value;

    public Const(double value) {
        this.value = value;
    }

    @Override
    public double eval() {
        return value;
    }
}
