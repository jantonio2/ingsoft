package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.dto.VehicleDriverRequest;
import bo.ucb.edu.ingsoft.dto.VehicleListRequest;
import bo.ucb.edu.ingsoft.modelo.Vehicle;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VehicleDao {
    public void createVehicle(Vehicle vehicle);
    public Vehicle findVehicleById(Integer vehicleId);
    public List<VehicleDriverRequest> vehicleDriver();
    //public List<VehicleDriverRequest>findVehiclesByType(String vehicleType);
    //public List<VehicleDriverRequest>findVehiclesByBrand(String vehicleBrand);

    public List<VehicleListRequest>vehicleListNotCompany();
    public List<VehicleListRequest>vehicleListWithCompany();

    public List<VehicleListRequest>vehicleListNotCompanyByType(String vehicleType);
    public List<VehicleListRequest>vehicleListWithCompanyByType(String vehicleType);

    public List<VehicleListRequest>vehicleListWithCompanyByCompany(String vehicleCompany);

    public List<VehicleListRequest>vehicleListNotCompanyByBrand(String vehicleBrand);
    public List<VehicleListRequest>vehicleListWithCompanyByBrand(String vehicleBrand);



    public List<VehicleListRequest>vehicleListNotCompanyByBrand();
    public List<VehicleListRequest>vehicleListWithCompanyByBrand();


    public void updateImage(Vehicle vehicle);

}
