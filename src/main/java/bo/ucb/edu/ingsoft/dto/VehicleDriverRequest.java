package bo.ucb.edu.ingsoft.dto;

public class VehicleDriverRequest {
    Integer vehicleId;
    String personFirstName;
    String personFirstSurname;
    String vehicleLicensePlate;
    Double vehicleCapacity;
    String vehicleType;
    Double vehiclePrice;
    String vehicleStatus;
    String vehicleBrand;
    String vehicleModel;
    String driverCompany;


    public VehicleDriverRequest(){
    }


    public Integer getVehicleId() {
        return vehicleId;
    }

    public String getDriverCompany() {
        return driverCompany;
    }

    public void setDriverCompany(String driverCompany) {
        this.driverCompany = driverCompany;
    }
    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(String vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
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

    public String getVehicleLicensePlate() {
        return vehicleLicensePlate;
    }

    public void setVehicleLicensePlate(String vehicleLicensePlate) {
        this.vehicleLicensePlate = vehicleLicensePlate;
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
}
