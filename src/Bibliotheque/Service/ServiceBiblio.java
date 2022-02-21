package Bibliotheque.Service;

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
}
