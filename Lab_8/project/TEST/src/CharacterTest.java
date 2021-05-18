import java.util.Scanner;
public class CharacterTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char c = in.next().charAt(0);
        String a = "123";
        System.out.printf("is letter: %b\n", Character.isLetter(c));
        //确定指定字符是否为字母。
        System.out.printf("is Digit %b\n", Character.isDigit(c));
        //确定指定字符是否为数字。
        System.out.printf("is identifier part %b\n", Character.isJavaIdentifierPart(c));
        //确定指定字符是否可以是 Java 标识符中首字符以外的部分。
        System.out.printf("is identifier start %b\n", Character.isJavaIdentifierStart(c));
        //确定是否允许将指定字符作为 Java 标识符中的首字符.
        System.out.printf("is lower case %b \n", Character.isLowerCase(c));
        System.out.printf("is upper case %b \n", Character.isUpperCase(c));
        System.out.printf("to upper case %c \n", Character.toUpperCase(c));
        System.out.printf("to Lower case %c \n", Character.toLowerCase(c));
        System.out.printf("%d", Integer.parseInt(a)); //转化为整形

    }
}
