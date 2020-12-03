package bo.ucb.edu.ingsoft.api;


import bo.ucb.edu.ingsoft.bl.AdministrationBl;
import bo.ucb.edu.ingsoft.bl.CompanyBl;
import bo.ucb.edu.ingsoft.bl.TransactionBl;
import bo.ucb.edu.ingsoft.dto.AdministrationRequest;
import bo.ucb.edu.ingsoft.dto.CompanyData;
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
@RequestMapping(value = "/v1/company")
public class CompanyApi {
    private CompanyBl companyBl;
    private TransactionBl transactionBl;

    private static final Logger LOGGER = LoggerFactory.getLogger(AdministrationApi.class);

    @Autowired
    public CompanyApi(CompanyBl companyBl, TransactionBl transactionBl){
        this.companyBl = companyBl;
        this.transactionBl = transactionBl;
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public CompanyData createCompany(@RequestBody CompanyData companyData, HttpServletRequest request) {
        // Creamos transaccion para la operaciónn
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        CompanyData compResponse = companyBl.createCompany(companyData, transaction);
        return compResponse;
    }
}
