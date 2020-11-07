package bo.ucb.edu.ingsoft.modelo;

import java.util.Date;

public class Travel {
    private Integer travelId;
    private Integer userId;
    private Integer driverId;
    private Integer starAddressId;
    private Integer deliveryAddressId;
    private Date dateDelivery;
    private Integer status;
    private Transaction transaction;

    public Travel(){
        transaction = new Transaction();
    }

    public Integer getTravelId() {
        return travelId;
    }

    public void setTravelId(Integer travelId) {
        this.travelId = travelId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    public Integer getStarAddressId() {
        return starAddressId;
    }

    public void setStarAddressId(Integer starAddressId) {
        this.starAddressId = starAddressId;
    }

    public Integer getDeliveryAddressId() {
        return deliveryAddressId;
    }

    public void setDeliveryAddressId(Integer deliveryAddressId) {
        this.deliveryAddressId = deliveryAddressId;
    }

    public Date getDateDelivery() {
        return dateDelivery;
    }

    public void setDateDelivery(Date dateDelivery) {
        this.dateDelivery = dateDelivery;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
