package bo.ucb.edu.ingsoft.dao;

//import bo.ucb.edu.ingsoft.dto.Transaction;
import bo.ucb.edu.ingsoft.modelo.BankAccount;
import bo.ucb.edu.ingsoft.modelo.BankTransaction;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BankTransactionDao {
    public Integer createBankTransaction(BankTransaction bankTransaction);

    public Integer getLastInsertId();
}
