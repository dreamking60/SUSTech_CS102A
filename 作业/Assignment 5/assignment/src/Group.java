import java.util.ArrayList;

public class Group {
    private int id;
    private String piId;
    public ArrayList<User> userList = new ArrayList<User>();
    public ArrayList<Office> officeList = new ArrayList<Office>();
    private boolean isValid = true;
    private static int count = 0;

    public String addUser( User user) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).equals(user)) {
                return "user already exists";
            }
        }
        userList.add(user);
        return "addUser succeed";
    }

    public String deleteUser(String userId){
        for( int i = 0; i < userList.size(); i++ ){
            if( userList.get(i).getId().equals(userId) ){
                userList.remove(userList.get(i));
                return "deleteUser succeed";
            }
        }
        return "user not exists";
    }

    public String addOffice(Office office){
        for( int i = 0; i < officeList.size(); i++ ){
            if(officeList.get(i).equals(office)){
                return "office already exists";
            }
        }
        officeList.add(office);
        return "addOffice succeed";
    }

    public String deleteOffice( int officeId ){
        for( int i = 0; i < officeList.size(); i++ ){
            if( officeList.get(i).getId() == officeId){
                officeList.remove(officeList.get(i));
                return "deleteOffice succeed";
            }
        }
        return "office not exists";
    }

    public Group(){
        id = count + 1;
        count++;
    }

    public Group(String piId){
        this.piId = piId;
        id = count + 1;
        count++;
        this.isValid = true;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", piId='" + piId + '\'' +
                ", userList=" + userList +
                ", officeList=" + officeList +
                ", isValid=" + isValid +
                ", count=" + count +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPiId() {
        return piId;
    }

    public void setPiId(String piId) {
        this.piId = piId;
    }

    public ArrayList<User> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<User> userList) {
        this.userList = userList;
    }

    public ArrayList<Office> getOfficeList() {
        return officeList;
    }

    public void setOfficeList(ArrayList<Office> officeList) {
        this.officeList = officeList;
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
        Group.count = count;
    }


}
