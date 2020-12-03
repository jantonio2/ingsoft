package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.api.AdministrationApi;
import bo.ucb.edu.ingsoft.dao.*;
import bo.ucb.edu.ingsoft.dto.AdministrationRequest;
import bo.ucb.edu.ingsoft.dto.CompanyData;
import bo.ucb.edu.ingsoft.dto.LogInRequest;
import bo.ucb.edu.ingsoft.modelo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CompanyBl {
    private CompanyDao companyDao;
    private TransactionDao transactionDao;
    private AddressDao addressDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(AdministrationApi.class);

    @Autowired
    public CompanyBl(CompanyDao companyDao, TransactionDao transactionDao, AddressDao addressDao){
        this.companyDao = companyDao;
        this.transactionDao = transactionDao;
        this.addressDao = addressDao;
    }

    public CompanyData createCompany(CompanyData companyData, Transaction transaction){
        Address address = new Address();
        Company company = new Company();
        LOGGER.error(company.getName());

        address.setNumber(companyData.getNumber());
        address.setStreet(companyData.getStreet());
        address.setZone(companyData.getZone());
        address.setCity(companyData.getCity());
        address.setCountry(companyData.getCountry());
        address.setTransaction(transaction);
        addressDao.createAddress(address);
        Integer getLastIdAddress = transactionDao.getLastInsertId();
        address.setAddressId(getLastIdAddress);

        company.setAddressId(getLastIdAddress);
        company.setEmail(companyData.getEmail());
        company.setName(companyData.getName());
        company.setPhone(companyData.getPhone());
        company.setTransaction(transaction);
        companyDao.createCompany(company);

        return companyData;
    }

//    public List<LogInRequest> administrationLogIn() {
//        List<LogInRequest> list = administrationDao.administrationLogIn();
//        return list;
//    }
}
