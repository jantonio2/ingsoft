package bo.ucb.edu.ingsoft.api;

import bo.ucb.edu.ingsoft.bl.AgendaBl;
import bo.ucb.edu.ingsoft.bl.DriverBl;
import bo.ucb.edu.ingsoft.bl.TransactionBl;
import bo.ucb.edu.ingsoft.dto.DriverRequest;
import bo.ucb.edu.ingsoft.modelo.Transaction;
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
@RequestMapping(value = "/transveloz/driver")
public class DriverApi {

    private DriverBl driverBl;
    private TransactionBl transactionBl;

    private static final Logger LOGGER = LoggerFactory.getLogger(bo.ucb.edu.ingsoft.api.DriverApi.class);

    @Autowired
    public DriverApi(DriverBl driverBl, TransactionBl transactionBl) {
        this.driverBl = driverBl;
        this.transactionBl =  transactionBl;
    }

    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public DriverRequest updateContact(@RequestBody DriverRequest driverRequest, HttpServletRequest request) {
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        DriverRequest driverResponse = driverBl.updateDriverRequest(driverRequest, transaction);
        return driverResponse;
    }

}
