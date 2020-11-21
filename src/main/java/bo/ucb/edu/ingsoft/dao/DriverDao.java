package bo.ucb.edu.ingsoft.dao;


import bo.ucb.edu.ingsoft.dto.DriverContactRequest;
import bo.ucb.edu.ingsoft.dto.DriverHistoryRequest;
import bo.ucb.edu.ingsoft.modelo.Driver;
import bo.ucb.edu.ingsoft.modelo.User;
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
    public void updateImage(Driver driver);
}
