public class TestDevice {
    public static void main(String[] args) {
        Device device = new Device();
        device.addDevice(1, "Laptop", "Electronics", "Dell", "2 years", "Available", "Room 101", "Dell XPS 13");
        device.showDevice();
        device.addDevice(2, "Projector", "Electronics", "Epson", "1 year", "Available", "Room 102", "Epson PowerLite");
        device.showDevice();
        
    }
    
}
