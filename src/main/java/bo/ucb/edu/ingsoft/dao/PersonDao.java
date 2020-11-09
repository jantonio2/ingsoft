package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.modelo.Person;
import bo.ucb.edu.ingsoft.modelo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PersonDao {
    public void createPerson(Person person);

    public void updatePerson(Person person);

    Integer idPersonUser(User user);
}