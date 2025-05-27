public class Device {
    protected int deviceId;
    protected String deviceName;
    protected String deviceType;
    protected String manufacturer;
    protected String warrantyPeriod;
    protected String status;
    protected String location;
    protected String description;

    public void addDevice(int deviceId, String deviceName, String deviceType, String manufacturer, String warrantyPeriod, String status, String location, String description) {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.deviceType = deviceType;
        this.manufacturer = manufacturer;
        this.warrantyPeriod = warrantyPeriod;
        this.status = status;
        this.location = location;
        this.description = description;
    }

    public void showDevice() {
        System.out.println("Mã thiết bị: " + deviceId);
        System.out.println("Tên thiết bị: " + deviceName);
        System.out.println("Loại thiết bị: " + deviceType);
        System.out.println("Nhà sản xuất: " + manufacturer);
        System.out.println("Thời gian bảo hành: " + warrantyPeriod);
        System.out.println("Trạng thái: " + status);
        System.out.println("Vị trí: " + location);
        System.out.println("Mô tả: " + description);
    }
}
