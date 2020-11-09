package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.dao.*;
import bo.ucb.edu.ingsoft.dto.DriverRequest;
import bo.ucb.edu.ingsoft.dto.UserRequest;
import bo.ucb.edu.ingsoft.modelo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendaBl {
    private PersonDao personDao;
    private CompanyDao companyDao;
    private UserDao userDao;
    private DriverDao driverDao;
    private AddressDao addressDao;
    private BankAccountDao bankAccountDao;
    private TransactionDao transactionDao;

    @Autowired
    public AgendaBl(PersonDao personDao, CompanyDao companyDao, UserDao userDao,DriverDao driverDao, AddressDao addressDao, BankAccountDao bankAccountDao, TransactionDao transactionDao) {
        this.personDao = personDao;
        this.companyDao = companyDao;
        this.userDao = userDao;
        this.driverDao = driverDao;
        this.addressDao = addressDao;
        this.bankAccountDao = bankAccountDao;
        this.transactionDao = transactionDao;
    }

    //public Contact findContactById(Integer contactId) {
    //    return  contactDao.findByContactId(contactId);
    //}
    public UserRequest createUserRequest(UserRequest userRequest, Transaction transaction){
        Person person = new Person();
        User user = new User();
        Address address = new Address();

        person.setFirstName(userRequest.getPersonFirstName());
        person.setFirstSurname(userRequest.getPersonFirstSurname());
        person.setSecondSurname(userRequest.getPersonSecondSurname());
        person.setCi(userRequest.getPersonCi());
        person.setPhone(userRequest.getPersonPhone());
        person.setTransaction(transaction);

        personDao.createPerson(person);
        Integer getLastIdPerson = transactionDao.getLastInsertId();

        user.setPersonId(getLastIdPerson);
        user.setBirthDate(userRequest.getBirthDate());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setTransaction(transaction);

        userDao.createUser(user);
        Integer getLastId = transactionDao.getLastInsertId();

        address.setUserId(getLastId);
        address.setStreet(userRequest.getAddressStreet());
        address.setZone(userRequest.getAddressZone());
        address.setCity(userRequest.getAddressCity());
        address.setCountry(userRequest.getAddressCountry());
        address.setTransaction(transaction);

        addressDao.createAddress(address);
        userRequest.setUserId(getLastId);

        return userRequest;
    }
    public UserRequest updateUserRequest(UserRequest userRequest, Transaction transaction){
        Person person = new Person();
        User user = new User();
        Address address = new Address();

        user.setBirthDate(userRequest.getBirthDate());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setTransaction(transaction);
        user.setUserId(userRequest.getUserId());
        userDao.updateUser(user);

        Integer idPerson=personDao.idPersonUser(user);
        person.setPersonId(idPerson);
        person.setFirstName(userRequest.getPersonFirstName());
        person.setFirstSurname(userRequest.getPersonFirstSurname());
        person.setSecondSurname(userRequest.getPersonSecondSurname());
        person.setCi(userRequest.getPersonCi());
        person.setPhone(userRequest.getPersonPhone());
        person.setTransaction(transaction);
        personDao.updatePerson(person);

        address.setUserId(userRequest.getUserId());
        address.setStreet(userRequest.getAddressStreet());
        address.setZone(userRequest.getAddressZone());
        address.setCity(userRequest.getAddressCity());
        address.setCountry(userRequest.getAddressCountry());
        address.setTransaction(transaction);
        addressDao.updateAddress(address);
        return userRequest;
    }
    public DriverRequest updateDriverRequest(DriverRequest driverRequest, Transaction transaction){
        Person person = new Person();
        //User user = new User();
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
