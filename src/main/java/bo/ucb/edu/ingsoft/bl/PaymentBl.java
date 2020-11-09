package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.api.ContactApi;
import bo.ucb.edu.ingsoft.dao.*;
import bo.ucb.edu.ingsoft.dto.BankAccountRequest;
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
//    private BankTransactionDao bankTransactionDao;
//    private PaymentDao paymentDao;
    private DriverDao driverDao;
    private  AdministrationDao administrationDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(ContactApi.class);

    @Autowired
    public PaymentBl(BankAccountDao bankAccountDao,DriverDao driverDao, AdministrationDao administrationDao,TransactionDao transactionDao) {
//        this.contactDao = contactDao;
        this.transactionDao = transactionDao;
        this.bankAccountDao=bankAccountDao;
//        this.bankTransactionDao=bankTransactionDao;
//        this.paymentDao=paymentDao;
//        this.driverDao=driverDao;
//        this.administrationDao=administrationDao;
    }

    public BankAccountRequest createBankAccount(BankAccountRequest bankAccountRequest, Transaction transaction) {

        Driver driver=new Driver();
        Administration administration=new Administration();
        BankAccount bankAccount=new BankAccount();

//        bankAccount.setBankAccountId(bankAccountRequest.getBankAccountId());
        bankAccount.setAccountNumber(bankAccountRequest.getAccountNumber());
        bankAccount.setBank(bankAccountRequest.getBank());
        bankAccount.setAccountType(bankAccountRequest.getAccountType());
        bankAccount.setStatus(bankAccountRequest.getStatus());


//        driver.setDriverId();
//        Integer getLastIdDriver=transactionDao.getLastInsertId();
//        driverDao.createDriver(driver);

//        Integer getLastIdAdministrator=transactionDao.getLastInsertId();
//        administrationDao.createAdministrationAccount(administration);
        bankAccount.setDriverId(bankAccountRequest.getDriverId());
        bankAccount.setAdministrationId(bankAccountRequest.getAdministrationId());
//        driver.getDriverId();

        bankAccount.setTransaction(transaction);
        Integer getLastId = transactionDao.getLastInsertId();
        bankAccount.setBankAccountId(getLastId);
        bankAccountDao.createBankAccount(bankAccount);
//        administrationDao.createAdministrationAccount(administration);
        return bankAccountRequest;
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
