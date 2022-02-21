package Bibliotheque;

import Bibliotheque.Model.Bibliothecaire;
import Bibliotheque.Model.Document;
import Bibliotheque.Model.Lecteur;
import Bibliotheque.Model.User;
import Bibliotheque.Persistence.JDBCBiblio;
import Bibliotheque.Persistence.JDBCBiblioH2;
import Bibliotheque.Service.ServiceBiblio;

public class Main {
    public static void main(String[] args) throws Exception {
        //Créer la base de données


//
//        //Creer des documents
        Document document10 = new Document(7,"titeuf","quelquun","foolio",2019,"magazine",21);
//        Document document11 = new Document(8,"bob","albert","francebd",2019,"CD",14);
//        Document document12 = new Document(9,"toto","Jerome","yee",2019,"DVD",7);
//
//        //Créer 4 Utilisateurs
//
//        //2 Lecteurs
//        User lecteur1 = new Lecteur(6,"Abdou","Diarra","65 Wall Street",0);
//        User lecteur2 = new Lecteur(12,"David","LeBois","64 rue arbre",0);
//        User lecteur7 = new Lecteur(13,"hello","test","4 rue abc",4);
//        User lecteur6 = new Lecteur(14,"lecteur","six","64 rue def",1);
//
//        //2 Bibliothécaires
//        User bibliothecaire1 = new Bibliothecaire(1,"Majorie", "Lavoix","23 rue monchamp");
//        User bibliothecaire2 = new Bibliothecaire(2,"Maxime", "Smith","20 rue arret");
//        User bibliothecaire9 = new Bibliothecaire(9,"toto", "tata","20 rue raptors");
//        User bibliothecaire8 = new Bibliothecaire(8,"abdou", "diarra","20 rue nba");
//
//        //Initialiser la JDBC et la base de donnée
        JDBCBiblioH2 jdbcBiblio = new JDBCBiblioH2();
//        jdbcBiblio.createDatabase();
//
//        //Initialiser service
        ServiceBiblio serviceBiblio = new ServiceBiblio(jdbcBiblio);
//
//
//        //Enregistrer bibliothécaires
//        serviceBiblio.save(bibliothecaire9);
//        serviceBiblio.save(bibliothecaire8);
//
//        //Enregistrer Lecteurs
//        serviceBiblio.save(lecteur7);
//        serviceBiblio.save(lecteur6);
//
//        //Ajouter livre en tant que bibliothecaire
//        serviceBiblio.ajouterDocument(document10);
//        serviceBiblio.ajouterDocument(document11);
//        serviceBiblio.ajouterDocument(document12);

//        Rechercher le nombre de documents empruntés par mois en tant que bibliothecaire

        //Rechercher la somme d’amende produit par mois en tant que bibliothécaire

        //Rechercher des livres grace a l’auteur,éditeur, titre, type , annee de publication et id

        //auteur
        System.out.println(serviceBiblio.getDocument("auteur","Jerome"));

        //titre
        System.out.println(serviceBiblio.getDocument("titre", "titeuf"));

        //editeur
        System.out.println(serviceBiblio.getDocument("editeur", "foolio"));

        //genre
        System.out.println(serviceBiblio.getDocument("genre_de_document","CD"));
        System.out.println(serviceBiblio.getDocument("genre_de_document","DVD"));
        System.out.println(serviceBiblio.getDocument("genre_de_document","magazine"));

        //annee de publication
        System.out.println("----PAR ANNEE DE PUBLICATION-----");
        System.out.println(serviceBiblio.getDocument("annee_publication", 2019));

        //id
        System.out.println("--PAR ID--");
        System.out.println(serviceBiblio.getDocument("id",7));
    }
}
