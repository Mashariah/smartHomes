package smarthomes.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import smarthomes.domain.Location;
import smarthomes.domain.Property;
import smarthomes.domain.PropertyOwner;
import smarthomes.domain.utilities.ConnectionSupply;

/**
 *
 * @author Kelli Class Usage: All tasks on properties; fetch, search, edit,
 * delete
 */
public class PropertyController {

    private ResultSet results;
    private Connection connection;

    private final String findProperties
            = "SELECT * FROM Property order by property_id desc";
    private final String addNewLocation = "insert into smarthomes_db.location"
            + "(county,division,town,road,plot_number) values (?,?,?,?,?)";
    private final String addNewOwner = "insert into smarthomes_db.property_owner"
            + "(first_name,last_name,email,phone_number) values (?,?,?,?)";
    private final String addNewProperty = "insert into smarthomes_db.property"
            + "(owner_id,property_type,price,location_id,images_dir_id,description,"
            + "keywords,header,intent) values (?,?,?,?,?,?,?,?,?)";

    /**
     * Get all Properties
     *
     * @return list of Property objects
     */
    private final ConnectionSupply connSupp = new ConnectionSupply();
    java.util.logging.Logger logger = Logger.getLogger(PropertyController.class.getName());

    /**
     * Get a listing of all properties
     * @return list of properties
     */
    public List<Property> getAllProperties() {
        List<Property> listOfProperties = new ArrayList<>();
        try {
            connection = connSupp.getConnectionUsingDriverManager();
            PreparedStatement pstatement = connection.prepareStatement(findProperties);
            results = pstatement.executeQuery();
            while (results.next()) {
                Property p = new Property(results.getInt("owner_id"),
                        results.getString("property_type"),
                        results.getString("sale_status"), results.getDouble("price"),
                        results.getInt("location_id"), results.getString("images_dir_id"), results.getString("description"), results.getString("keywords"),
                        results.getString("header"));
                listOfProperties.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PropertyController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                connSupp.closeConnection(connection);
            }
        }
        System.out.println("Items in list: " + listOfProperties.size());
        return listOfProperties;
    }

    /**
     * Add a new Property item to the properties table 
     * @param property instance to add
     * @return status of the update (success or failure)
     */
    public boolean addNewProperty(Property property) {
        
        int state = 0; 
        Location location = property.getLocation();
        PropertyOwner owner = property.getOwner();
        
        int ownerId = addNewOwner(owner);
        int locationId = addNewLocation(location);
        
        try {
            connection =connSupp.getConnectionUsingDriverManager();
            PreparedStatement statement = connection.prepareStatement(addNewProperty);
            statement.setInt(1, ownerId);
            statement.setString(2, property.getPropertyType());
            statement.setDouble(3, property.getPrice());
            statement.setDouble(4, locationId);
            statement.setString(5, property.getImgDirLocation());
            statement.setString(6, property.getDescription());
            statement.setString(7, property.getKeywords());
            statement.setString(8, property.getHeader());
            statement.setString(9, property.getPropIntent());
            state = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PropertyController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return state>-1;
    }

    /**
     * Add a new Property owner to the database
     *
     * @param pOwner
     * @return
     */
    public int addNewOwner(PropertyOwner pOwner) {

        int ownerId = 0;
        try {
            connection = connSupp.getConnectionUsingDriverManager();
            PreparedStatement pstm = connection.prepareStatement(addNewOwner);

            pstm.setString(1, pOwner.getFirstName());
            pstm.setString(2, pOwner.getLastName());
            pstm.setString(3, pOwner.getEmail());
            pstm.setString(4, pOwner.getPhoneNumber());
            pstm.executeUpdate();

//            Get the id of this newly added owner
            String latestOwnerIdSql = "select owner_id from property_owner order by owner_id desc limit 1;";
            ownerId = getLastAddedItem(connection, latestOwnerIdSql);

        } catch (SQLException ex) {
            Logger.getLogger(PropertyController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.close();
            } catch (SQLException sqle) {
                Logger.getLogger(PropertyController.class.getName()).log(Level.SEVERE, "Error closing db connection");
            }
        }
        return ownerId;
    }
    
    /**
     * Add a new location to the Location table
     * @param location
     * @return 
     */
    public int addNewLocation(Location location) {

        int locationId = 0;
        try {
            connection = connSupp.getConnectionUsingDriverManager();
            PreparedStatement statement = connection.prepareStatement(addNewLocation);

            statement.setString(1, location.getCounty());
            statement.setString(2, location.getDivision());
            statement.setString(3, location.getTown());
            statement.setString(4, location.getRoad());
            statement.setString(5, location.getPlotNumber());
            statement.executeUpdate();

//            Get the id of this newly added location
            String latestAddedLocationSql = "select location_id from location order by location_id desc limit 1;";
            locationId = getLastAddedItem(connection, latestAddedLocationSql);

        } catch (SQLException ex) {
            Logger.getLogger(PropertyController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.close();
            } catch (SQLException sqle) {
                Logger.getLogger(PropertyController.class.getName()).log(Level.SEVERE, "Error closing db connection");
            }
        }
        return locationId;
    }

    /**
     * Get the id of the most recently added item in a table
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
