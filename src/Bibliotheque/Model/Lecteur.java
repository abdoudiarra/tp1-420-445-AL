package Bibliotheque.Model;

public class Lecteur extends User{

    public Lecteur(long id, String firstName, String lastName, String address,double solde){
        super(id,firstName,lastName,address,solde);
    }

    @Override
    public String toString() {
        return "Lecteur{}";
    }
}
