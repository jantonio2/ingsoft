package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.dao.*;
import bo.ucb.edu.ingsoft.dto.Contact;
import bo.ucb.edu.ingsoft.dto.UserRequest;
import bo.ucb.edu.ingsoft.modelo.Address;
import bo.ucb.edu.ingsoft.modelo.Person;
import bo.ucb.edu.ingsoft.modelo.Transaction;
import bo.ucb.edu.ingsoft.modelo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendaBl {
    private PersonDao personDao;
    private UserDao userDao;
    private AddressDao addressDao;
    private TransactionDao transactionDao;

    @Autowired
    public AgendaBl(PersonDao personDao, UserDao userDao, AddressDao addressDao, TransactionDao transactionDao) {
        this.personDao = personDao;
        this.userDao = userDao;
        this.addressDao = addressDao;
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

}
