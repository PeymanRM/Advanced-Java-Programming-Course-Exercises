package homework2;

/**
 * Created by Peyman RM
 */
public class Database {
    private static Database database;
    public synchronized static Database getInstance() {
        if(database == null){
            database = new Database();
        }
        return database;
    }
}
