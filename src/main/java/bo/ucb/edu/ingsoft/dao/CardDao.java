package bo.ucb.edu.ingsoft.dao;

//import bo.ucb.edu.ingsoft.dto.Transaction;
import bo.ucb.edu.ingsoft.modelo.BankTransaction;
import bo.ucb.edu.ingsoft.modelo.Card;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CardDao {
    public Integer createCard(Card card);

    public Integer getLastInsertId();
}
