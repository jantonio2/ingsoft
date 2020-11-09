package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.modelo.Address;
import bo.ucb.edu.ingsoft.modelo.Person;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AddressDao {
    public Address findByUserId(Integer userId);
    public void createAddress(Address address);
}
