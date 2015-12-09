package smarthomes.controllers;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import smarthomes.domain.Booking;
import smarthomes.domain.Property;
import smarthomes.domain.Visitor;
import smarthomes.domain.utilities.ConnectionSupply;

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
    private Logger logger;

    //SQL statements 
    private final String visitorCreateSQL = "insert into smarthomes_db.visitors"
            + "(f_name,l_name,email_adrress,phone_number) values (?,?,?,?)";
    private final String bookingCreateSQL = "insert into smarthomes_db.booking"
            + "(visitor_id,property_id,visit_day,visit_time) values (?,?,?,?)";
    private final String getBookings = "select f_name,l_name,email_adrress,"
            + "phone_number,header,visit_day,visit_time \n" +
            "from smarthomes_db.booking,smarthomes_db.property,smarthomes_db.visitors\n" +
            "where booking.visitor_id = visitors.visitor_id\n" +
            "and booking.property_id = property.property_id;";

    public BookingController() {
        connSupp = new ConnectionSupply();
        logger = Logger.getLogger(BookingController.class.getName());
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
            logger.log(Level.SEVERE, null, ex);
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
    
    /**
     * Get list of all bookings made.
     * @return list of all bookings.
     */
    public List<Booking> getAllBookings(){
        List<Booking> visitBookings = new ArrayList<>();
        try{
            connection = connSupp.getConnectionUsingDriverManager();
            PreparedStatement statement = connection.prepareCall(getBookings);
            ResultSet rs = statement.executeQuery();
            logger.log(Level.INFO,"Getting results...");
            while(rs.next()){
                //create visitor
                Visitor visitor = new Visitor(rs.getString("f_name"), rs.getString("l_name"),
                rs.getString("email_adrress"),rs.getString("phone_number"));
                //create proerty
                Property property = new Property();
                property.setHeader(rs.getString("header"));
                //create the booking
                Booking booking = new Booking(visitor,property,rs.getDate("visit_day"),rs.getDate("visit_time"));
                logger.log(Level.INFO,booking.toString());
                visitBookings.add(booking);
            }
        }catch(Exception exp){
            logger.log(Level.SEVERE,exp.getMessage());
            exp.getLocalizedMessage();
        }
        finally {
            if (connection != null) {
                connSupp.closeConnection(connection);
            }
        }
        return visitBookings;
    }
}
