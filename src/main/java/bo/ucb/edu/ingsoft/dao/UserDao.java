package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.dto.Contact;
import bo.ucb.edu.ingsoft.modelo.Address;
import bo.ucb.edu.ingsoft.modelo.Person;
import bo.ucb.edu.ingsoft.modelo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

    public void createPerson(Person person);
    public void createAddress(Address address);
    public void createUser(User user);

}
