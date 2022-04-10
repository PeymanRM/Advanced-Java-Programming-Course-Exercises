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

    private String username, password;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
