
package smarthomes.domain;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

/**
 *
 * @author Kelli
 */
public class Property {
    
    private Location location;
    private PropertyOwner owner;
    
    private int propertyId;
    private int ownerId;
    private String propertyType;
    private String propIntent;
    private String saleStatus;
    private double price;
    private String priceFormatted; //quick hack for currency formatted price..
    private int locationId;
    private String imgDirLocation;
    private String description;
    private String keywords;
    private String header;

    public Property(){
        
    }
    
    /**
     * Create a Property from database record fetch
     * @param location
     * @param propertyId
     * @param ownerId
     * @param area
     * @param propertyType
     * @param saleStatus
     * @param price
     * @param locationId
     * @param imageDir
     * @param description 
     * @param keywords 
     * @param header 
     */
    public Property(Location location,int propertyId, int ownerId,String propertyType,String saleStatus,double price,
            int locationId,String imageDir,String description, String keywords, String header){
        this.location = location;
        this.propertyId = propertyId;
        this.ownerId = ownerId;
        this.propertyType = propertyType;
        this.locationId = locationId;
        this.saleStatus = saleStatus;
        this.price = price;
        setPriceFormatted(price);
        this.imgDirLocation = imageDir;
        this.description = description;
        this.keywords = keywords;
        this.header = header;
    }

    /*
    Create a Property from the form supplied values
    */
    public Property(PropertyOwner owner, Location location, String propType, 
            String propIntent, String propPrice, String propDesc,
            String propHeader, String propKeywords,String dirName) {
        this.owner = owner;
        this.location = location;
        this.propIntent = propIntent;
        this.propertyType = propType;
        this.price = Double.parseDouble(propPrice);
        this.imgDirLocation = dirName;
        this.description = propDesc;
        this.keywords = propKeywords;
        this.header = propHeader;
        
    }
    
    
    /**
     * @return the propertyId
     */
    public int getPropertyId() {
        return propertyId;
    }

    /**
     * @param propertyId the propertyId to set
     */
    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    /**
     * @return the ownerId
     */
    public int getOwnerId() {
        return ownerId;
    }

    /**
     * @param ownerId the ownerId to set
     */
    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    /**
     * @return the propertyType
     */
    public String getPropertyType() {
        return propertyType;
    }

    /**
     * @param propertyType the propertyType to set
     */
    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    /**
     * @return the saleStatus
     */
    public String getSaleStatus() {
        return saleStatus;
    }

    /**
     * @param saleStatus the saleStatus to set
     */
    public void setSaleStatus(String saleStatus) {
        this.saleStatus = saleStatus;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the locationId
     */
    public int getLocationId() {
        return locationId;
    }

    /**
     * @param locationId the locationId to set
     */
    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    /**
     * @return the imgDirLocation
     */
    public String getImgDirLocation() {
        return imgDirLocation;
    }

    /**
     * @param imgDirLocation the imgDirLocation to set
     */
    public void setImgDirLocation(String imgDirLocation) {
        this.imgDirLocation = imgDirLocation;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the keywords
     */
    public String getKeywords() {
        return keywords;
    }

    /**
     * @param keywords the keywords to set
     */
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    /**
     * @return the header
     */
    public String getHeader() {
        return header;
    }

    /**
     * @param header the header to set
     */
    public void setHeader(String header) {
        this.header = header;
    }

    /**
     * @return the propIntent
     */
    public String getPropIntent() {
        return propIntent;
    }

    /**
     * @param propIntent the propIntent to set
     */
    public void setPropIntent(String propIntent) {
        this.propIntent = propIntent;
    }

    /**
     * @return the location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * @return the owner
     */
    public PropertyOwner getOwner() {
        return owner;
    }

    /**
     * @param owner the owner to set
     */
    public void setOwner(PropertyOwner owner) {
        this.owner = owner;
    }

    /**
     * @return the priceFormatted
     */
    public String getPriceFormatted() {
        return priceFormatted;
    }

    /**
     * I did this to save time on refactoring the class 
     * @param price the priceFormatted to set
     * Format the supplied double to a currency value with regional settings
     * for KE.
     */
    public void setPriceFormatted(double price) {
//       this.priceFormatted = "Ksh 345,000";
        Locale locale = new Locale.Builder().setRegion("KE").setLanguage("en").build();
//       alternatively  Locale loc = Locale.US
        NumberFormat format = NumberFormat.getCurrencyInstance(locale);
        ((DecimalFormat) format).setMinimumFractionDigits(0);
        ((DecimalFormat) format).setCurrency(Currency.getInstance(locale));
        this.priceFormatted = format.format(price);
    }
    
}
