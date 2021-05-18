import java.util.Arrays;
import java.util.Scanner;

public class Ques8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int lucky = in.nextInt();
        int count=0;
        String str = in.next();
        int[] arr=new int[str.length()];
        int[] arr1=new int[str.length()];
        for(int i=0;i<str.length();i++){
            arr[i]=str.charAt(i)-'0';
            if(arr[i]==lucky){
                count++;
            }
        }
        Arrays.sort(arr);
        if(count==0){
            int c=arr.length-1;
            for (int i = 0; i <arr.length ; i++) {
                arr1[c]=arr[i];
                c--;
            }
        }
        if(count>0){
            for(int i=0;i < count;i++){
                arr1[i]=lucky;
            }
            int j=0;
            for (int i = arr1.length-1; i >=count ; i--) {
                if(arr[j]==lucky){
                    j++;
					i++;
                    continue;
                }

                arr1[i]=arr[j];
                j++;
            }
        }
        for (int i = 0; i <arr.length ; i++) {
            System.out.print(arr1[i]);
        }
    }
}