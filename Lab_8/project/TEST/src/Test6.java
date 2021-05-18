public class Test6 {
    public static void main(String[] args) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder(10);
        StringBuilder s3 = new StringBuilder("Hello World");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        s3.append("\n"+123);
        System.out.println(s3);
        System.out.printf("%s",s3.toString());
    }
}
