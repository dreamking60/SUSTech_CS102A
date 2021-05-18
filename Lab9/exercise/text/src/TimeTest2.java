public class TimeTest2 {
    public static void main(String[] args) {
        Time time1 = new Time();
        time1.setTime(13, 27, 6);
        System.out.print("The initial time is: ");
        System.out.println(time1.toUniversalString());
        System.out.print("The standard time is: ");
        System.out.println(time1.toString());
    }
}
