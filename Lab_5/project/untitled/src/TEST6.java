import java.util.Random;
public class TEST6 {
    public static void main(String[] args) {
        Random generator = new Random();
        int[] frequency = new int[7];
        // roll 6000 times; use dice value as frequency index
        for(int roll = 1; roll <= 6000; roll++) {
            frequency[1 + generator.nextInt(6)]++;
        } System.out.printf("%s%10s\n", "Face", "Frequency");
        // output the frequency of each face
        for(int face = 1; face < frequency.length; face++) {
            System.out.printf("%4d%10d\n", face, frequency[face]);
        }
    }
}
