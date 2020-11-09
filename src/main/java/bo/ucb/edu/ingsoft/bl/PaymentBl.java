package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.api.ContactApi;
import bo.ucb.edu.ingsoft.dao.BankAccountDao;
import bo.ucb.edu.ingsoft.dao.BankTransactionDao;
import bo.ucb.edu.ingsoft.dao.PaymentDao;
import bo.ucb.edu.ingsoft.dao.TransactionDao;
import bo.ucb.edu.ingsoft.dto.Contact;
import bo.ucb.edu.ingsoft.modelo.*;
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

        Driver driver=new Driver();
        Administration administration=new Administration();
        bankAccount.setDriverId(driver.getDriverId());
        bankAccount.setAdministrationId(administration.getAdministrationId());

        bankAccount.setAccountNumber(bankAccount.getAccountNumber());
        bankAccount.setBank(bankAccount.getBank());
        bankAccount.setAccountType(bankAccount.getAccountType());
        bankAccount.setStatus(bankAccount.getStatus());

//        driver.getDriverId();

        bankAccount.setTransaction(transaction);
        Integer getLastId = transactionDao.getLastInsertId();
        return bankAccount;
    }

    public BankTransaction createBankTransaction(BankTransaction bankTransaction, Transaction transaction) {

        Integer getLastId=transactionDao.getLastInsertId();
        return bankTransaction;
    }


//    public Contact findContactById(Integer contactId) {
//        return  contactDao.findByContactId(contactId);
//    }
//    public BankAccount createBankAccount(BankAccount bankAccount,Transaction transaction){
//        bankAccount.set
//    }
}
