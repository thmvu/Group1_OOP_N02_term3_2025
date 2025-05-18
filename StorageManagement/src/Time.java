public class Time {
    private int hours;
    private int minutes;
    private int seconds;

    // Constructor
    public Time(int hours, int minutes, int seconds) {
        if (hours < 0 || minutes < 0 || seconds < 0) {
            this.hours = 0;
            this.minutes = 0;
            this.seconds = 0;
        } else {
            this.hours = hours;
            this.minutes = minutes;
            this.seconds = seconds;
            normalize(); // Chuẩn hóa sau khi gán
        }
    }

    // Chuẩn hóa thời gian: 75 giây => +1 phút 15 giây, 70 phút => +1 giờ 10 phút
    private void normalize() {
        if (seconds >= 60) {
            minutes += seconds / 60;
            seconds = seconds % 60;
        }

        if (minutes >= 60) {
            hours += minutes / 60;
            minutes = minutes % 60;
        }
    }

    // Phương thức cộng thêm thời gian từ 1 đối tượng khác
    public void addTime(Time other) {
        this.hours += other.hours;
        this.minutes += other.minutes;
        this.seconds += other.seconds;
        normalize(); // Chuẩn hóa sau khi cộng
    }

    // Trả về tổng số giây
    public int toTotalSeconds() {
        return hours * 3600 + minutes * 60 + seconds;
    }

    // toString để hiển thị
    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    // Các getter nếu cần
    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }
}
