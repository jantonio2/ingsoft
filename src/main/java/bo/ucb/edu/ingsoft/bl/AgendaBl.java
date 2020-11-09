package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.api.ContactApi;
import bo.ucb.edu.ingsoft.dao.ContactDao;
import bo.ucb.edu.ingsoft.dao.TransactionDao;
import bo.ucb.edu.ingsoft.dto.Contact;
import bo.ucb.edu.ingsoft.modelo.BankAccount;
import bo.ucb.edu.ingsoft.modelo.Transaction;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendaBl {
    private ContactDao contactDao;
    private TransactionDao transactionDao;
//    private BankAccountDao bankAccountDao;
//    private BankTransactionDao bankTransactionDao;
//    private PaymentDao paymentDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(ContactApi.class);

    @Autowired
    public AgendaBl(ContactDao contactDao,TransactionDao transactionDao) {
        this.contactDao = contactDao;
        this.transactionDao = transactionDao;
    }

    public Contact findContactById(Integer contactId) {
        return  contactDao.findByContactId(contactId);
    }
//    public BankAccount createBankAccount(BankAccount bankAccount, Transaction transaction){
//        bankAccount.set
//    }
}
