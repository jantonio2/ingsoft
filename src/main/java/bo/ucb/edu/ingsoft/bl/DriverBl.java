package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.api.DriverApi;
import bo.ucb.edu.ingsoft.dao.AddressDao;
import bo.ucb.edu.ingsoft.dao.PersonDao;
import bo.ucb.edu.ingsoft.dao.TransactionDao;
import bo.ucb.edu.ingsoft.dao.DriverDao;
import bo.ucb.edu.ingsoft.dto.DriverRequest;
import bo.ucb.edu.ingsoft.dto.SingleDriver;
import bo.ucb.edu.ingsoft.modelo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverBl {
    private DriverDao driverDao;
    private TransactionDao transactionDao;
    private AddressDao addressDao;
    private PersonDao personDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(DriverApi.class);

    @Autowired
    public DriverBl(DriverDao driverDao, TransactionDao transactionDao, AddressDao addressDao, PersonDao personDao) {
        this.driverDao = driverDao;
        this.transactionDao = transactionDao;
        this.addressDao = addressDao;
        this.personDao = personDao;
    }

    public SingleDriver findDriverById(Integer driverId) {
        Driver driver = driverDao.findByDriverId(driverId);
        SingleDriver singleDriverResponse = new SingleDriver();
        LOGGER.error(driver.getEmail());
        Person person = personDao.findByPersonId(driver.getPersonId());
        Address address = addressDao.findByDriverId(driverId);
        LOGGER.error(person.getFirstName());
        LOGGER.error(address.getStreet());

        singleDriverResponse.setCi(person.getCi());
        singleDriverResponse.setFirstName(person.getFirstName());
        singleDriverResponse.setFirstSurname(person.getFirstSurname());
        singleDriverResponse.setSecondSurname(person.getSecondSurname());
        singleDriverResponse.setPhone(person.getPhone());

        singleDriverResponse.setBirthDate(driver.getBirthDate());
        singleDriverResponse.setEmail(driver.getEmail());

        singleDriverResponse.setNumber(address.getNumber());
        singleDriverResponse.setStreet(address.getStreet());
        singleDriverResponse.setZone(address.getZone());
        singleDriverResponse.setCity(address.getCity());
        singleDriverResponse.setCountry(address.getCountry());
        return  singleDriverResponse;
    }

    public DriverRequest createDriver(DriverRequest driverRequest, Transaction transaction) {
        Driver driver = new Driver();
        Person person = new Person();
        Address address = new Address();
        LOGGER.error(driverRequest.getFirstName());

        person.setFirstName(driverRequest.getFirstName());
        person.setFirstSurname(driverRequest.getFirstSurname());
        person.setSecondSurname(driverRequest.getSecondSurname());
        person.setCi(driverRequest.getCi());
        person.setPhone(driverRequest.getPhone());
        person.setTransaction(transaction);
        personDao.createPerson(person);
        Integer getLastIdPerson = transactionDao.getLastInsertId();
        person.setPersonId(getLastIdPerson);

        driver.setPersonId(getLastIdPerson);
        //LOGGER.error(user.getPersonId().toString());
        driver.setBirthDate(driverRequest.getBirthDate());
        driver.setEmail(driverRequest.getEmail());
        driver.setPassword(driverRequest.getPassword());
        driver.setTransaction(transaction);
        driverDao.createDriver(driver);
        Integer getLastIdDriver = transactionDao.getLastInsertId();

        address.setDriverId(getLastIdDriver);
        address.setNumber(driverRequest.getNumber());
        address.setStreet(driverRequest.getStreet());
        address.setZone(driverRequest.getZone());
        address.setCity(driverRequest.getCity());
        address.setCountry(driverRequest.getCountry());
        address.setTransaction(transaction);
        addressDao.createAddress(address);
        return driverRequest;
    }

    public DriverRequest updateDriver(DriverRequest driverRequest, Transaction transaction){
        Driver driver = new Driver();
        Person person = new Person();
        Address address = new Address();

        driver.setDriverId(driverRequest.getDriverId());
        driver.setEmail(driverRequest.getEmail());
        driver.setBirthDate(driverRequest.getBirthDate());
        driver.setPassword(driverRequest.getPassword());
        driver.setTransaction(transaction);
        LOGGER.error(transaction.getTxId().toString());
        driverDao.updateDriver(driver);

        Driver driver2 = driverDao.getPersonId(driverRequest.getDriverId());
        person.setPersonId(driver2.getPersonId());
        person.setFirstName(driverRequest.getFirstName());
        person.setFirstSurname(driverRequest.getFirstSurname());
        person.setSecondSurname(driverRequest.getSecondSurname());
        person.setCi(driverRequest.getCi());
        person.setPhone(driverRequest.getPhone());
        person.setTransaction(transaction);
        personDao.updatePerson(person);

        address.setUserId(driverRequest.getDriverId());
        address.setNumber(driverRequest.getNumber());
        address.setStreet(driverRequest.getStreet());
        address.setZone(driverRequest.getZone());
        address.setCity(driverRequest.getCity());
        address.setCountry(driverRequest.getCountry());
        address.setTransaction(transaction);
        addressDao.updateAddressDriver(address);

        return  driverRequest;
    }
}
