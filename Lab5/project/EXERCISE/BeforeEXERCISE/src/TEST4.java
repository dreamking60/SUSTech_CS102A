public class TEST4 {;
    public static void main(String[] args) {
        int[][] array0 = new int[2][4];
        int[][] array1 = {{1, 2, 3, 4}, {0, 1, 2, 3}};
        int[][] array2 = new int[2][];
        array2[0] = new int[3];
        array2[1] = new int[4];

        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array1[0].length; j++) {
                System.out.print(array1[i][j]);
            }
            System.out.println("");
        }
        System.out.println("---------------------");
        for(int i = 0; i < array2.length; i++){
            for(int j = 0; j < array2[i].length; j++){
                array2[i][j] = 1;
            }
        }
        for(int i = 0; i<array2.length; i++){
            for(int j = 0; j<array2[i].length; j++){
                System.out.print(array2[i][j] + "\t");
            }
            System.out.println();
        }
    }
}

