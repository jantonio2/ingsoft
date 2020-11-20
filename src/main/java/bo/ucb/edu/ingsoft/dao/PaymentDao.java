package bo.ucb.edu.ingsoft.dao;

//import bo.ucb.edu.ingsoft.dto.Transaction;
import bo.ucb.edu.ingsoft.modelo.BankAccount;
import bo.ucb.edu.ingsoft.modelo.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentDao {
    public Integer createPayment(Payment payment);

    public Integer getPayment(Payment payment);
}
