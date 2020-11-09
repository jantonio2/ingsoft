package bo.ucb.edu.ingsoft.modelo;

import java.util.Date;

public class Payment {
    private Integer paymentId;
    private Integer travelId;
    private Date datePayment;
    private Double amount;
    private String status;
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

    public Date getDatePayment() {
        return datePayment;
    }

    public void setDatePayment(Date datePayment) {
        this.datePayment = datePayment;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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
                ", datePayment=" + datePayment +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                ", transaction=" + transaction +
                '}';
    }
}
