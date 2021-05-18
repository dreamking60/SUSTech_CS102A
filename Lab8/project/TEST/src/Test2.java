public class Test2 {
    public static void main(String[] args) {
        String s1 = "Hello World";
        char[] array = new char[5];
        s1.getChars(1,5,array,1); //dstBegin 似乎表示从哪一位开始
        System.out.println(array);
        for(char c:array){
            System.out.println(c);
        }
    }
}
