package bo.ucb.edu.ingsoft.modelo;

public class Administration {
    private Integer administrationId;
    private Integer personId;
    private Integer paymentId;
    private String email;
    private String password;
    private Integer status;
    private Transaction transaction;

    public Administration(){
        transaction = new Transaction();
    }
    public Administration(Transaction transaction){
        this.transaction = transaction;
    }

    public Integer getAdministrationId() {
        return administrationId;
    }

    public void setAdministrationId(Integer administrationId) {
        this.administrationId = administrationId;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        return "Administration{" +
                "administrationId=" + administrationId +
                ", personId=" + personId +
                ", paymentId=" + paymentId +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", transaction=" + transaction +
                '}';
    }
}
