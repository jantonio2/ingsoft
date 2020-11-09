package bo.ucb.edu.ingsoft.dto;

import java.util.Date;

public class TravelRequest {
    private Integer travelUserId;
    private Integer travelDriverId;
    private String travelStatus;
    private Date travelDateDelivery;
    private String addressNumber;
    private String addressStreet;
    private String addressZone;
    private String addressCity;
    private String addressCountry;


    public Integer getTravelUserId() {
        return travelUserId;
    }

    public void setTravelUserId(Integer travelUserId) {
        this.travelUserId = travelUserId;
    }

    public Integer getTravelDriverId() {
        return travelDriverId;
    }

    public void setTravelDriverId(Integer travelDriverId) {
        this.travelDriverId = travelDriverId;
    }

    public String getTravelStatus() {
        return travelStatus;
    }

    public void setTravelStatus(String travelStatus) {
        this.travelStatus = travelStatus;
    }

    public Date getTravelDateDelivery() {
        return travelDateDelivery;
    }

    public void setTravelDateDelivery(Date travelDateDelivery) {
        this.travelDateDelivery = travelDateDelivery;
    }
    public String getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    public String getAddressZone() {
        return addressZone;
    }

    public void setAddressZone(String addressZone) {
        this.addressZone = addressZone;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressCountry() {
        return addressCountry;
    }

    public void setAddressCountry(String addressCountry) {
        this.addressCountry = addressCountry;
    }
}
