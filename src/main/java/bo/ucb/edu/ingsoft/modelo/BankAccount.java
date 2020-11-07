package bo.ucb.edu.ingsoft.modelo;

public class BankAccount {
    private Integer bankAccountId;
    private Integer driverId;
    private Integer administrationId;
    private Integer accountNumber;
    private String bank;
    private String accountType;
    private Integer status;
    private Transaction transaction;

    public BankAccount(){
        transaction = new Transaction();
    }
    public BankAccount(Transaction transaction){
        this.transaction = transaction;
    }

    public Integer getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(Integer bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    public Integer getAdministrationId() {
        return administrationId;
    }

    public void setAdministrationId(Integer administrationId) {
        this.administrationId = administrationId;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
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
        return "BankAccount{" +
                "bankAccountId=" + bankAccountId +
                ", driverId=" + driverId +
                ", administrationId=" + administrationId +
                ", accountNumber=" + accountNumber +
                ", bank='" + bank + '\'' +
                ", accountType='" + accountType + '\'' +
                ", status=" + status +
                ", transaction=" + transaction +
                '}';
    }
}
