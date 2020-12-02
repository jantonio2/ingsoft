package bo.ucb.edu.ingsoft.dto;

import bo.ucb.edu.ingsoft.modelo.Transaction;

public class CardCollectionRequest {
//    private Integer cardId;
//    private Integer userId;
    private String accountNumber;
    private String pin;
    private String bank;
    private String typeAccount;
    private String cvvCode;
    private Integer status;
//    private Transaction transaction;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


//    public Integer getCardId() {
//        return cardId;
//    }
//
//    public void setCardId(Integer cardId) {
//        this.cardId = cardId;
//    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
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

    @Override
    public String toString() {
        return "CardCollectionRequest{" +
//                "cardId=" + cardId +
                "accountNumber=" + accountNumber +
                ", pin=" + pin +
                ", bank='" + bank + '\'' +
                ", typeAccount='" + typeAccount + '\'' +
                ", cvvCode='" + cvvCode + '\'' +
                ", status=" + status +
                '}';
    }
}
