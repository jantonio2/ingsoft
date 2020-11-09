package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.dao.*;
import bo.ucb.edu.ingsoft.dto.DriverRequest;
import bo.ucb.edu.ingsoft.dto.UserRequest;
import bo.ucb.edu.ingsoft.modelo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverBl {
    private PersonDao personDao;
    private CompanyDao companyDao;
    private DriverDao driverDao;
    private AddressDao addressDao;
    private BankAccountDao bankAccountDao;
    private TransactionDao transactionDao;

    @Autowired
    public DriverBl(PersonDao personDao, CompanyDao companyDao, DriverDao driverDao, AddressDao addressDao, BankAccountDao bankAccountDao, TransactionDao transactionDao) {
        this.personDao = personDao;
        this.companyDao = companyDao;
        this.driverDao = driverDao;
        this.addressDao = addressDao;
        this.bankAccountDao = bankAccountDao;
        this.transactionDao = transactionDao;
    }


    public DriverRequest updateDriverRequest(DriverRequest driverRequest, Transaction transaction){

        Person person = new Person();
        Company company = new Company();
        Driver driver = new Driver();
        Address address = new Address();
        BankAccount bankAccount = new BankAccount();

        driver.setBirthDate(driverRequest.getBirthDateDriver());
        driver.setEmail(driverRequest.getEmailDriver());
        driver.setPassword(driverRequest.getPasswordDriver());
        driver.setTransaction(transaction);
        driver.setDriverId(driverRequest.getDriverId());
        driverDao.updateDriver(driver);

        Integer getDriverByPersonId=personDao.personIdByDriver(driver);
        person.setPersonId(getDriverByPersonId);
        person.setFirstName(driverRequest.getPersonDFirstName());
        person.setFirstSurname(driverRequest.getPersonDFirstSurname());
        person.setSecondSurname(driverRequest.getPersonDSecondSurname());
        person.setCi(driverRequest.getPersonDCi());
        person.setPhone(driverRequest.getPersonDPhone());
        person.setTransaction(transaction);
        personDao.updatePersonDriver(person);

        Integer getDriverByCompanyId=companyDao.companyIdByDriver(driver);
        company.setCompanyId(getDriverByCompanyId);
        company.setName(driverRequest.getCompanyName());
        company.setEmail(driverRequest.getCompanyEmail());
        company.setPhone(driverRequest.getCompanyPhone());
        company.setTransaction(transaction);
        companyDao.updateCompanyDriver(company);

        address.setDriverId(driverRequest.getDriverId());
        address.setStreet(driverRequest.getAddressDStreet());
        address.setZone(driverRequest.getAddressDZone());
        address.setCity(driverRequest.getAddressDCity());
        address.setCountry(driverRequest.getAddressDCountry());
        address.setTransaction(transaction);
        addressDao.updateAddressDriver(address);

        bankAccount.setDriverId(driverRequest.getDriverId());
        bankAccount.setAccountNumber(driverRequest.getBankAccountNumber());
        bankAccount.setBank(driverRequest.getBankAccountBank());
        bankAccount.setAccountType(driverRequest.getBankAccountType());
        bankAccount.setTransaction(transaction);
        bankAccountDao.updateBankAccountDriver(bankAccount);

        return driverRequest;
    }
}
