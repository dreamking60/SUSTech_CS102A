public class GradeBook {
    private String courseName;
    public GradeBook(String name){
        courseName = name;
    }
    public String get(){
        return courseName;
    }
    public void set(String name){
        courseName = name;
    }
    public static void main(String[] args) {
        GradeBook myGradeBook = new GradeBook("haha");
        System.out.println(myGradeBook);
    }
}
