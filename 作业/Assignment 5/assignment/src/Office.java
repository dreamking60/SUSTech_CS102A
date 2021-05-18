public class Office {
    private int id;
    private String domain;
    private int buildingNo;
    private int roomNo;
    private double area;
    private boolean isValid = true;
    private static int count = 0;
    private int visitorCountToday = 0;

    public Office(){
        id = count + 1;
        count++;

    }

    public Office(String domain, int buildingNo, int roomNo, double area){
        this.domain = domain;
        this.buildingNo = buildingNo;
        this.roomNo = roomNo;
        this.area = area;
        id = count + 1;
        count++;
    }

    @Override
    public String toString() {
        return "Office{" +
                "id=" + id +
                ", domain='" + domain + '\'' +
                ", buildingNo=" + buildingNo +
                ", roomNo=" + roomNo +
                ", area=" + area +
                ", count=" + count +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public int getBuildingNo() {
        return buildingNo;
    }

    public void setBuildingNo(int buildingNo) {
        this.buildingNo = buildingNo;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Office.count = count;
    }

    public int getVisitorCountToday() {
        return visitorCountToday;
    }

    public void setVisitorCountToday(int visitorCountToday) {
        this.visitorCountToday = visitorCountToday;
    }

}
