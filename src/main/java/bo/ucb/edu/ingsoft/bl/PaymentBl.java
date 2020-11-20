package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.api.PaymentApi;
import bo.ucb.edu.ingsoft.dao.*;
import bo.ucb.edu.ingsoft.dto.BankAccountRequest;
import bo.ucb.edu.ingsoft.dto.BankTransactionRequest;
import bo.ucb.edu.ingsoft.modelo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentBl {
//    private ContactDao contactDao;
    private TransactionDao transactionDao;
    private BankAccountDao bankAccountDao;
    private BankTransactionDao bankTransactionDao;
//    private PaymentDao paymentDao;
    private DriverDao driverDao;
    private  AdministrationDao administrationDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentApi.class);

    @Autowired
    public PaymentBl(BankAccountDao bankAccountDao,TransactionDao transactionDao, BankTransactionDao bankTransactionDao) {
//        this.contactDao = contactDao;
        this.transactionDao = transactionDao;
        this.bankAccountDao=bankAccountDao;
        this.bankTransactionDao=bankTransactionDao;
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

    public BankTransactionRequest createBankTransaction(BankTransactionRequest bankTransactionRequest, Transaction transaction) {

        BankTransaction bankTransaction=new BankTransaction();
        BankAccount bankAccount=new BankAccount();
        BankAccount bankAccount1=new BankAccount();
        LOGGER.error(transaction.getTxDate().toString());

//        bankAccount.setDriverId(bankTransactionRequest.getDriverBankAccountId());
//        bankAccount1.setAdministrationId(bankTransactionRequest.getAdministrationBankAccountId());
        bankTransaction.setDriverBankAccountId(bankTransactionRequest.getDriverBankAccountId());
        bankTransaction.setAdministrationBankAccountId(bankTransactionRequest.getAdministrationBankAccountId());
//        bankTransaction.setBankTransactionId(getLastId);
        bankTransaction.setAmount(bankTransactionRequest.getAmount());
        bankTransaction.setTransactionDate(bankTransactionRequest.getTransactionDate());
        bankTransaction.setStatus(bankTransactionRequest.getStatus());
//        Integer getLastId = transactionDao.getLastInsertId();
        bankTransaction.setTransaction(transaction);

//        Integer getLastIdTransaction=transactionDao.getLastInsertId();
//        bankTransaction.setBankTransactionId(getLastIdTransaction);
        LOGGER.error(bankTransaction.getDriverBankAccountId().toString());
        LOGGER.error(bankTransaction.getAdministrationBankAccountId().toString());
        LOGGER.error(bankTransaction.getAmount().toString());
        LOGGER.error(bankTransaction.getTransactionDate().toString());
        LOGGER.error(bankTransaction.getStatus().toString());
        LOGGER.error(bankTransaction.getTransaction().getTxHost().toString());
        LOGGER.error(bankTransaction.getTransaction().getTxId().toString());
        LOGGER.error(bankTransaction.getTransaction().getTxDate().toString());
        LOGGER.error(bankTransaction.getTransaction().getTxUserId().toString());

        bankTransactionDao.createBankTransaction(bankTransaction);


        return bankTransactionRequest;
    }


//    public Contact findContactById(Integer contactId) {
//        return  contactDao.findByContactId(contactId);
//    }
//    public BankAccount createBankAccount(BankAccount bankAccount,Transaction transaction){
//        bankAccount.set
//    }
}
