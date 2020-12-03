package bo.ucb.edu.ingsoft.dao;

//import bo.ucb.edu.ingsoft.dto.Transaction;
import bo.ucb.edu.ingsoft.dto.CardCollectionRequest;
import bo.ucb.edu.ingsoft.dto.PaymentHistoryRequest;
import bo.ucb.edu.ingsoft.modelo.BankTransaction;
import bo.ucb.edu.ingsoft.modelo.Card;
import bo.ucb.edu.ingsoft.modelo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CardDao {
    public Integer createCard(Card card);

    public Integer getLastInsertId();
    public List<CardCollectionRequest> cardCollectionId(Integer userId);
}
