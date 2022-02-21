package Bibliotheque.Model;

public class Bibliothecaire extends User{

    public Bibliothecaire(long id, String firstName, String lastName, String address){
        super(id,firstName,lastName,address);
    }

    @Override
    public String toString() {
        return "Bibliothecaire{}";
    }
}
