import java.time.LocalDate;
import java.time.LocalDateTime;

public class User {
    private String id;
    private String name;
    private Role role;
    private ResidentialCollege residentialCollege;
    private String department;
    private String district;
    private String domain;
    private int buildingNo;
    private int roomNo;
    private LocalDate dateBackToShenzhen;
    private boolean isValid = true;
    private double bodyTemperature;
    private LocalDateTime temperatureTestTime;

    public User(String id, String name, int gender){
        this.id = id;
        this.name = name;

    }

    public void takeTemperature(double temperature, LocalDateTime dateTime){
        bodyTemperature = temperature;
        temperatureTestTime = dateTime;
    }

    @Override
    public String toString(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public ResidentialCollege getResidentialCollege() {
        return residentialCollege;
    }

    public void setResidentialCollege(ResidentialCollege residentialCollege) {
        this.residentialCollege = residentialCollege;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
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

    public LocalDate getDateBackToShenzhen() {
        return dateBackToShenzhen;
    }

    public void setDateBackToShenzhen(LocalDate dateBackToShenzhen) {
        this.dateBackToShenzhen = dateBackToShenzhen;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public double getBodyTemperature() {
        return bodyTemperature;
    }

    public void setBodyTemperature(double bodyTemperature) {
        this.bodyTemperature = bodyTemperature;
    }

    public LocalDateTime getTemperatureTestTime() {
        return temperatureTestTime;
    }

    public void setTemperatureTestTime(LocalDateTime temperatureTestTime) {
        this.temperatureTestTime = temperatureTestTime;
    }


}
