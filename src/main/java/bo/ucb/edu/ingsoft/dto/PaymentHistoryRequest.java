package bo.ucb.edu.ingsoft.dto;

import bo.ucb.edu.ingsoft.modelo.Travel;

import java.sql.Date;

public class PaymentHistoryRequest {
    private String driverFirstName;
    private String driverFirstSurname;
    private String driverSecondSurname;
    private Date datePayment;
    private String paymentStatus;
    private Double amount;
    private String startStreet;
    private String startZone;
    private String startCity;
    private String startCountry;
    private String deliveryStreet;
    private String deliveryZone;
    private String deliveryCity;
    private String deliveryCountry;
    private String driverPicture;


    public PaymentHistoryRequest(){

    }
    public String getDriverFirstName() {
        return driverFirstName;
    }

    public void setDriverFirstName(String driverFirstName) {
        this.driverFirstName = driverFirstName;
    }

    public String getDriverFirstSurname() {
        return driverFirstSurname;
    }

    public void setDriverFirstSurname(String driverFirstSurname) {
        this.driverFirstSurname = driverFirstSurname;
    }

    public String getDriverSecondSurname() {
        return driverSecondSurname;
    }

    public void setDriverSecondSurname(String driverSecondSurname) {
        this.driverSecondSurname = driverSecondSurname;
    }

    public Date getDatePayment() {
        return datePayment;
    }

    public void setDatePayment(Date datePayment) {
        this.datePayment = datePayment;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
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

    public String getStartCity() {
        return startCity;
    }

    public void setStartCity(String startCity) {
        this.startCity = startCity;
    }

    public String getStartCountry() {
        return startCountry;
    }

    public void setStartCountry(String startCountry) {
        this.startCountry = startCountry;
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

    public String getDeliveryCity() {
        return deliveryCity;
    }

    public void setDeliveryCity(String deliveryCity) {
        this.deliveryCity = deliveryCity;
    }

    public String getDeliveryCountry() {
        return deliveryCountry;
    }

    public void setDeliveryCountry(String deliveryCountry) {
        this.deliveryCountry = deliveryCountry;
    }

    public String getDriverPicture() {
        return driverPicture;
    }

    public void setDriverPicture(String driverPicture) {
        this.driverPicture = driverPicture;
    }

    @Override
    public String toString() {
        return "PaymentHistoryRequest{" +
                "driverFirstName='" + driverFirstName + '\'' +
                ", driverFirstSurname='" + driverFirstSurname + '\'' +
                ", driverSecondSurname='" + driverSecondSurname + '\'' +
                ", datePayment=" + datePayment +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", amount=" + amount +
                ", startStreet='" + startStreet + '\'' +
                ", startZone='" + startZone + '\'' +
                ", startCity='" + startCity + '\'' +
                ", startCountry='" + startCountry + '\'' +
                ", deliveryStreet='" + deliveryStreet + '\'' +
                ", deliveryZone='" + deliveryZone + '\'' +
                ", deliveryCity='" + deliveryCity + '\'' +
                ", deliveryCountry='" + deliveryCountry + '\'' +
                ", driverPicture='" + driverPicture + '\'' +
                '}';
    }
}
