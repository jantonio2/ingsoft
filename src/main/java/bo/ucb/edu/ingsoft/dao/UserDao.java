package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.modelo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    public User findByUserId(Integer userId);
    public void createUser(User user);
    public void updateUser(User user);
}
