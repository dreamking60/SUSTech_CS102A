import java.time.*;
import java.util.ArrayList;

public class Data {
    private static ArrayList<User> userList;
    private static ArrayList<Group> groupList;
    private static ArrayList<Office> officeList;

    public static ArrayList<User> getUserList() {
        return userList;
    }

    public static void setUserList(ArrayList<User> userList) {
        Data.userList = userList;
    }

    public static ArrayList<Group> getGroupList() {
        return groupList;
    }

    public static void setGroupList(ArrayList<Group> groupList) {
        Data.groupList = groupList;
    }

    public static ArrayList<Office> getOfficeList() {
        return officeList;
    }

    public static void setOfficeList(ArrayList<Office> officeList) {
        Data.officeList = officeList;
    }

    public static ArrayList<Log> getLogList() {
        return logList;
    }

    public static void setLogList(ArrayList<Log> logList) {
        Data.logList = logList;
    }

    private static ArrayList<Log> logList;

    public Data(){
        userList = new ArrayList<User>();
        groupList = new ArrayList<Group>();
        officeList = new ArrayList<Office>();
        logList = new ArrayList<Log>();
    }

    public static void initialize(){

    }

    public String addUser(User user){
        for( int i = 0; i < userList.size(); i++ ){
            if( userList.get(i).equals(user)){
                if(userList.get(i).isValid() == false ){
                    userList.get(i).setValid(true);
                }
                return "user already exists";
            }
        }
        userList.add(user);
        return "addUser succeed";
    }

    public String deleteUser(String userId){
        User deUser = null;
        for( int i = 0; i < userList.size(); i++ ){
            if( userList.get(i).getId().equals(userId) ){
                deUser = userList.get(i);
                userList.get(i).setValid(false);
            }
        }
        if( deUser.equals(null)){
            return "user not exists";
        }else {
            return "deleteUser succeed";
        }
    }

    public User getUser(String userId){
        User user = null;
        for( int i = 0; i < userList.size(); i++ ){
            if( userList.get(i).getId().equals(userId) ){
                user = userList.get(i);
                return user;
            }
        }
        return null;
    }

    public String addGroup(Group group){
        for( int i = 0; i < groupList.size(); i++ ){
            if( groupList.get(i).equals(group)){
                groupList.get(i).setValid(true);
                return "group already exists";
            }
        }
        groupList.add(group);
        return "addGroup succeed";
    }

    public String deleteGroup(int groupId){
        for( int i = 0; i < groupList.size(); i++ ){
            if( groupList.get(i).getId() == groupId){
                groupList.get(i).setValid(false);
                return "deleteGroup succeed";
            }
        }
        return "group not exist";
    }

    public Group getGroup( int groupId){
        for( int i = 0; i < groupList.size(); i++ ){
            if(groupList.get(i).getId() == groupId){
                return groupList.get(i);
            }
        }
        return null;
    }

    public String addOffice(Office office){
        for( int i = 0; i < officeList.size(); i++ ){
            if( officeList.get(i).getId() == office.getId()){
                officeList.get(i).setValid(true);
                return "office already exists";
            }
        }
        officeList.add(office);
        return "addOffice succeed";
    }

    public String deleteOffice(int officeId){
        for(int i = 0; i < officeList.size(); i++ ){
            if( officeList.get(i).getId() == officeId){
                officeList.get(i).setValid(false);
                return "deleteOffice succeed";
            }
        }
        return "office not exist";
    }

    public Office getOffice(int officeId){
        for( int i = 0; i < officeList.size(); i++){
            if( officeList.get(i).getId() == officeId){
                return officeList.get(i);
            }
        }
        return null;
    }

    public boolean canAccessCampus(String userId, LocalDateTime dateTime) {
        User user = getUser(userId);
        if( user.getTemperatureTestTime().getDayOfMonth() != dateTime.getDayOfMonth()){
            return false;
        }
        if (user == null || user.isValid() == false) {
            return false;
        }
        if (user.getBodyTemperature() < 37.3) {
            if (user.getDistrict() == "SUSTech") {
                return true;
            } else if ((dateTime.getMonth() == user.getDateBackToShenzhen().getMonth()) == true) {
                if (dateTime.getDayOfMonth() - user.getDateBackToShenzhen().getDayOfMonth() >= 14) {
                    return true;
                }
            } else if ((dateTime.getMonth() == user.getDateBackToShenzhen().getMonth()) == false) {
                if (dateTime.getMonth().maxLength() == 30) {
                    if (30 - dateTime.getDayOfMonth() + user.getDateBackToShenzhen().getDayOfMonth() >= 14) {
                        return true;
                    }
                } else if (dateTime.getMonth().maxLength() == 31) {
                    if (31 - dateTime.getDayOfMonth() + user.getDateBackToShenzhen().getDayOfMonth() >= 14) {
                        return true;
                    }
                } else {
                    if (29 - dateTime.getDayOfMonth() + user.getDateBackToShenzhen().getDayOfMonth() >= 14) {
                        return true;
                    }
                }

            }

        }
        return false;
    }

        public boolean canAccessOffice (String userId,int officeId, LocalDateTime dateTime){
            User user = getUser(userId);
            Office office = getOffice(officeId);
            if (user == null || user.isValid() == false || user.getBodyTemperature() == 0) {
                return false;
            }
            if (office == null || office.isValid() == false) {
                return false;
            }
            if (user.getBodyTemperature() < 37.3 && office.getArea() < 2) {
                for (int i = 0; i < groupList.size(); i++) {
                    for (int j = 0; j < groupList.get(i).getUserList().size(); j++) {
                        if (groupList.get(i).getUserList().get(j).equals(user)) {
                            for (int k = 0; k < groupList.get(i).getOfficeList().size(); k++) {
                                if (groupList.get(i).getOfficeList().get(k).equals(office)) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }

    public void addAccessRecord(Log log){
        logList.add(log);
    }

    public boolean accessCampus( String userId, LocalDateTime dateTime){
        User user = getUser(userId);
        if( canAccessCampus(userId, dateTime) == true && user.getTemperatureTestTime().getDayOfMonth() == dateTime.getDayOfMonth()){
            Log log = new Log(userId, user.getBodyTemperature(), dateTime);
            addAccessRecord(log);
            return true;
        }else{
            return false;
        }
    }

    public boolean accessOffice(String userId, int officeId, double temperature, LocalDateTime dateTime){
        User user = getUser(userId);
        Office office = getOffice(officeId);
        if( user.getTemperatureTestTime().getDayOfMonth() != dateTime.getDayOfMonth()){
            return false;
        }
        if( accessOffice(userId, officeId, temperature, dateTime) == true){
            Log log = new Log(userId,officeId,temperature,dateTime);
            addAccessRecord(log);
            return true;
        }
        return false;
    }

    public int accessCampusUserCount(LocalDateTime date){
        int total = 0;
        for( int i = 0; i < logList.size(); i++ ) {
            User user = getUser(logList.get(i).getUserId());
            total += 1;
        }
        return total;
    }

    public ArrayList<User> accessOfficeUsers( int officeId, LocalDateTime date){
        ArrayList<User> a = new ArrayList<User>();
        for( int i = 0; i < logList.size(); i++ ) {
            User user = getUser(logList.get(i).getUserId());
            if( a.contains(user) == false) {
                a.add(user);
            }
        }
        return a;
    }
    public ArrayList<Integer> accessOfficeTiems(String userId, int officeId, LocalDateTime startDate, LocalDateTime endDate){
        ArrayList<Integer> a = new ArrayList<Integer>();
        User user = getUser(userId);
        if(accessOffice(userId, officeId, user.getBodyTemperature(),startDate) == true){
            a.add(startDate.getHour());
            a.add(endDate.getHour());
        }
        return a;
    }

}
