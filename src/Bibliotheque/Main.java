package Bibliotheque;

import Bibliotheque.Model.Bibliothecaire;
import Bibliotheque.Model.Lecteur;
import Bibliotheque.Model.User;
import Bibliotheque.Persistence.JDBCBiblio;
import Bibliotheque.Service.ServiceBiblio;

public class Main {
    public static void main(String[] args) {
        //Créer la base de données


        //Créer 4 Utilisateurs

        //2 Lecteurs
        User lecteur1 = new Lecteur(1,"Abdou","Diarra","65 Wall Street",0);
        User lecteur2 = new Lecteur(2,"David","LeBois","64 rue arbre",0);

        //2 Bibliothécaires
        User bibliothecaire1 = new Bibliothecaire(1,"Majorie", "Lavoix","23 rue monchamp");
        User bibliothecaire2 = new Bibliothecaire(2,"Maxime", "Smith","20 rue arret");

        //Initialiser la JDBC et la base de donnée
        JDBCBiblio jdbcBiblio = new JDBCBiblio();
        jdbcBiblio.createDatabase();

        //Initialiser service
        ServiceBiblio serviceBiblio = new ServiceBiblio(jdbcBiblio);


        //Enregistrer bibliothécaires
        serviceBiblio.save(bibliothecaire1);
        serviceBiblio.save(bibliothecaire2);

        //Enregistrer Lecteurs
        serviceBiblio.save(lecteur1);
        serviceBiblio.save(lecteur2);

        //Ajouter livre en tant que bibliothecaire
//        serviceBiblio.ajouterLivre(bibliothecaire1, document1);
//        serviceBiblio.ajouterLivre(bibliothecaire2, document2);
//        serviceBiblio.ajouterLivre(bibliothecaire1, document3);
//        serviceBiblio.ajouterLivre(bibliothecaire2, document4);
//        serviceBiblio.ajouterLivre(bibliothecaire1, document5);

        //Retirer livre en tant que bibliothecaire
//        serviceBiblio.retirerLivre(bibliothecaire1, "titre");

        //Rechercher le nombre de documents empruntés par mois en tant que bibliothecaire

        //Rechercher la somme d’amende produit par mois en tant que bibliothécaire

        //Rechercher des livres grace a l’auteur,éditeur ou nom de livre en tant que bibliothécaire




    }
}
