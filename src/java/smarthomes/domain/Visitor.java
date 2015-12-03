
package smarthomes.domain;

/**
 *http://wazza.co.ke
 * @author Kelli
 * @date Dec 2, 2015 8:59:36 AM
 */

public class Visitor {

    private String fName;
    private String lName;
    private String email;
    private String phone;

    public Visitor(String fName, String lName, String email, String phone){
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.phone = phone;
    }
    
    /**
     * @return the fName
     */
    public String getfName() {
        return fName;
    }

    /**
     * @param fName the fName to set
     */
    public void setfName(String fName) {
        this.fName = fName;
    }

    /**
     * @return the lName
     */
    public String getlName() {
        return lName;
    }

    /**
     * @param lName the lName to set
     */
    public void setlName(String lName) {
        this.lName = lName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
