package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.model.Address;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AddressDao {
    public Address findByUserId(Integer userId);
    public Address findByDriverId(Integer driverId);
    public void createAddress(Address address);
    public void updateAddressUser(Address address);
    public void updateAddressDriver(Address address);
}
