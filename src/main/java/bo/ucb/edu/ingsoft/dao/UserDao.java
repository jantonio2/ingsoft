package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    public User findByUserId(Integer userId);
    public User getPersonId(Integer userId);
    public void createUser(User user);
    public void updateUser(User user);
}
