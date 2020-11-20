package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.dto.UserHistoryRequest;
import bo.ucb.edu.ingsoft.modelo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
    public User findByUserId(Integer userId);
    public User getPersonId(Integer userId);
    public void createUser(User user);
    public void updateUser(User user);
    public List<UserHistoryRequest> userHistory(Integer userId);
}
