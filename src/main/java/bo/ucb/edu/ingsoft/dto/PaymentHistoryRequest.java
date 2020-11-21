package bo.ucb.edu.ingsoft.dto;

import bo.ucb.edu.ingsoft.modelo.Travel;

import java.sql.Date;

public class PaymentHistoryRequest {
    private Date datePayment;
    private String paymentStatus;
    private Double amount;
    private String driverFirstName;
    private String driverFirstSurname;

    public PaymentHistoryRequest(){

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

    @Override
    public String toString() {
        return "DriverHistoryRequest{" +
                "datePayment='" + datePayment + '\'' +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", amount='" + amount + '\'' +
                ", driverFirstName='" + driverFirstName + '\'' +
                ", driverFirstSurname='" + driverFirstSurname + '\'' +
                '}';
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
}
