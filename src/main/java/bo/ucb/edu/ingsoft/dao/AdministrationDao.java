package bo.ucb.edu.ingsoft.dao;

//import bo.ucb.edu.ingsoft.dto.Transaction;
import bo.ucb.edu.ingsoft.modelo.Administration;
import bo.ucb.edu.ingsoft.modelo.BankAccount;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdministrationDao {
//    public Integer create(BankAccount bankAccount);

    public Integer getLastInsertId();

    public Integer createAdministrationAccount(Administration administration);
}
