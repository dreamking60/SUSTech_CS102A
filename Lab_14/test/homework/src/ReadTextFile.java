import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class ReadTextFile {
        public static void main(String[] args) {
            String fileName = "sample.txt";
            String line;
            BufferedReader in = null;
            try {
                in = new BufferedReader(new FileReader(fileName));
                while ((line = in.readLine()) != null) System.out.println(line);
            }
            catch (FileNotFoundException ex)
            {
                System.out.println("There is no this file!");
            }
            catch( IOException ex){
                System.out.println("Read file exception!");
            }
            finally {
                System.out.println("close the file");
                if( in!= null) {
                    try{
                        in.close();
                    }catch(IOException ex){
                        System.out.println("file close IOException");
                    }
                }
            }

        }
    }
