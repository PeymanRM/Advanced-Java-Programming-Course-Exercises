package homework2;

/**
 * Created by Peyman RM
 */
public class Database {
    private static Database database;
    public synchronized static Database getInstance() {  //not efficient
        if(database == null){
            database = new Database();
        }
        return database;
    }
    private Database() {}
}
