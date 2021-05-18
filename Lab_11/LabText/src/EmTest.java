public class EmTest {
    public static void main(String[] args) {
        CommissionEmployee employee1 = new BasePlusCommissionEmployee(
                "Bob","Lewis","333-33-3333",5000,.04,300);
        System.out.printf("%s %s:\n\n%s\n",
                "Call BasePlusCommissionEmployee's toString with superclass",
                "reference to subclass object", employee1.toString());
    }
}
