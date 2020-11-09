package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.api.ContactApi;
import bo.ucb.edu.ingsoft.dao.BankAccountDao;
import bo.ucb.edu.ingsoft.dao.BankTransactionDao;
import bo.ucb.edu.ingsoft.dao.PaymentDao;
import bo.ucb.edu.ingsoft.dao.TransactionDao;
import bo.ucb.edu.ingsoft.dto.Contact;
import bo.ucb.edu.ingsoft.modelo.BankAccount;
import bo.ucb.edu.ingsoft.modelo.Driver;
import bo.ucb.edu.ingsoft.modelo.Transaction;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentBl {
//    private ContactDao contactDao;
    private TransactionDao transactionDao;
    private BankAccountDao bankAccountDao;
    private BankTransactionDao bankTransactionDao;
    private PaymentDao paymentDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(ContactApi.class);

    @Autowired
    public PaymentBl(BankTransactionDao bankTransactionDao,BankAccountDao bankAccountDao, PaymentDao paymentDao, TransactionDao transactionDao) {
//        this.contactDao = contactDao;
        this.transactionDao = transactionDao;
        this.bankAccountDao=bankAccountDao;
        this.bankTransactionDao=bankTransactionDao;
        this.paymentDao=paymentDao;
    }

    public BankAccount createBankAccount(BankAccount bankAccount, Transaction transaction) {
        bankAccount.setAccountNumber(bankAccount.getAccountNumber());
        bankAccount.setBank(bankAccount.getBank());
        bankAccount.setAccountType(bankAccount.getAccountType());
        bankAccount.setStatus(bankAccount.getStatus());
        Driver driver=new Driver();

        Integer getLastId = bankAccountDao.getLastInsertId();
        return bankAccount;
    }

//    public Contact findContactById(Integer contactId) {
//        return  contactDao.findByContactId(contactId);
//    }
//    public BankAccount createBankAccount(BankAccount bankAccount,Transaction transaction){
//        bankAccount.set
//    }
}
