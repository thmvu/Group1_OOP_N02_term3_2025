public class Warehouse1 {
    private int id;
    private String location;

    public Warehouse1(int id, String location) {
        this.id = id;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return id + " - " + location;
    }
}