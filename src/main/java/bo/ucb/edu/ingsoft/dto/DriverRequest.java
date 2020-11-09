package bo.ucb.edu.ingsoft.dto;

public class DriverRequest {

    private Integer driverId;
    private String personDFirstName;
    private String personDFirstSurname;
    private String personDSecondSurname;
    private String birthDateDriver;
    private String personDCi;
    private String personDPhone;
    private String addressDStreet;
    private String addressDZone;
    private String addressDCity;
    private String addressDCountry;
    private String companyName;
    private String companyEmail;
    private String companyPhone;
    private Integer bankAccountNumber;
    private String bankAccountBank;
    private String bankAccountType;
    private String emailDriver;
    private String passwordDriver;

    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    public String getPersonDFirstName() {
        return personDFirstName;
    }

    public void setPersonDFirstName(String personDFirstName) {
        this.personDFirstName = personDFirstName;
    }

    public String getPersonDFirstSurname() {
        return personDFirstSurname;
    }

    public void setPersonDFirstSurname(String personDFirstSurname) {
        this.personDFirstSurname = personDFirstSurname;
    }

    public String getPersonDSecondSurname() {
        return personDSecondSurname;
    }

    public void setPersonDSecondSurname(String personDSecondSurname) {
        this.personDSecondSurname = personDSecondSurname;
    }

    public String getBirthDateDriver() {
        return birthDateDriver;
    }

    public void setBirthDateDriver(String birthDateDriver) {
        this.birthDateDriver = birthDateDriver;
    }

    public String getPersonDCi() {
        return personDCi;
    }

    public void setPersonDCi(String personDCi) {
        this.personDCi = personDCi;
    }

    public String getPersonDPhone() {
        return personDPhone;
    }

    public void setPersonDPhone(String personDPhone) {
        this.personDPhone = personDPhone;
    }

    public String getAddressDStreet() {
        return addressDStreet;
    }

    public void setAddressDStreet(String addressDStreet) {
        this.addressDStreet = addressDStreet;
    }

    public String getAddressDZone() {
        return addressDZone;
    }

    public void setAddressDZone(String addressDZone) {
        this.addressDZone = addressDZone;
    }

    public String getAddressDCity() {
        return addressDCity;
    }

    public void setAddressDCity(String addressDCity) {
        this.addressDCity = addressDCity;
    }

    public String getAddressDCountry() {
        return addressDCountry;
    }

    public void setAddressDCountry(String addressDCountry) {
        this.addressDCountry = addressDCountry;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public Integer getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(Integer bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getBankAccountBank() {
        return bankAccountBank;
    }

    public void setBankAccountBank(String bankAccountBank) {
        this.bankAccountBank = bankAccountBank;
    }

    public String getBankAccountType() {
        return bankAccountType;
    }

    public void setBankAccountType(String bankAccountType) {
        this.bankAccountType = bankAccountType;
    }

    public String getEmailDriver() {
        return emailDriver;
    }

    public void setEmailDriver(String emailDriver) {
        this.emailDriver = emailDriver;
    }

    public String getPasswordDriver() {
        return passwordDriver;
    }

    public void setPasswordDriver(String passwordDriver) {
        this.passwordDriver = passwordDriver;
    }

    @Override
    public String toString() {
        return "DriverRequest{" +
                "driverId=" + driverId +
                ", personDFirstName='" + personDFirstName + '\'' +
                ", personDFirstSurname='" + personDFirstSurname + '\'' +
                ", personDSecondSurname='" + personDSecondSurname + '\'' +
                ", birthDateDriver='" + birthDateDriver + '\'' +
                ", personDCi='" + personDCi + '\'' +
                ", personDPhone='" + personDPhone + '\'' +
                ", addressDStreet='" + addressDStreet + '\'' +
                ", addressDZone='" + addressDZone + '\'' +
                ", addressDCity='" + addressDCity + '\'' +
                ", addressDCountry='" + addressDCountry + '\'' +
                ", companyName='" + companyName + '\'' +
                ", companyEmail='" + companyEmail + '\'' +
                ", companyPhone='" + companyPhone + '\'' +
                ", bankAccountNumber=" + bankAccountNumber +
                ", bankAccountBank='" + bankAccountBank + '\'' +
                ", bankAccountType='" + bankAccountType + '\'' +
                ", emailDriver='" + emailDriver + '\'' +
                ", passwordDriver='" + passwordDriver + '\'' +
                '}';
    }
}
