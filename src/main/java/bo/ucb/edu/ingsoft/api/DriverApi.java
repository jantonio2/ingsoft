package bo.ucb.edu.ingsoft.api;

import bo.ucb.edu.ingsoft.bl.DriverBl;
import bo.ucb.edu.ingsoft.bl.TransactionBl;
import bo.ucb.edu.ingsoft.dto.DriverRequest;
import bo.ucb.edu.ingsoft.dto.SingleDriver;
import bo.ucb.edu.ingsoft.dto.SingleUser;
import bo.ucb.edu.ingsoft.dto.UserRequest;
import bo.ucb.edu.ingsoft.modelo.Transaction;
import bo.ucb.edu.ingsoft.util.TransactionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/v1/driver")
public class DriverApi {
    private DriverBl driverBl;
    private TransactionBl transactionBl;

    private static final Logger LOGGER = LoggerFactory.getLogger(DriverApi.class);

    @Autowired
    public DriverApi(DriverBl driverBl, TransactionBl transactionBl) {
        this.driverBl = driverBl;
        this.transactionBl = transactionBl;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public SingleDriver findById(HttpServletRequest request, @RequestParam Integer driverId) {
        //int userId=2;
        return driverBl.findDriverById(driverId);
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public DriverRequest createDriver(@RequestBody DriverRequest driverRequest, HttpServletRequest request) {
        // Creamos transaccion para la operaciónn
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        DriverRequest driverResponse = driverBl.createDriver(driverRequest, transaction);
        return driverResponse;
    }
}
