package text2;

public class Time2 {
    private int hour, minute, second;

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public void setTime(int h, int m, int s){
        hour = ((h >= 0 && h < 24) ? h: 0 );
        minute = ((m >= 0 && m < 60) ? m: 0 );
        second = ((s >= 0 && s < 60) ? s: 0 );
    }
    public String toUniversalString(){
        return String.format("%02d:%02d:%02d", getHour(),getMinute(),getSecond());
    }

    @Override
    public String toString() {
        return String.format("%d:%02d:%02d %s",(getHour() == 0 || getHour() == 12)? 12 : getHour() % 12,
                getMinute(), getSecond(), (getHour() < 12 ? "AM" : "PM"));
    }
}
