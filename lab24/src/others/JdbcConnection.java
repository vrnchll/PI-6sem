package others;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcConnection {
    public static Connection getConnection(){
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/db"
                    //+
//                    "?verifyServerCertificate=false"+
//                    "&useSSL=false"+
//                    "&requireSSL=false"+
//                    "&useLegacyDatetimeCode=false"+
//                    "&amp"+
//                    "&serverTimezone=Europe/Moscow"
                    ;
            Properties props = new Properties();
            props.setProperty("user","test");
            props.setProperty("password","12345");
         //   props.setProperty("ssl","true");
            Connection connection = DriverManager.getConnection(url, props);
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
