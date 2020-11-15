package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.modelo.Address;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AddressDao {

    public Address findById(Integer addressId);
    public void createAddress(Address address);
    public void updateAddress(Address address);
    public void createStartTravelAddress(Address address);

}
