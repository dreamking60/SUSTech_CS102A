package Lab9;
import java.io.*;
public class GrammarCorrection {
    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new FileReader("EXERCISE3/src/TextIn.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("EXERCISE3/src/TextOut.txt"));
            String str;
            while( (str = in.readLine()) != null ) {
                char[] letter = str.toCharArray();
                for (int i = 0; i < str.length(); i++) {
                    if (i == 0) {
                        letter[0] = (char) (letter[0] - 'a' + 'A');
                    } else {
                        if (letter[i - 1] == '.') {
                            for (int j = i - 2; j >= 0; j--) {
                                if (letter[j] == ' ' && Character.isUpperCase(letter[j + 1]) == false) {
                                    letter[i] = (char) (letter[i] - 'a' + 'A');
                                    break;
                                }
                            }
                        }
                    }
                    writer.write(letter[i]);
                }
            }

            in.close();
            writer.close();
        } catch (IOException e) {
            System.out.println("There is no this file!");
        }
    }
}
