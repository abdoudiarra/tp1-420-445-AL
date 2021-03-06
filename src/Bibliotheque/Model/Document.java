package Bibliotheque.Model;

public class Document {
    private final long id;
    private final String titre;
    private final String auteur;
    private String editeur;
    private final int annee_de_publication;
    private final String genre_de_document;
    private final int jours_de_pret;


    public Document(long id, String titre, String auteur,String editeur, int annee_de_publication, String genre_de_document, int jours_de_pret){
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
        this.editeur = editeur;
        this.annee_de_publication = annee_de_publication;
        this.genre_de_document = genre_de_document;
        this.jours_de_pret = jours_de_pret;
    }

    public long getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public int getAnnee_de_publication() {
        return annee_de_publication;
    }

    public String getGenre_de_document() {
        return genre_de_document;
    }

    public int getJours_de_pret() {
        return jours_de_pret;
    }

    public String getEditeur() {
        return editeur;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", auteur='" + auteur + '\'' +
                ", editeur='" + editeur + '\'' +
                ", annee_de_publication=" + annee_de_publication +
                ", genre_de_document='" + genre_de_document + '\'' +
                ", jours_de_pret=" + jours_de_pret +
                '}';
    }
}

