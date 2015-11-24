package smarthomes.domain.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Kelli Class Usage: Get database connection objects (from gf using
 * jndi) for use.
 */
public class ConnectionSupply {

    private static DataSource dataSource;
    
    private final String url = "jdbc:mysql://localhost:3306/smarthomes_db";
    private final String user = "dbadmin";
    private final String password = "12GreenEyes34+";

    /**
     * Option 1: Use JNDI to get the registered datasource object
     */
    static {
//        try {
//            dataSource = (DataSource) new InitialContext().lookup("redRoses");
//        } catch (NamingException exp) {
//            throw new ExceptionInInitializerError(exp.getCause());
//        }
    }

    /**
     * Option 2: Use the DriverManager
     */
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionSupply.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    /* Get database connections 
     * Option 1
    */
    
    public Connection getConnectionUsingJNDI() throws SQLException {
        return dataSource.getConnection();
    }
    
    /*
    * Option 2
    */
    public Connection getConnectionUsingDriverManager() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    /**
     * Close this connection
     *
     * @param conn connection to be closed
     * @return state of the connection.
     */
    public boolean closeConnection(Connection conn) {
        boolean isClosed = false;
        try {
            conn.close();
            isClosed = true;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ConnectionSupply.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isClosed;
    }

}
