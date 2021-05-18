import java.util.InputMismatchException;
import java.util.Scanner;

public class CommonExceptionDemo {
    public static void main(String[] args) {
        System.out.println("Exception:");
        System.out.println("    ARITHMETIC(0)");
        System.out.println("    INDEXOUTOFBOUNDS(1)");
        System.out.println("    NEGATIVEARRAYSIZE(2)");
        System.out.println("    NULLPOINTER(3)");
        System.out.println("    NUMBERFORMAT(4)");
        System.out.println("    CLASSCAST(5)");

        System.out.print("Please INPUT an integer to select the TYPE OF EXCEPTION(0~5):");
        Scanner in = new Scanner(System.in);

        ExceptionEnum exceptionIndex = ExceptionEnum.getExceptionByOrdinal(in.nextInt());
        switch(exceptionIndex)
        {
            case ARITHMETIC:
            {
                System.out.println(1/0);
            }
            break;

            case INDEXOUTOFBOUNDS:
            {
                int[] anArray = new int[3]; System.out.println(anArray[3]);
            }

            break;
            case NEGATIVEARRAYSIZE:
            {
                int[] anArray = new int[-1];
            }
            break;
            case NULLPOINTER:
            {
                String[] strs = new String[3]; System.out.println(strs[0].length());
            }

            break;
            case NUMBERFORMAT:
            {
                Integer.parseInt("abc");
            }
            break;
            case CLASSCAST:
            {
                Object o = new Object(); Integer i = (Integer)o;
            }

            break;
        }

    }
}

enum ExceptionEnum {
    ARITHMETIC,
    INDEXOUTOFBOUNDS,
    NEGATIVEARRAYSIZE,
    NULLPOINTER,
    NUMBERFORMAT,
    CLASSCAST;

    public static ExceptionEnum getExceptionByOrdinal(int ord) throws IllegalArgumentException {
        try{
            int a = ord;
        }catch( InputMismatchException ex){
            System.out.println("java.util.InputMismatchException");
            return null;
        }
        if( ord == 0) {System.out.println("Here is End"); return ARITHMETIC;}
        if( ord == 1) {System.out.println("Here is End"); return INDEXOUTOFBOUNDS;}
        if( ord == 2) {System.out.println("Here is End"); return NEGATIVEARRAYSIZE;}
        if( ord == 3) {System.out.println("Here is End"); return NULLPOINTER;}
        if( ord == 4) {System.out.println("Here is End"); return NUMBERFORMAT;}
        if( ord == 5) {System.out.println("Here is End"); return CLASSCAST;}
        else{
            System.out.println("java.util.IllegalArgumentException");
            System.out.println("Here is End");
            return null;
        }


    }


}

