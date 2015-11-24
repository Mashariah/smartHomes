
package tests.connection.utilities;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import smarthomes.controllers.PropertyController;
import smarthomes.domain.Location;
import smarthomes.domain.Property;
import smarthomes.domain.PropertyOwner;

/**
 *
 * @author Kelli
 * @date 17-Nov-2015 11:43:51
 */
public class PropertyControllerTest {
    
    PropertyController pc = new PropertyController();
    
    @Test
    public void testGetProperties(){
        List<Property> list = pc.getAllProperties();
        Assert.assertEquals(3, list.size());
    }
    
//    @Test
    public void testAddPropertyOwner(){
        PropertyOwner pOwner = new PropertyOwner("Metallica", "Nofiur", "kim@ls.ke", "4378294");
        int ownerId = pc.addNewOwner(pOwner);
        Assert.assertEquals(5,ownerId);
    }
    
//    @Test
    public void testAddLocation(){
        Location location = new Location("LAIKIPIA", "Rumuruti", "Lari", "Kaptin");
        int locationId = pc.addNewLocation(location);
        Assert.assertEquals(7,locationId);
    }
    
    @Test
    public void testAddProperty(){
        PropertyOwner pOwner = new PropertyOwner("Mariana", "Mosary", "morsay@gmail.co.ke", "872233188");
        Location location = new Location("NYANDARUA", "Kabati", "Kiters", "Landhies Rd.");
        Property p = new Property(pOwner, location, 
                "APARTMENT", "LEASE", "250000", "This is prime property for farming", "Farm Land", "farming,", "3422");
        Assert.assertTrue(pc.addNewProperty(p));
               
    }
}
