package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.dto.Transaction;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BankAccountDao {
    public Integer create(BankTransaction bankTransaction);

    public Integer getLastInsertId();
}
