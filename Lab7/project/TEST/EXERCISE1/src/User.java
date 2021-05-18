import java.util.Scanner;
public class User {
    private String account;
    private String password;
    private double money;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
        if( this.money < 0 ){
            this.money = 0;
        }
    }

    public void setUser(String account){
        this.account = account;
    }

    public String getUser(){
        return account;
    }

    public void introduce(){
        System.out.printf("%s's account has a balance of %.2f dollar\n", account, money);
    }

    public void expense(double value,Scanner in){
        if( value >= money ){
            System.out.printf("Plan to expense %.2f dollar but no sufficient funds\n", value);
        }else if( value < money && value >= 0 ){
            System.out.printf("Plan to expense %.2f dollar\n", value);
            System.out.println("Please enter your password:");
            String input = in.nextLine();
            if( input.equals(password)){
                money -= value;
                System.out.printf("Expense %.2f dollar and balance %.2f dollar\n", value, money);
            }
        }else{
            System.out.println("Please enter the correct expense.");
        }
    }

    public void income(double value){
        money += value;
        System.out.printf("Got %.2f as income, balance is %.2f dollar\n", value, money);
    }
}
