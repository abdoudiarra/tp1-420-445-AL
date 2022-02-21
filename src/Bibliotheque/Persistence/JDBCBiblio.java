package Bibliotheque.Persistence;

import Bibliotheque.Model.Document;
import Bibliotheque.Model.User;

import javax.print.Doc;
import java.util.List;

public interface JDBCBiblio {
    void createDatabase();

    void save(Document document) throws Exception;

    void save(User user);

    List<Document> getDocument(String type, String value);
    List<Document> getDocument(String type, int value);

    User getUser(long passengerId);
}
