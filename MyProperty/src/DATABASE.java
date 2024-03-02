
import com.mysql.cj.jdbc.MysqlDataSource;
//import com.sun.jdi.connect.spi.Connection;
import java.sql.Connection; 
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author shoumikbarmanpolok
 */
public class DATABASE {
    private static String servername="localhost";
    private static String dbname="java_rst";
    private static String username="root";
    private static Integer portnumber=3306;
    private static String password="";
    
    public static Connection getTheConnection()
    {
        Connection connection=null;
        MysqlDataSource datasource=new MysqlDataSource();
        datasource.setServerName(servername);
        datasource.setUser(username);
        datasource.setDatabaseName(dbname);
        datasource.setPortNumber(portnumber);
        datasource.setPassword(password);
        
        try {
            connection = (Connection) datasource.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DATABASE.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }
            
}
