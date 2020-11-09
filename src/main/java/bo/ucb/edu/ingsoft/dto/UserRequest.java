package bo.ucb.edu.ingsoft.dto;

import bo.ucb.edu.ingsoft.modelo.Transaction;

public class UserRequest {

    private Integer userId;

    private String personFirstName;
    private String personFirstSurname;
    private String personSecondSurname;
    private String birthDate;
    private String personCi;
    private String personPhone;
    private String addressStreet;
    private String addressZone;
    private String addressCity;
    private String addressCountry;
    private String email;
    private String password;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPersonFirstName() {
        return personFirstName;
    }

    public void setPersonFirstName(String personFirstName) {
        this.personFirstName = personFirstName;
    }

    public String getPersonFirstSurname() {
        return personFirstSurname;
    }

    public void setPersonFirstSurname(String personFirstSurname) {
        this.personFirstSurname = personFirstSurname;
    }

    public String getPersonSecondSurname() {
        return personSecondSurname;
    }

    public void setPersonSecondSurname(String personSecondSurname) {
        this.personSecondSurname = personSecondSurname;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getPersonCi() {
        return personCi;
    }

    public void setPersonCi(String personCi) {
        this.personCi = personCi;
    }

    public String getPersonPhone() {
        return personPhone;
    }

    public void setPersonPhone(String personPhone) {
        this.personPhone = personPhone;
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    public String getAddressZone() {
        return addressZone;
    }

    public void setAddressZone(String addressZone) {
        this.addressZone = addressZone;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressCountry() {
        return addressCountry;
    }

    public void setAddressCountry(String addressCountry) {
        this.addressCountry = addressCountry;
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

    @Override
    public String toString() {
        return "UserRequest{" +
                "userId=" + userId +
                ", personFirstName='" + personFirstName + '\'' +
                ", personFirstSurname='" + personFirstSurname + '\'' +
                ", personSecondSurname='" + personSecondSurname + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", personCi='" + personCi + '\'' +
                ", personPhone='" + personPhone + '\'' +
                ", addressStreet='" + addressStreet + '\'' +
                ", addressZone='" + addressZone + '\'' +
                ", addressCity='" + addressCity + '\'' +
                ", addressCountry='" + addressCountry + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
