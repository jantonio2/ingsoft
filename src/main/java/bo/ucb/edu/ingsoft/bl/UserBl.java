package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.api.UserApi;
import bo.ucb.edu.ingsoft.dao.AddressDao;
import bo.ucb.edu.ingsoft.dao.PersonDao;
import bo.ucb.edu.ingsoft.dao.TransactionDao;
import bo.ucb.edu.ingsoft.dao.UserDao;
import bo.ucb.edu.ingsoft.dto.UserRequest;
import bo.ucb.edu.ingsoft.modelo.Address;
import bo.ucb.edu.ingsoft.modelo.Person;
import bo.ucb.edu.ingsoft.modelo.Transaction;
import bo.ucb.edu.ingsoft.modelo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBl {
    private UserDao userDao;
    private TransactionDao transactionDao;
    private AddressDao addressDao;
    private PersonDao personDao;

    @Autowired
    public UserBl(UserDao userDao, TransactionDao transactionDao, AddressDao addressDao, PersonDao personDao) {
        this.userDao = userDao;
        this.transactionDao = transactionDao;
        this.addressDao = addressDao;
        this.personDao = personDao;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(UserApi.class);


//    public Contact findContactById(Integer contactId) {
//        return  contactDao.findByContactId(contactId);
//    }

    public UserRequest createUser(UserRequest userRequest, Transaction transaction) {
        User user = new User();
        Person person = new Person();
        Address address = new Address();
        LOGGER.error(userRequest.getFirstName());
        person.setFirstName(userRequest.getFirstName());
        person.setFirstSurname(userRequest.getFirstSurname());
        person.setSecondSurname(userRequest.getSecondSurname());
        person.setCi(userRequest.getCi());
        person.setPhone(userRequest.getPhone());
        person.setTransaction(transaction);
        personDao.createPerson(person);
        Integer getLastIdPerson = transactionDao.getLastInsertId();
        person.setPersonId(getLastIdPerson);
        user.setPersonId(getLastIdPerson);
        //LOGGER.error(user.getPersonId().toString());
        user.setBirthDate(userRequest.getBirthDate());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setTransaction(transaction);
        userDao.createUser(user);
        Integer getLastIdUser = transactionDao.getLastInsertId();
        address.setUserId(getLastIdUser);
        address.setNumber(userRequest.getNumber());
        address.setStreet(userRequest.getStreet());
        address.setZone(userRequest.getZone());
        address.setCity(userRequest.getCity());
        address.setCountry(userRequest.getCountry());
        address.setTransaction(transaction);
        addressDao.createAddress(address);
        return userRequest;
    }
}