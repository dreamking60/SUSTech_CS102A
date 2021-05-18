package companySalary;

public class BasePlusCommissionEmployee extends CommissionEmployee {
    public double getBaseSalary() {
        return baseSalary;
    }

    private double baseSalary;

    public BasePlusCommissionEmployee(String first, String last, String ssn,
                                      double sales, double rate, double salary) {
        super(first, last, ssn, sales, rate);

    }

    public void setBaseSalary(double salary) {
        baseSalary = (salary < 0.0) ? 0.0 : salary;
    }

    public double earnings() {
        return baseSalary + (getGrossSales() * getCommissionRate()); //or you can use protect to design in superclass;
    }

    public String toString() {
        return String.format("%s %s\n%s: %.2f",
                "base‐salaried", super.toString(),
                "base salary", getBaseSalary());
    }
}

