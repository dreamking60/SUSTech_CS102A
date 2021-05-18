public class deTest {
    public static void main(String[] args) {
        int[][] a = new int[5][5];
        a[0][0] = 1;
        a[0][1] = 2;
        a[0][2] = 3;
        a[0][3] = 4;
        a[0][4] = 1;
        a[1][0] = 0;
        a[1][1] = -1;
        a[1][2] = 2;
        a[1][3] = 4;
        a[1][4] = 2;
        a[2][0] = 0;
        a[2][1] = 0;
        a[2][2] = 4;
        a[2][3] = 0;
        a[2][4] = 0;
        a[3][0] = -3;
        a[3][1] = -6;
        a[3][2] = -9;
        a[3][3] = -12;
        a[3][4] = 4;
        a[4][0] = 0;
        a[4][1] = 0;
        a[4][2] = 1;
        a[4][3] = 1;
        a[4][4] = 1;
        determinant b = new determinant();
        System.out.println(b.determinant(a));
    }

}
