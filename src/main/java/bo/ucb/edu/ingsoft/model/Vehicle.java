package bo.ucb.edu.ingsoft.model;

public class Vehicle {
    private Integer vehicleId;
    private Integer driverId;
    private String licensePlate;
    private Double capacity;
    private String vehicleType;
    private Double price;
    private String vehicleStatus;
    private String pictures;
    private String brand;
    private String vehicleModel;
    private String status;
    private Transaction transaction;

    public Vehicle(){
        transaction = new Transaction();
    }
    public Vehicle(Transaction transaction){
        this.transaction = transaction;
    }

    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Double getCapacity() {
        return capacity;
    }

    public void setCapacity(Double capacity) {
        this.capacity = capacity;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(String vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }

    public String getPictures() {
        return pictures;
    }

    public void setPictures(String pictures) {
        this.pictures = pictures;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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
        return "Vehicle{" +
                "vehicleId=" + vehicleId +
                ", driverId=" + driverId +
                ", licensePlate='" + licensePlate + '\'' +
                ", capacity=" + capacity +
                ", vehicleType='" + vehicleType + '\'' +
                ", price=" + price +
                ", vehicleStatus='" + vehicleStatus + '\'' +
                ", pictures='" + pictures + '\'' +
                ", brand='" + brand + '\'' +
                ", vehicleModel='" + vehicleModel + '\'' +
                ", status='" + status + '\'' +
                ", transaction=" + transaction +
                '}';
    }
}
