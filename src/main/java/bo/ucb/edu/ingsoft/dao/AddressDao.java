package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.modelo.Address;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AddressDao {

    public Address findByUserId(Integer addressId);
    public Address findByDriverId(Integer driverId);
    public void createAddress(Address address);
    public void updateAddressUser(Address address);
    public void updateAddressDriver(Address address);
    public void createStartTravelAddress(Address address);

}
