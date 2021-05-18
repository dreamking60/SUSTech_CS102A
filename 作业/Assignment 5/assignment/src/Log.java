import java.time.LocalDateTime;

public class Log {
    private int id;
    private String userId;
    private int officeId;
    private double temperature;
    private LocalDateTime dateTime;
    private static int count = 0;

    public Log( String userId, int officeId, double temperature, LocalDateTime dateTime){
        this.userId = userId;
        this.officeId = officeId;
        this.temperature = temperature;
        this.dateTime = dateTime;
        id = count + 1;
        count++;
    }

    public Log( String userId, double temperature, LocalDateTime dateTime){
        this.userId = userId;
        this.temperature = temperature;
        this.dateTime = dateTime;
        id = count + 1;
        count++;
    }

    public Log(){

    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", officeId=" + officeId +
                ", temperature=" + temperature +
                ", dateTime=" + dateTime +
                ", count=" + count +
                '}';
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getOfficeId() {
        return officeId;
    }

    public void setOfficeId(int officeId) {
        this.officeId = officeId;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Log.count = count;
    }
}
