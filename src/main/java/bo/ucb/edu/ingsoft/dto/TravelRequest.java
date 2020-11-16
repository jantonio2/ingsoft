package bo.ucb.edu.ingsoft.dto;

import java.util.Date;

public class TravelRequest {
    private Integer travelUserId;
    private Integer travelDriverId;
    private String travelStatus;
    private Date travelDateDelivery;
    private String startAddressNumber;
    private String startAddressStreet;
    private String startAddressZone;
    private String startAddressCity;
    private String startAddressCountry;
    private String deliveryAddressNumber;
    private String deliveryAddressStreet;
    private String deliveryAddressZone;
    private String deliveryAddressCity;
    private String deliveryAddressCountry;


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

    public String getStartAddressNumber() {
        return startAddressNumber;
    }

    public void setStartAddressNumber(String startAddressNumber) {
        this.startAddressNumber = startAddressNumber;
    }

    public String getStartAddressStreet() {
        return startAddressStreet;
    }

    public void setStartAddressStreet(String startAddressStreet) {
        this.startAddressStreet = startAddressStreet;
    }

    public String getStartAddressZone() {
        return startAddressZone;
    }

    public void setStartAddressZone(String startAddressZone) {
        this.startAddressZone = startAddressZone;
    }

    public String getStartAddressCity() {
        return startAddressCity;
    }

    public void setStartAddressCity(String startAddressCity) {
        this.startAddressCity = startAddressCity;
    }

    public String getStartAddressCountry() {
        return startAddressCountry;
    }

    public void setStartAddressCountry(String startAddressCountry) {
        this.startAddressCountry = startAddressCountry;
    }

    public String getDeliveryAddressNumber() {
        return deliveryAddressNumber;
    }

    public void setDeliveryAddressNumber(String deliveryAddressNumber) {
        this.deliveryAddressNumber = deliveryAddressNumber;
    }

    public String getDeliveryAddressStreet() {
        return deliveryAddressStreet;
    }

    public void setDeliveryAddressStreet(String deliveryAddressStreet) {
        this.deliveryAddressStreet = deliveryAddressStreet;
    }

    public String getDeliveryAddressZone() {
        return deliveryAddressZone;
    }

    public void setDeliveryAddressZone(String deliveryAddressZone) {
        this.deliveryAddressZone = deliveryAddressZone;
    }

    public String getDeliveryAddressCity() {
        return deliveryAddressCity;
    }

    public void setDeliveryAddressCity(String deliveryAddressCity) {
        this.deliveryAddressCity = deliveryAddressCity;
    }

    public String getDeliveryAddressCountry() {
        return deliveryAddressCountry;
    }

    public void setDeliveryAddressCountry(String deliveryAddressCountry) {
        this.deliveryAddressCountry = deliveryAddressCountry;
    }

    @Override
    public String toString() {
        return "TravelRequest{" +
                "travelUserId=" + travelUserId +
                ", travelDriverId=" + travelDriverId +
                ", travelStatus='" + travelStatus + '\'' +
                ", travelDateDelivery=" + travelDateDelivery +
                ", startAddressNumber='" + startAddressNumber + '\'' +
                ", startAddressStreet='" + startAddressStreet + '\'' +
                ", startAddressZone='" + startAddressZone + '\'' +
                ", startAddressCity='" + startAddressCity + '\'' +
                ", startAddressCountry='" + startAddressCountry + '\'' +
                ", deliveryAddressNumber='" + deliveryAddressNumber + '\'' +
                ", deliveryAddressStreet='" + deliveryAddressStreet + '\'' +
                ", deliveryAddressZone='" + deliveryAddressZone + '\'' +
                ", deliveryAddressCity='" + deliveryAddressCity + '\'' +
                ", deliveryAddressCountry='" + deliveryAddressCountry + '\'' +
                '}';
    }
}

