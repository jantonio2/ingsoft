package bo.ucb.edu.ingsoft.dto;

public class VehicleSearchRequest {
    int vehicleId;
    String vehicleType;
    String vehicleBrand;
    String vehicleModel;
    String vehiclePicture;
    String personFirstName;
    String personFirstSurname;
    Double vehicleCapacity;
    Double vehiclePrice;

    public VehicleSearchRequest(){

    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleBrand() {
        return vehicleBrand;
    }

    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getVehiclePicture() {
        return vehiclePicture;
    }

    public void setVehiclePicture(String vehiclePicture) {
        this.vehiclePicture = vehiclePicture;
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

    public Double getVehicleCapacity() {
        return vehicleCapacity;
    }

    public void setVehicleCapacity(Double vehicleCapacity) {
        this.vehicleCapacity = vehicleCapacity;
    }

    public Double getVehiclePrice() {
        return vehiclePrice;
    }

    public void setVehiclePrice(Double vehiclePrice) {
        this.vehiclePrice = vehiclePrice;
    }

    @Override
    public String toString() {
        return "VehicleSearchRequest{" +
                "VehicleId=" + vehicleId +
                ", vehicleType='" + vehicleType + '\'' +
                ", vehicleBrand='" + vehicleBrand + '\'' +
                ", vehicleModel='" + vehicleModel + '\'' +
                ", vehiclePicture='" + vehiclePicture + '\'' +
                ", personFirstName='" + personFirstName + '\'' +
                ", personFirstSurname='" + personFirstSurname + '\'' +
                ", vehicleCapacity=" + vehicleCapacity +
                ", vehiclePrice=" + vehiclePrice +
                '}';
    }
}
