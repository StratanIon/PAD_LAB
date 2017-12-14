package lab2;

import java.io.Serializable;

public class Students implements Serializable {
    private String firstName;
    private String lastName;
    private String grupa;
    private Double bursa;

    public Students(String firstName, String lastName, String grupa, Double bursa) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grupa = grupa;
        this.bursa = bursa;
    }

    public Students() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGrupa() {
        return grupa;
    }

    public void setGrupa(String grupa) {
        this.grupa = grupa;
    }

    public Double getBursa() {
        return bursa;
    }

    public void setBursa(Double bursa) {
        this.bursa = bursa;
    }

    @Override
    public String toString() {
        return "Students{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", grupa='" + grupa + '\'' +
                ", bursa=" + bursa +
                '}';
    }
}
