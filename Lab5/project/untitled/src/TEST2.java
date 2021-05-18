

public class TEST2 {
    public static void main(String[] args) {
        int[] array; // declare an array named array, array is null here
        array = new int[10]; // create the array object
        System.out.printf("%s%8s\n", "Index", "Value");
        // output each array element's value
        for(int counter = 0; counter < array.length; counter++) {
            System.out.printf("%5d%8d\n", counter, array[counter]);
        }

    }
}
