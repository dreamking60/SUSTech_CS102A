public class Test3 {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = "hello";
        String s3 = "World";
        System.out.println(s1.compareTo(s2)); //逐项比较字符的编码,完全一致为0，一个多一个少但共同部分完全一致输出数位差
        System.out.println(s1.equals(s2)); //比较两个字符是否一致
        if(s1.startsWith("He")){
            System.out.println("true");
        }
        if(s2.endsWith("lo")){
            System.out.println("true");
        }
        if(s1.startsWith("ll", 2)){
            System.out.println("true");
        }
        System.out.println(s1.indexOf("e"));
        System.out.println(s1.indexOf("a"));
        System.out.println(s2.indexOf("l",3));
        System.out.println(s2.lastIndexOf("l"));
        System.out.println(s1.lastIndexOf("a"));
        System.out.println(s2.lastIndexOf("l",2));
        System.out.println(s1.substring(2));
        System.out.println(s2.substring(1,5));
        System.out.println(s1.concat(" "+s3));
        System.out.println(s1.replace("l","L"));
        System.out.println(s3.replace("W","w"));
        System.out.println(s1.toUpperCase());
        System.out.println(s1.toLowerCase());

        String s4 = " Hello ";
        System.out.println(s4.trim());
        char[] Array = s1.toCharArray();
        System.out.println(Array);
    }
}
