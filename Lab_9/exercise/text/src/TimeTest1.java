public class TimeTest1 {
    public static void main(String[] args) {
        Time time = new Time();
        System.out.print("The initial time is: ");
        System.out.println(time.toUniversalString());
        System.out.print("The standard time is: ");
        System.out.println(time.toString());
    }
}
