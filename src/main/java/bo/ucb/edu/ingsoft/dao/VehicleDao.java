package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.modelo.Vehicle;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VehicleDao {
    public Vehicle findVehicleById(Integer vehicleId);
}
