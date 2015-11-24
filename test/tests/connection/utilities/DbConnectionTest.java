
package tests.connection.utilities;

import java.sql.Connection;
import java.sql.SQLException;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import smarthomes.domain.utilities.ConnectionSupply;

/**
 *
 * @author Kelli
 * @date 16-Nov-2015 16:13:52
 */
public class DbConnectionTest {

    @Test
    
    public void testDbConnection() {
         Connection conn = null;
        try{
            
            conn = new ConnectionSupply().getConnectionUsingDriverManager();
        }catch(SQLException sqle){
            System.out.println(sqle.getCause());
        }
        assertNotNull(conn);
    }
}
