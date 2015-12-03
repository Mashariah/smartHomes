
package smarthomes.domain;

import java.sql.Date;

/**
 *http://wazza.co.ke
 * @author Kelli
 * @date Dec 2, 2015 8:51:12 AM
 */

public class Booking {

    private Visitor visitor;
    private int propertyId;
    private Date dateOfVisit;
    private Date timeOfVisit;
    
    public Booking(Visitor visitor,int propertyId,Date dateOfVisit, Date timeOfVisit){
        this.visitor = visitor;
        this.propertyId = propertyId;
        this.dateOfVisit = dateOfVisit;
        this.timeOfVisit = timeOfVisit;
    }
    

    /**
     * @return the visitor
     */
    public Visitor getVisitor() {
        return visitor;
    }

    /**
     * @param visitor the visitor to set
     */
    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
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
     * @return the dateOfVisit
     */
    public Date getDateOfVisit() {
        return dateOfVisit;
    }

    /**
     * @param dateOfVisit the dateOfVisit to set
     */
    public void setDateOfVisit(Date dateOfVisit) {
        this.dateOfVisit = dateOfVisit;
    }

    /**
     * @return the timeOfVisit
     */
    public Date getTimeOfVisit() {
        return timeOfVisit;
    }

    /**
     * @param timeOfVisit the timeOfVisit to set
     */
    public void setTimeOfVisit(Date timeOfVisit) {
        this.timeOfVisit = timeOfVisit;
    }
}
