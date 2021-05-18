public class Test1 {
    public static void main(String[] args) {
        String s1 = new String("Hello world");
        String s2 = new String();
        String s3 = new String(s1);
        char[] charArray = {'h','e','l','l','o'};
        System.out.println(charArray);
        String s4 = new String(charArray);
        String s5 = new String(charArray, 2, 2); //OFFSET MEANS 从第几个开始； count 表示往后几位
        System.out.printf("%s %s %s %s %s", s1, s2, s3, s4, s5);
    }
}
