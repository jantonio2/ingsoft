package bo.ucb.edu.ingsoft.modelo;

import java.util.Date;

public class Driver {
    private Integer driverId;
    private Integer personId;
    private Integer addressId;
    private Integer companyId;
    private Date birthDate;
    private String email;
    private String password;
    private String picture;
    private Integer status;
    private Transaction transaction;

    public Driver(){
        transaction = new Transaction();
    }
    public Driver(Transaction transaction){
        this.transaction = transaction;
    }

    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
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
        return "Driver{" +
                "driverId=" + driverId +
                ", personId=" + personId +
                ", addressId=" + addressId +
                ", companyId=" + companyId +
                ", birthDate=" + birthDate +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", picture='" + picture + '\'' +
                ", status=" + status +
                ", transaction=" + transaction +
                '}';
    }
}
