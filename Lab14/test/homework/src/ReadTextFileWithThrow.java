import java.io.BufferedReader; import java.io.FileReader; import java.io.IOException;

class ReadTextFileWithThrow {
    public static void main(String[] args) throws IOException {
        String fileName = "sample.txt";
        String line;
// Create a BufferedReader and Attach a file
        BufferedReader in = new BufferedReader(new FileReader(fileName));
// while not end of file
        while ((line = in.readLine()) != null) {
            System.out.println(line);
        }
// close the file
        in.close();

    }
}