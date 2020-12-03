package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.dto.TravelListByDriverRequest;
import bo.ucb.edu.ingsoft.modelo.Travel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TravelDao {
    public void createTravel(Travel travel);
    public void createDeliveryTravelAddress(Travel travel);
    public List<TravelListByDriverRequest> findTravelByIdDriver(int driverId);

}
