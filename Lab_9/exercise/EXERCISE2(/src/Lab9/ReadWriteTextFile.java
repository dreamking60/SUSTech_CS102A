package Lab9;
import java.io.*;
public class ReadWriteTextFile {
    public static void main(String[] args) {
        try{
            BufferedReader in = new BufferedReader(new FileReader("EXERCISE2(/src/TextIn.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("EXERCISE2(/src/TextOut.txt"));
            int temp;
            while( (temp = in.read()) != -1){
                if( temp >= 'a' && temp <= 'z'){
                    writer.write(temp-'a'+'A');
                }else{
                    writer.write(temp);
                }
            }
            in.close();
            writer.close();
        }catch(IOException e){
            System.out.println("There is no this file!");
        }
    }
}

