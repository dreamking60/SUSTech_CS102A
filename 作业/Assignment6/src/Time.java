public class Time {
    private int hour;
    private int minute;

    public Time(){}

    public Time(int hour, int minute){
        this.hour = hour;
        this.minute = minute;
    }

    @Override
    public String toString(){
        String time1;
        String time2;
        if( hour < 10 ){
            time1 = "0"+hour;
        }else{
            time1 = ""+hour;
        }
        if( minute < 10 ){
            time2 = "0"+minute;
        }else{
            time2 = ""+minute;
        }

        return String.format(
                "%s:%s", time1, time2
        );
    }

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

}
