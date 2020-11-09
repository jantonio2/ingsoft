package bo.ucb.edu.ingsoft.modelo;

public class Card {
    private Integer cardId;
    private Integer usetId;
    private String accountNumber;
    private String pin;
    private String bank;
    private String typeAccount;
    private String cvvCode;
    private Integer status;
    private Transaction transaction;

    public Card(){
        transaction = new Transaction();
    }
    public Card(Transaction transaction){
        this.transaction = transaction;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public Integer getUsetId() {
        return usetId;
    }

    public void setUsetId(Integer usetId) {
        this.usetId = usetId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getTypeAccount() {
        return typeAccount;
    }

    public void setTypeAccount(String typeAccount) {
        this.typeAccount = typeAccount;
    }

    public String getCvvCode() {
        return cvvCode;
    }

    public void setCvvCode(String cvvCode) {
        this.cvvCode = cvvCode;
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
        return "Card{" +
                "cardId=" + cardId +
                ", usetId=" + usetId +
                ", accountNumber='" + accountNumber + '\'' +
                ", pin='" + pin + '\'' +
                ", bank='" + bank + '\'' +
                ", typeAccount='" + typeAccount + '\'' +
                ", cvvCode='" + cvvCode + '\'' +
                ", status=" + status +
                ", transaction=" + transaction +
                '}';
    }
}
