public class Time {
    private int hour;
    private int minute;
    private int second;

    public Time() {
        this(0, 0, 0);
    }

    public Time(int h, int m, int s){
        this.hour = h;
        this.minute = m;
        this.second = s;
    }
    Time setTime(int h, int m, int s){
        setHour(h);
        setMinute(m);
        setSecond(s);
        return this; 
    }
    Time setHour(int h) {
    this.hour = (h >= 0 && h < 24) ? h : 0;
    return this;
    }
    Time setMinute(int m) {
    this.minute = (m >= 0 && m < 60) ? m : 0;
    return this;
    }

    Time setSecond(int s) {
    this.second = (s >= 0 && s < 60) ? s : 0;
    return this;
    }
    int getHour(){return hour;}
    int getMinute(){return minute;}
    int getSecond(){return second;}

    public String toString(){
        return ((hour == 12 || hour == 0) ? 12 : hour % 12) +
       ":" + (minute < 10 ? "0" : "") + minute +
       ":" + (second < 10 ? "0" : "") + second +
       (hour < 12 ? " AM" : " PM");
    }



}
