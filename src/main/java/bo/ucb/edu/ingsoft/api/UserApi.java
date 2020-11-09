package bo.ucb.edu.ingsoft.api;

import bo.ucb.edu.ingsoft.bl.AgendaBl;
import bo.ucb.edu.ingsoft.bl.TransactionBl;
import bo.ucb.edu.ingsoft.dto.UserRequest;
import bo.ucb.edu.ingsoft.modelo.Transaction;
import bo.ucb.edu.ingsoft.modelo.User;
import bo.ucb.edu.ingsoft.util.TransactionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/transveloz/user")
public class UserApi {
    private AgendaBl agendaBl;
    private TransactionBl transactionBl;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserApi.class);

    @Autowired
    public UserApi(AgendaBl agendaBl, TransactionBl transactionBl) {
        this.agendaBl = agendaBl;
        this.transactionBl =  transactionBl;
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserRequest createContact(@RequestBody UserRequest userRequest, HttpServletRequest request) {
        // Creamos transaccion para la operación.
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        UserRequest userResponse = agendaBl.createUserRequest(userRequest, transaction);
        return userResponse;
    }

    //@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    //public Contact findById(HttpServletRequest request) {
    //    return agendaBl.findContactById(0);
    //}




}
