public class SalariedEmployee extends Employee {
    public SalariedEmployee(String first, String last, String ssn) {
        super(first, last, ssn);
    }

    @Override
    public double earnings() {
        return 0;
    }
}
