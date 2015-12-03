package smarthomes.controllers;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import smarthomes.domain.utilities.ConnectionSupply;
import smarthomes.servlets.VisitBooking;

/**
 * http://wazza.co.ke
 *
 * @author Kelli
 * @date Dec 2, 2015 2:07:55 PM
 *
 * Handle booking tasks
 */
public class BookingController {

    private ResultSet results;
    private Connection connection;
    private final ConnectionSupply connSupp;

    //SQL statements 
    private final String visitorCreateSQL = "insert into smarthomes_db.visitors"
            + "(f_name,l_name,email_adrress,phone_number) values (?,?,?,?)";
    private final String bookingCreateSQL = "insert into smarthomes_db.booking"
            + "(visitor_id,property_id,visit_day,visit_time) values (?,?,?,?)";

    public BookingController() {
        connSupp = new ConnectionSupply();
    }

    /*
    Add a visitor record to the database
    @return the ID of this visitor record
     */
    public int createVisitor(String fName, String lName, String email, String phone) {
        int visitorId = 0;
        try {
            connection = connSupp.getConnectionUsingDriverManager();
            PreparedStatement ps = connection.prepareCall(visitorCreateSQL);
            ps.setString(1, fName);
            ps.setString(2, lName);
            ps.setString(3, email);
            ps.setString(4, phone);
            ps.executeUpdate();

            //get the ID of this record inserted...
            visitorId = getLastAddedItem(connection, "select visitor_id from "
                    + "visitors order by visitor_id desc limit 1;");
        } catch (SQLException ex) {
            Logger.getLogger(BookingController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return visitorId;
    }

    public void createBooking(int visitorId, int propertyId, Date vDate, Time vTime) {
        try {
            connection = connSupp.getConnectionUsingDriverManager();
            PreparedStatement ps = connection.prepareCall(bookingCreateSQL);
            ps.setInt(1, visitorId);
            ps.setInt(2, propertyId);
            ps.setDate(3, vDate);
            ps.setTime(4, vTime);
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(BookingController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Get the id of the most recently added visitor/booking
     *
     * @param c the connection to use
     * @param fetchSql SQL statement (uses ordering to get highest id from rows)
     * @param field the field to be returned
     * @return the id of the last item
     */
    private int getLastAddedItem(Connection c, String fetchSql) {
        int lastAdded = 0;
        try {
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(fetchSql);
            if (rs != null && rs.next()) {
                lastAdded = rs.getInt(1);//only 1 column in resultset
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return lastAdded;
    }

}
