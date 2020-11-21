package bo.ucb.edu.ingsoft.modelo;

import java.util.Date;

public class Payment {
    private Integer paymentId;
    private Integer travelId;
    private Integer administrationId;
    private Date datePayment;
    private String paymentStatus;
    private Double amount;
    private Integer status;
    private Transaction transaction;

    public Payment(){
        transaction = new Transaction();
    }
    public Payment(Transaction transaction){
        this.transaction = transaction;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public Integer getTravelId() {
        return travelId;
    }

    public void setTravelId(Integer travelId) {
        this.travelId = travelId;
    }

    public Integer getAdministrationId() {
        return administrationId;
    }

    public void setAdministrationId(Integer administrationId) {
        this.administrationId = administrationId;
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
        return "Payment{" +
                "paymentId=" + paymentId +
                ", travelId=" + travelId +
                ", administrationId=" + administrationId +
                ", datePayment=" + datePayment +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                ", transaction=" + transaction +
                '}';
    }
}
