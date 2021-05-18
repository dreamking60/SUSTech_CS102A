public abstract class Employee {
    private String firstName;
    private String lastName;
    private String socialSecurityNumber;

    //three-argument constructor
    public Employee( String first, String last, String ssn){
        firstName = first;
        lastName = last;
        socialSecurityNumber = ssn;
    }// end three-argument Employee Constructor

    //set first name
    public void setFirstName(String first){
        firstName = first; // should validate
    } // end method setFirstName

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    @Override
    public String toString() {
        return String.format( "%s %s \nsocial security number: %s",
                getFirstName(), getLastName(), getSocialSecurityNumber());
    }

    public abstract  double earnings();
}
