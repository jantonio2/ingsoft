package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.dto.VehicleDriverRequest;
import bo.ucb.edu.ingsoft.modelo.Vehicle;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VehicleDao {
    public void createVehicle(Vehicle vehicle);
    public Vehicle findVehicleById(Integer vehicleId);
    public List<VehicleDriverRequest> vehicleDriver();
    public List<VehicleDriverRequest>findVehiclesByType(String vehicleType);
    public List<VehicleDriverRequest>findVehiclesByBrand(String vehicleBrand);
    public void updateImage(Vehicle vehicle);

}
