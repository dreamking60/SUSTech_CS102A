import java.util.Scanner;
public class STUPIDCODE {
        public static void main(String[] args){
            Scanner input=new Scanner(System.in);
            int m=input.nextInt();
            int n=input.nextInt();
            int l=0;
            int zs=0;
            int ys=0;
            int zx=0;
            int yx=0;
            int r1=0;
            int rn=0;
            int c1=0;
            int cn=0;
            char[][] a=new char[m][n];
            for (int i=0;i<m;i++){
                int o=0;
                String s=input.next();
                for (int k=0;k<n;k++){
                    a[i][k] = s.charAt(o);
                    o++;
                }
            }
            char[][] b=new char[m][n];
            for (int i=1;i<m-1;i++){
                for (int k=1;k<n-1;k++){
                    if (a[i][k]=='*'){
                        b[i][k]='F';
                    }
                    else if (a[i][k]=='.'){
                        if (a[i-1][k-1]=='.'&&a[i-1][k]=='.'&&a[i-1][k+1]=='.'&&a[i][k-1]=='.'&&a[i][k+1]=='.'&&a[i+1][k-1]=='.'&&a[i+1][k]=='.'&&a[i+1][k+1]=='.'){
                            b[i][k]='-';
                        }
                        else {
                            for (int i2 = i - 1; i2 < i + 2; i2++) {
                                for (int k2 = k - 1; k2 < k + 2; k2++) {
                                    if (a[i2][k2] == '*') {
                                        l++;
                                    }
                                }
                            }
                            b[i][k] = (char) l;
                        }
                    }
                }
            }
            if (a[0][0]=='*'){
                b[0][0]='F';
            }
            else if (a[0][0]=='.'){
                if (a[0][1]=='.'&&a[1][0]=='.'&&a[1][1]=='.'){
                    b[0][0]='-';
                }
                else {
                    for (int i = 0; i < 2; i++) {
                        for (int k = 0; k < 2; k++) {
                            if (a[i][k] == '*') {
                                zs++;
                            }
                        }
                    }
                    b[0][0] = (char) zs;
                }
            }
            if (a[0][n-1]=='*'){
                b[0][n-1]='F';
            }
            else if (a[0][n-1]=='.'){
                if (a[0][n-2]=='.'&&a[1][n-2]=='.'&&a[1][n-1]=='.'){
                    b[0][n-1]='-';
                }
                else {
                    for (int i = 0; i < 2; i++) {
                        for (int k = n-2; k < n; k++) {
                            if (a[i][k] == '*') {
                                ys++;
                            }
                        }
                    }
                    b[0][n-1] = (char) ys;
                }
            }
            if (a[m-1][0]=='*'){
                b[m-1][0]='F';
            }
            else if (a[m-1][0]=='.'){
                if (a[m-2][0]=='.'&&a[m-2][1]=='.'&&a[m-1][1]=='.'){
                    b[m-1][0]='-';
                }
                else {
                    for (int i = m-2; i < m; i++) {
                        for (int k = 0; k < 2; k++) {
                            if (a[i][k] == '*') {
                                zx++;
                            }
                        }
                    }
                    b[m-1][0] = (char) zx;
                }
            }
            if (a[m-1][n-1]=='*'){
                b[m-1][n-1]='F';
            }
            else if (a[m-1][n-1]=='.'){
                if (a[m-2][n-2]=='.'&&a[m-2][n-1]=='.'&&a[m-1][n-2]=='.'){
                    b[m-1][n-1]='-';
                }
                else {
                    for (int i = m-2; i < m; i++) {
                        for (int k = n-2; k < n; k++) {
                            if (a[i][k] == '*') {
                                yx++;
                            }
                        }
                    }
                    b[m-1][n-1] = (char) yx;
                }
            }
            for (int i=1;i<n;i++){
                if (a[0][i]=='*'){
                    b[0][i]='F';
                }
                else if (a[0][i]=='.'){
                    if (a[0][i-1]=='.'&&a[0][i+1]=='.'&&a[1][i-1]=='.'&&a[1][i]=='.'&&a[1][i+1]=='.'){
                        b[0][i]='-';
                    }
                    else {
                        for (int k=0;k<2;k++){
                            for (int j=i-1;j<i+2;j++){
                                if (a[k][j]=='*'){
                                    r1++;
                                }
                            }
                        }
                        b[0][i]= (char) r1;
                    }
                }
            }
            for (int i=1;i<n;i++){
                if (a[m-1][i]=='*'){
                    b[m-1][i]='F';
                }
                else if (a[m-1][i]=='.'){
                    if (a[m-1][i-1]=='.'&&a[m-1][i+1]=='.'&&a[m-2][i-1]=='.'&&a[m-2][i]=='.'&&a[m-2][i+1]=='.'){
                        b[m-1][i]='-';
                    }
                    else {
                        for (int k=m-2;k<m;k++){
                            for (int j=i-1;j<i+2;j++){
                                if (a[k][j]=='*'){
                                    rn++;
                                }
                            }
                        }
                        b[m-1][i]= (char) rn;
                    }
                }
            }
            for (int i=1;i<m;i++){
                if (a[i][0]=='*'){
                    b[i][0]='F';
                }
                else if (a[i][0]=='.'){
                    if (a[i-1][0]=='.'&&a[i-1][1]=='.'&&a[i][1]=='.'&&a[i+1][0]=='.'&&a[i+1][1]=='.'){
                        b[i][0]='-';
                    }
                    else {
                        for (int k=i-1;k<i+2;k++){
                            for (int j=0;j<2;j++){
                                if (a[k][j]=='*'){
                                    c1++;
                                }
                            }
                        }
                        b[i][0]= (char) c1;
                    }
                }
            }
            for (int i=1;i<m;i++){
                if (a[i][n-1]=='*'){
                    b[i][n-1]='F';
                }
                else if (a[i][n-1]=='.'){
                    if (a[i-1][n-2]=='.'&&a[i-1][n-1]=='.'&&a[i][n-1]=='.'&&a[i+1][n-2]=='.'&&a[i+1][n-1]=='.'){
                        b[i][n-1]='-';
                    }
                    else {
                        for (int k=i-1;k<i+2;k++){
                            for (int j=n-2;j<n;j++){
                                if (a[k][j]=='*'){
                                    cn++;
                                }
                            }
                        }
                        b[i][n-1]= (char) cn;
                    }
                }
            }
            for (int i=0;i<m;i++){
                for (int k=0;k<n;k++){
                    System.out.print(b[i][k]+"");
                }
                System.out.println();
            }
        }
}

