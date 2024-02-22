package connection;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {

    private static DatabaseConnection instance;
    private Connection connection;

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    private DatabaseConnection() {

    }

    public void connectToDatabase() throws SQLException {
        Properties props = new  Properties();
          try (FileInputStream fis = new FileInputStream("conf.properties"))
            {
                props.load(fis);
                //Class.forName(props.getProperty("jdbc.driver.class"));
                String hostname  = props.getProperty("base.hostname"); 
                String port  = props.getProperty("base.port");
                String bd  = props.getProperty("base.nomdebase");
                String utilisateur  = props.getProperty("base.utilisateur");
                String motdepasse  = props.getProperty("base.motdepasse");
                this.connection = java.sql.DriverManager.getConnection("jdbc:mysql://"+hostname+":"+port+"/"+bd,utilisateur,motdepasse);
            }
          catch (Exception e)
            {
              e.printStackTrace();
            }
        //connection = java.sql.DriverManager.getConnection("jdbc:sqlite:chatApp.db");
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
