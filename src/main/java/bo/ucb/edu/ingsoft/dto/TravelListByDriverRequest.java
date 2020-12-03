package bo.ucb.edu.ingsoft.dto;

public class TravelListByDriverRequest {
    int userId;
    String userFirstName;
    String userFirsSurname;
    String travelDateDelivery;
    String userPhone;
    String travelStatus;
    int startAddressId;
    int deliveryAddressId;

    TravelListByDriverRequest(){
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserFirsSurname() {
        return userFirsSurname;
    }

    public void setUserFirsSurname(String userFirsSurname) {
        this.userFirsSurname = userFirsSurname;
    }

    public String getTravelDateDelivery() {
        return travelDateDelivery;
    }

    public void setTravelDateDelivery(String travelDateDelivery) {
        this.travelDateDelivery = travelDateDelivery;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getTravelStatus() {
        return travelStatus;
    }

    public void setTravelStatus(String travelStatus) {
        this.travelStatus = travelStatus;
    }

    public int getStartAddressId() {
        return startAddressId;
    }

    public void setStartAddressId(int startAddressId) {
        this.startAddressId = startAddressId;
    }

    public int getDeliveryAddressId() {
        return deliveryAddressId;
    }

    public void setDeliveryAddressId(int deliveryAddressId) {
        this.deliveryAddressId = deliveryAddressId;
    }
}
