package smarthomes.domain;

/**
 *
 * @author Kelli
 * @date 15-Nov-2015 13:20:25
 */
public class Location {

    private int locationId;
    private String county;
    private String division;
    private String town;
    private String road;
    private String plotNumber;

    public Location() {
    }

    public Location(String county, String division, String town, String road) {
        this.county = county;
        this.division = division;
        this.town = town;
        this.road = road;
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
     * @return the county
     */
    public String getCounty() {
        return county;
    }

    /**
     * @param county the county to set
     */
    public void setCounty(String county) {
        this.county = county;
    }

    /**
     * @return the division
     */
    public String getDivision() {
        return division;
    }

    /**
     * @param division the division to set
     */
    public void setDivision(String division) {
        this.division = division;
    }

    /**
     * @return the town
     */
    public String getTown() {
        return town;
    }

    /**
     * @param town the town to set
     */
    public void setTown(String town) {
        this.town = town;
    }

    /**
     * @return the road
     */
    public String getRoad() {
        return road;
    }

    /**
     * @param road the road to set
     */
    public void setRoad(String road) {
        this.road = road;
    }

    /**
     * @return the plotNumber
     */
    public String getPlotNumber() {
        return plotNumber;
    }

    /**
     * @param plotNumber the plotNumber to set
     */
    public void setPlotNumber(String plotNumber) {
        this.plotNumber = plotNumber;
    }
}

