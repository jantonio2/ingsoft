package bo.ucb.edu.ingsoft.dto;

import java.sql.Date;

public class DriverHistoryRequest {
    private String userFirstName;
    private String startStreet;
    private String startZone;
    private String deliveryStreet;
    private String deliveryZone;
    private Date dateDelivery;
    private String userPhone;
    private String travelStatus;

    public DriverHistoryRequest(){

    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getStartStreet() {
        return startStreet;
    }

    public void setStartStreet(String startStreet) {
        this.startStreet = startStreet;
    }

    public String getStartZone() {
        return startZone;
    }

    public void setStartZone(String startZone) {
        this.startZone = startZone;
    }

    public String getDeliveryStreet() {
        return deliveryStreet;
    }

    public void setDeliveryStreet(String deliveryStreet) {
        this.deliveryStreet = deliveryStreet;
    }

    public String getDeliveryZone() {
        return deliveryZone;
    }

    public void setDeliveryZone(String deliveryZone) {
        this.deliveryZone = deliveryZone;
    }

    public Date getDateDelivery() {
        return dateDelivery;
    }

    public void setDateDelivery(Date dateDelivery) {
        this.dateDelivery = dateDelivery;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getTravelStatus() {
        return travelStatus;
    }

    public void setTravelStatus(String travelStatus) {
        this.travelStatus = travelStatus;
    }

    @Override
    public String toString() {
        return "DriverHistoryRequest{" +
                "userFirstName='" + userFirstName + '\'' +
                ", startStreet='" + startStreet + '\'' +
                ", startZone='" + startZone + '\'' +
                ", deliveryStreet='" + deliveryStreet + '\'' +
                ", deliveryZone='" + deliveryZone + '\'' +
                ", dateDelivery=" + dateDelivery +
                ", userPhone='" + userPhone + '\'' +
                ", travelStatus='" + travelStatus + '\'' +
                '}';
    }
}
