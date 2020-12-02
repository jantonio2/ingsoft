package bo.ucb.edu.ingsoft.api;

import bo.ucb.edu.ingsoft.bl.PaymentBl;
import bo.ucb.edu.ingsoft.bl.TransactionBl;
import bo.ucb.edu.ingsoft.dto.*;
import bo.ucb.edu.ingsoft.modelo.Card;
import bo.ucb.edu.ingsoft.modelo.Driver;
import bo.ucb.edu.ingsoft.modelo.Transaction;
import bo.ucb.edu.ingsoft.modelo.User;
import bo.ucb.edu.ingsoft.util.TransactionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/payment")
public class PaymentApi {

    private PaymentBl paymentBl;
    private TransactionBl transactionBl;

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentApi.class);
    @Autowired
    public PaymentApi(PaymentBl paymentBl, TransactionBl transactionBl) {
        this.paymentBl = paymentBl;
        this.transactionBl =  transactionBl;
    }

//    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public Contact findById() {
//        return paymentBl.findContactById(0);
//    }
    @RequestMapping(path = "/bankaccount",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public BankAccountRequest createBankAccount(@RequestBody BankAccountRequest bankAccountRequest, HttpServletRequest request) {
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        BankAccountRequest createbankaccount=paymentBl.createBankAccount(bankAccountRequest,transaction);
        return createbankaccount;
    }

    @RequestMapping(path = "/transaction",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public BankTransactionRequest createBankTransaction(@RequestBody BankTransactionRequest bankTransactionRequest, HttpServletRequest request){
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        //LOGGER.error(transaction.getTxId().toString());
        BankTransactionRequest createbanktransaction=paymentBl.createBankTransaction(bankTransactionRequest,transaction);
        return createbanktransaction;
    }
    @RequestMapping(path = "/card",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public CardRequest createCard(@RequestBody CardRequest cardRequest, HttpServletRequest request){
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        //LOGGER.error(transaction.getTxId().toString());
        CardRequest createcard=paymentBl.createCard(cardRequest,transaction);
        return createcard;
    }
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public PaymentRequest createPayment(@RequestBody PaymentRequest paymentRequest, HttpServletRequest request){
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        //LOGGER.error(transaction.getTxId().toString());
        PaymentRequest createpayment=paymentBl.createPayment(paymentRequest,transaction);
        return createpayment;
    }

    @RequestMapping(path="/historypayment/{userId}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PaymentHistoryRequest> paymentHistory(@PathVariable String userId, HttpServletRequest request) {
        List<PaymentHistoryRequest> paymentList=paymentBl.historyPayment(Integer.parseInt(userId));
        LOGGER.error("hola");
        return paymentList;
    }
    @RequestMapping(path="/cardcollection/{userId}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CardCollectionRequest> cardCollection(@PathVariable String userId, HttpServletRequest request) {
        List<CardCollectionRequest> cardList=paymentBl.cardCollection(Integer.parseInt(userId));
        LOGGER.error("hola");
        return cardList;
    }
//    @RequestMapping(path="/history",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<DriverHistoryRequest> chatsList(@RequestBody Driver driver, HttpServletRequest request) {
//        List<DriverHistoryRequest> driverList=driverBl.driverHistory(driver);
//        return driverList;
//    }
}
