package Bibliotheque.Service;

import Bibliotheque.Model.Bibliothecaire;
import Bibliotheque.Model.Document;
import Bibliotheque.Model.User;
import Bibliotheque.Persistence.JDBCBiblio;

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
}
