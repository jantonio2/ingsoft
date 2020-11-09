package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.modelo.BankAccount;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BankAccountDao {

    public void updateBankAccountDriver(BankAccount bankAccount);

}
