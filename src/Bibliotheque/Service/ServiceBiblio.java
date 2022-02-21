package Bibliotheque.Service;

import Bibliotheque.Model.Document;
import Bibliotheque.Model.User;
import Bibliotheque.Persistence.JDBCBiblio;

import java.util.List;

public class ServiceBiblio {

    JDBCBiblio jdbcBiblio;

    public ServiceBiblio(JDBCBiblio jdbcBiblio) {
        this.jdbcBiblio = jdbcBiblio;
    }

    public void save(User bibliothecaire1) {
        jdbcBiblio.save(bibliothecaire1);
    }

    public void ajouterDocument(Document document) throws Exception {
        jdbcBiblio.save(document);

    }

    public List<Document> getDocument(String type, String valeur) {
        return jdbcBiblio.getDocument(type,valeur);
    }

    public List<Document> getDocument(String type, int valeur) {
        return jdbcBiblio.getDocument(type,valeur);
    }


}
