package bo.ucb.edu.ingsoft.modelo;

import java.util.Date;

public class Travel {
    private Integer travelId;
    private Integer userId;
    private Integer driverId;
    private String travelStatus;
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

    public String getTravelStatus() {
        return travelStatus;
    }

    public void setTravelStatus(String travelStatus) {
        this.travelStatus = travelStatus;
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

    @Override
    public String toString() {
        return "Travel{" +
                "travelId=" + travelId +
                ", userId=" + userId +
                ", driverId=" + driverId +
                ", travelStatus='" + travelStatus + '\'' +
                ", dateDelivery=" + dateDelivery +
                ", status=" + status +
                ", transaction=" + transaction +
                '}';
    }
}