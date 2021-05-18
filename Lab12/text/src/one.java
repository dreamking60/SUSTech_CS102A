import javax.swing.*;

public class one {
    public static void main(String[] args) {
        String str1 = JOptionPane.showInputDialog("Enter 1st integer");
        String str2 = JOptionPane.showInputDialog("Enter 2nd integer");
        int num1 = Integer.parseInt(str1);
        int num2 = Integer.parseInt(str2);
        int sum = num1 + num2;
        JOptionPane.showMessageDialog(null, num1+"+"+num2+"="+sum);
    }
}
