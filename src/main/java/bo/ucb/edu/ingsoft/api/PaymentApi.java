package bo.ucb.edu.ingsoft.api;

import bo.ucb.edu.ingsoft.bl.PaymentBl;
import bo.ucb.edu.ingsoft.bl.TransactionBl;
import bo.ucb.edu.ingsoft.dto.BankAccountRequest;
import bo.ucb.edu.ingsoft.dto.BankTransactionRequest;
import bo.ucb.edu.ingsoft.dto.CardRequest;
import bo.ucb.edu.ingsoft.dto.PaymentRequest;
import bo.ucb.edu.ingsoft.modelo.Transaction;
import bo.ucb.edu.ingsoft.util.TransactionUtil;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

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
}
