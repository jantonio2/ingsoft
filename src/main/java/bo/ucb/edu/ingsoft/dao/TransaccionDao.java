package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.modelo.Transaction;

public interface TransaccionDao {
    public Integer create(Transaction transaction);
    public Integer getLastInsertId();

}
