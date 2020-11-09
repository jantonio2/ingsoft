package bo.ucb.edu.ingsoft.dao;

//import bo.ucb.edu.ingsoft.dto.Transaction;
import bo.ucb.edu.ingsoft.modelo.BankAccount;
import bo.ucb.edu.ingsoft.modelo.Driver;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DriverDao {
//    public Integer create(BankAccount bankAccount);

    public Integer getLastInsertId();

    public Integer createDriver(Driver driver);
}
