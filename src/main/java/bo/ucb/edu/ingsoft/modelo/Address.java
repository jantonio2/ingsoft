package bo.ucb.edu.ingsoft.modelo;

public class Address {
    private Integer addressId;
    private Integer driverId;
    private Integer userId;
    private Integer companyId;
    private Integer startTravelId;
    private Integer deliveryTravelId;
    private String number;
    private String street;
    private String zone;
    private String city;
    private String country;
    private Integer status;
    private Transaction transaction;

    public Address() {
        transaction = new Transaction();
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getStartTravelId() {
        return startTravelId;
    }

    public void setStartTravelId(Integer startTravelId) {
        this.startTravelId = startTravelId;
    }

    public Integer getDeliveryTravelId() {
        return deliveryTravelId;
    }

    public void setDeliveryTravelId(Integer deliveryTravelId) {
        this.deliveryTravelId = deliveryTravelId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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
        return "Address{" +
                "addressId=" + addressId +
                ", driverId=" + driverId +
                ", userId=" + userId +
                ", companyId=" + companyId +
                ", startTravelId=" + startTravelId +
                ", deliveryTravelId=" + deliveryTravelId +
                ", number='" + number + '\'' +
                ", street='" + street + '\'' +
                ", zone='" + zone + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", status=" + status +
                ", transaction=" + transaction +
                '}';
    }
}
