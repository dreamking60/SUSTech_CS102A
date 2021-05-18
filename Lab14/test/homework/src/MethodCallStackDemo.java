public class MethodCallStackDemo {
    public static void main(String[] args) {
        System.out.println("Enter main()");
        methodA();
        System.out.println("Exit main()");
    }

    public static void methodA() {
        System.out.println("Enter methodA()");
        try {
            methodB();
        } catch (ArithmeticException ex) {
            System.out.println(ex.toString());
        }

        System.out.println("Exit methodA()");
    }

    public static void methodB() throws ArithmeticException {
        System.out.println("Enter methodB()");
        methodC();
        System.out.println("Exit methodB()");
    }

    public static void methodC() throws ArithmeticException {
        System.out.println("Enter methodC()");
        methodD();
        System.out.println("Exit methodC()");
    }

    public static void methodD() throws ArithmeticException {
        System.out.println("Enter methodD()");
        System.out.println(1 / 0);
        System.out.println("Exit methodD()");

    }

}