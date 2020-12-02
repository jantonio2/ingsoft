package bo.ucb.edu.ingsoft.api;

import bo.ucb.edu.ingsoft.bl.AdministrationBl;
import bo.ucb.edu.ingsoft.bl.TransactionBl;
import bo.ucb.edu.ingsoft.dto.AdministrationRequest;
import bo.ucb.edu.ingsoft.dto.CompanyRequest;
import bo.ucb.edu.ingsoft.dto.LogInRequest;
import bo.ucb.edu.ingsoft.modelo.Transaction;
import bo.ucb.edu.ingsoft.util.TransactionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/administration")
public class AdministrationApi {
    private AdministrationBl administrationBl;
    private TransactionBl transactionBl;

    private static final Logger LOGGER = LoggerFactory.getLogger(AdministrationApi.class);

    @Autowired
    public AdministrationApi(AdministrationBl administrationBl, TransactionBl transactionBl){
        this.administrationBl = administrationBl;
        this.transactionBl = transactionBl;
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public AdministrationRequest createAdministration(@RequestBody AdministrationRequest administrationRequest, HttpServletRequest request) {
        // Creamos transaccion para la operaciónn
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        AdministrationRequest admResponse = administrationBl.createAdministration(administrationRequest, transaction);
        return admResponse;
    }

    @RequestMapping(path="/sesion",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<LogInRequest> logList(HttpServletRequest request) {
        List<LogInRequest> log=administrationBl.administrationLogIn();
        return log;
    }
}
