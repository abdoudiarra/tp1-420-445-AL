package Bibliotheque.Persistence;

import Bibliotheque.Model.Bibliothecaire;
import Bibliotheque.Model.Document;
import Bibliotheque.Model.Lecteur;
import Bibliotheque.Model.User;
import org.h2.jdbc.JdbcSQLSyntaxErrorException;

import java.sql.*;

public class JDBCBiblio {
    // JDBC driver name and database URL
    int currentYear = 2022;
    final String JDBC_DRIVER = "org.h2.Driver";
    final String DB_URL = "jdbc:h2:~/tp1";

    String QUERY = "SELECT id, first, last, age FROM Registration";

    //  Database credentials
    final String USER = "sa";
    final String PASS = "";

    Connection conn = null;
    Statement stmt = null;


    {
        // STEP 1: Register JDBC driver
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public  void createDatabase() {
        try {
            //STEP 2: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 3: Execute a query
            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();
            String sql1 =  "CREATE TABLE IF NOT EXISTS DOCUMENTS " +
                    "(id INTEGER not NULL PRIMARY KEY, " +
                    "titre VARCHAR(255) NOT NULL, " +
                    "auteur VARCHAR(255) NOT NULL, " +
                    "editeur VARCHAR(255) NOT NULL, " +
                    "annee_publication INTEGER NOT NULL CHECK (annee_publication < " + currentYear +")," +
                    "genre_de_document VARCHAR(255) NOT NULL,"+
                    "jours_de_pret INTEGER not null)";
            stmt.executeUpdate(sql1);

            String sql2 =  "CREATE TABLE IF NOT EXISTS UTILISATEURS " +
                    "(id INTEGER not NULL PRIMARY KEY, " +
                    "firstName VARCHAR(255), " +
                    "lastName VARCHAR(255), " +
                    "address VARCHAR(255), " +
                    "solde INTEGER NULL)";
            stmt.executeUpdate(sql2);





            System.out.println("Created table in given database...");

            // STEP 4: Clean-up environment
            stmt.close();
            conn.close();
        } catch(JdbcSQLSyntaxErrorException e) {
            // Database already exists
            handleException(e);
        } catch(SQLException se) {
            //Handle errors for JDBC
            handleException(se);
        } catch(Exception e) {
            //Handle errors for Class.forName
            handleException(e);
        } finally {
            //finally block used to close resources
            try{
                if(stmt!=null) stmt.close();
            } catch(SQLException se2) {
            } // nothing we can do
            try {
                if(conn!=null) conn.close();
            } catch(SQLException se){
                handleException(se);
            } //end finally try
        } //end try
        System.out.println("Goodbye!");
    }

    private  void handleException(Exception exception) {
        if (exception instanceof SQLException) {
            SQLException sqlException = (SQLException) exception;
            System.out.println("Error Code: " + sqlException.getErrorCode());
            System.out.println("SQL State: " + sqlException.getSQLState());
        }
        System.out.println("SQLException message: " + exception.getMessage());
        System.out.println("Stacktrace: ");
        exception.printStackTrace();
    }

    public  void save(Document document) throws Exception {

        checkLoanDays(document);

        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
        ) {
            // Execute a query

            System.out.println("Inserting records into the table...");
            String sql = "INSERT INTO DOCUMENTS VALUES"+  "("+ document.getId() + ","+"'"+ document.getTitre()+"'"+"," + "'"+document.getAuteur()+"'"+","+"'"+document.getEditeur()+"'"+
                    "," + "'"+document.getAnnee_de_publication()+"'"+"," + "'"+document.getGenre_de_document()+"'"+"," + "'"+document.getJours_de_pret()+"'"+");";
            stmt.executeUpdate(sql);
            System.out.println("Inserted records into the table...");
        } catch (SQLException e) {
            handleException(e);
        }
    }

    private void checkLoanDays(Document document) throws Exception {
        if(document.getGenre_de_document().equalsIgnoreCase("roman") ||
                document.getGenre_de_document().equalsIgnoreCase("manuel scolaire") ||
                document.getGenre_de_document().equalsIgnoreCase("etude") ||
                document.getGenre_de_document().equalsIgnoreCase("magazine") && document.getJours_de_pret() != 21){
            throw new Exception("Un livre peut seulement se faire prêter pour 3 semaines (21 jours) pas plus ni moins");
        }

        if(document.getGenre_de_document().equalsIgnoreCase("CD") && document.getJours_de_pret() != 14 ){
            throw new Exception("Un CD peut seulement se faire prêter pour 2 semaines (14 jours) pas plus ni moins");
        }

        if(document.getGenre_de_document().equalsIgnoreCase("DVD") && document.getJours_de_pret() != 7){
            throw new Exception("Un DVD peut seulement se faire prêter pour 1 semaines (7 jours) pas plus ni moins");
        }
    }

    public  void save(User user) {

        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
        ) {
            // Execute a query

            System.out.println("Inserting records into the table...");
            String sql = "INSERT INTO UTILISATEURS VALUES"+  "("+ user.getId() + ","+"'"+ user.getFirstName()+"'"+"," + "'"+user.getLastName()+"'"+","+"'"+user.getAddress()+"'"+","+user.getSolde()+");";
            stmt.executeUpdate(sql);
            System.out.println("Inserted records into the table...");
        } catch (SQLException e) {
            handleException(e);
        }
    }


    public User getUser(long passengerId) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

             // Select all records having ID equal or greater than 101

             PreparedStatement ps = conn.prepareStatement("SELECT id, firstName, lastName, address, solde FROM Avion where id = ?");){
             ps.setLong(1, passengerId);
            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                return new User(rs.getLong("id"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("address"), rs.getDouble("solde"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }

    }
}
