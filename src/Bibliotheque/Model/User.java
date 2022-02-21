package Bibliotheque.Model;

public class User {

    private final long id;
    private final String firstName;
    private double solde = 0;
    private final String lastName;
    private final String address;

    public User(long id, String firstName, String lastName, String address){

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public User(long id, String firstName, String lastName , String address, double solde) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.solde = solde;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public double getSolde() {
        return solde;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", solde=" + solde +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
