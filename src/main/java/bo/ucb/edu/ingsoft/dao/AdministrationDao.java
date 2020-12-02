package bo.ucb.edu.ingsoft.dao;

//import bo.ucb.edu.ingsoft.dto.Transaction;
import bo.ucb.edu.ingsoft.dto.DriverContactRequest;
import bo.ucb.edu.ingsoft.dto.LogInRequest;
import bo.ucb.edu.ingsoft.modelo.Administration;
import bo.ucb.edu.ingsoft.modelo.BankAccount;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdministrationDao {
//    public Integer create(BankAccount bankAccount);

    //public Integer getLastInsertId();

    //public Integer createAdministrationAccount(Administration administration);
    public void createAdministration(Administration administration);
    public List<LogInRequest> administrationLogIn();
}
