package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.modelo.Driver;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DriverDao {
    public Driver findByDriverId(Integer driverId);
    public Driver getPersonId(Integer driverId);
    public void createDriver(Driver driver);
    public void updateDriver(Driver driver);
}
