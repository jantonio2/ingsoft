package bo.ucb.edu.ingsoft.dao;

//import bo.ucb.edu.ingsoft.dto.Transaction;
import bo.ucb.edu.ingsoft.dto.PaymentHistoryRequest;
import bo.ucb.edu.ingsoft.modelo.BankAccount;
import bo.ucb.edu.ingsoft.modelo.Driver;
import bo.ucb.edu.ingsoft.modelo.Payment;
import bo.ucb.edu.ingsoft.modelo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaymentDao {
    public Integer createPayment(Payment payment);
    public Payment findByUserId(Integer userId);
    public List<PaymentHistoryRequest> paymentHistoryId(Integer userId);
}
