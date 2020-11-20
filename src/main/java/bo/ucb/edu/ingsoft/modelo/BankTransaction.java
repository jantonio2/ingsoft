package bo.ucb.edu.ingsoft.modelo;

import java.util.Date;
import java.util.function.Supplier;

public class BankTransaction {
    private Integer bankTransactionId;
    private Integer driverBankAccountId;
    private Integer administrationBankAccountId;
    private Double amount;
    private Date transactionDate;
    private Integer status;
    private Transaction transaction;

    public BankTransaction(){
        transaction = new Transaction();
    }
    public BankTransaction(Transaction transaction){
        this.transaction = transaction;
    }

    public Integer getBankTransactionId() {
        return bankTransactionId;
    }

    public void setBankTransactionId(Integer bankTransactionId) {
        this.bankTransactionId = bankTransactionId;
    }

    public Integer getDriverBankAccountId() {
        return driverBankAccountId;
    }

    public void setDriverBankAccountId(Integer driverBankAccountId) {
        this.driverBankAccountId = driverBankAccountId;
    }

    public Integer getAdministrationBankAccountId() {
        return administrationBankAccountId;
    }

    public void setAdministrationBankAccountId(Integer administrationBankAccountId) {
        this.administrationBankAccountId = administrationBankAccountId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
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
        return "BankTransaction{" +
                "bankTransactionId=" + bankTransactionId +
                ", driverBankAccountId=" + driverBankAccountId +
                ", administrationBankAccountId=" + administrationBankAccountId +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                ", status=" + status +
                ", transaction=" + transaction +
                '}';
    }
}
