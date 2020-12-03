package bo.ucb.edu.ingsoft.dao;


import bo.ucb.edu.ingsoft.dto.*;
import bo.ucb.edu.ingsoft.modelo.Driver;
import bo.ucb.edu.ingsoft.modelo.Person;
import bo.ucb.edu.ingsoft.modelo.User;
import bo.ucb.edu.ingsoft.modelo.Vehicle;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DriverDao {
    public Driver findByDriverId(Integer driverId);
    public Driver getPersonId(Integer driverId);
    public void createDriver(Driver driver);
    public void updateDriver(Driver driver);
    public List<DriverHistoryRequest> driverHistory(Driver driver);
    public List<DriverContactRequest> driverContactCompany();
    public List<DriverContactRequest> driverContactNull();
    public List<CompanyRequest> getCompanies();
    public List<DriverVehicleRequest> driverVehicle(Driver driver);
    public void updateImage(Driver driver);
    public void deleteDriver(Driver driver);
    public List<LogInRequest> driverLogIn();

    public int findDriverByLicensePlate(String licensePlate);
    public int findDriverByCi(String ci);
}
