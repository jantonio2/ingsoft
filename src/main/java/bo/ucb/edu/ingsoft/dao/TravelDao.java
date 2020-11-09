package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.modelo.Travel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TravelDao {
    public void createTravel(Travel travel);
    public void createDeliveryTravelAddress(Travel travel);

}
