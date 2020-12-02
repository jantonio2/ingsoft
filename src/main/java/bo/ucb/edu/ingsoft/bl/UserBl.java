package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.api.UserApi;
import bo.ucb.edu.ingsoft.dao.AddressDao;
import bo.ucb.edu.ingsoft.dao.PersonDao;
import bo.ucb.edu.ingsoft.dao.TransactionDao;
import bo.ucb.edu.ingsoft.dao.UserDao;
import bo.ucb.edu.ingsoft.dto.LogInRequest;
import bo.ucb.edu.ingsoft.dto.SingleUser;
import bo.ucb.edu.ingsoft.dto.UserHistoryRequest;
import bo.ucb.edu.ingsoft.dto.UserRequest;
import bo.ucb.edu.ingsoft.modelo.Address;
import bo.ucb.edu.ingsoft.modelo.Person;
import bo.ucb.edu.ingsoft.modelo.Transaction;
import bo.ucb.edu.ingsoft.modelo.User;
import bo.ucb.edu.ingsoft.util.ImageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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

    public SingleUser findUserById(Integer userId) {
        User user = userDao.findByUserId(userId);
        SingleUser singleUserResponse = new SingleUser();
        LOGGER.error(user.getEmail());
        Person person = personDao.findByPersonId(user.getPersonId());
        Address address = addressDao.findById(user.getAddressId());

        singleUserResponse.setCi(person.getCi());
        singleUserResponse.setFirstName(person.getFirstName());
        singleUserResponse.setFirstSurname(person.getFirstSurname());
        singleUserResponse.setSecondSurname(person.getSecondSurname());
        singleUserResponse.setPhone(person.getPhone());

        singleUserResponse.setBirthDate(user.getBirthDate());
        singleUserResponse.setEmail(user.getEmail());

        singleUserResponse.setNumber(address.getNumber());
        singleUserResponse.setStreet(address.getStreet());
        singleUserResponse.setZone(address.getZone());
        singleUserResponse.setCity(address.getCity());
        singleUserResponse.setCountry(address.getCountry());
        return  singleUserResponse;
    }


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

        address.setNumber(userRequest.getNumber());
        address.setStreet(userRequest.getStreet());
        address.setZone(userRequest.getZone());
        address.setCity(userRequest.getCity());
        address.setCountry(userRequest.getCountry());
        address.setTransaction(transaction);
        addressDao.createAddress(address);

        Integer getLastIdAddress = transactionDao.getLastInsertId();
        user.setPersonId(getLastIdPerson);
        user.setAddressId(getLastIdAddress);
        //LOGGER.error(user.getPersonId().toString());
        user.setBirthDate(userRequest.getBirthDate());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setTransaction(transaction);
        userDao.createUser(user);
        Integer getLastIdUser = transactionDao.getLastInsertId();


        return userRequest;
    }

    public UserRequest updateUser(UserRequest userRequest, Transaction transaction){
        User user = new User();
        Person person = new Person();
        Address address = new Address();

        user.setUserId(userRequest.getUserId());
        user.setEmail(userRequest.getEmail());
        user.setBirthDate(userRequest.getBirthDate());
        user.setPassword(userRequest.getPassword());
        user.setTransaction(transaction);
        LOGGER.error(transaction.getTxId().toString());
        userDao.updateUser(user);

        User user2 = userDao.getPersonId(userRequest.getUserId());
        person.setPersonId(user2.getPersonId());
        person.setFirstName(userRequest.getFirstName());
        person.setFirstSurname(userRequest.getFirstSurname());
        person.setSecondSurname(userRequest.getSecondSurname());
        person.setCi(userRequest.getCi());
        person.setPhone(userRequest.getPhone());
        person.setTransaction(transaction);
        personDao.updatePerson(person);

        address.setAddressId(user2.getAddressId());
        address.setNumber(userRequest.getNumber());
        address.setStreet(userRequest.getStreet());
        address.setZone(userRequest.getZone());
        address.setCity(userRequest.getCity());
        address.setCountry(userRequest.getCountry());
        address.setTransaction(transaction);
        addressDao.updateAddress(address);

        return  userRequest;
    }

    public List<UserHistoryRequest> userHistory(Integer userId){
        List<UserHistoryRequest> userList = userDao.userHistory(userId);
        return userList;
    }

    public void uploadImage(MultipartFile image, Integer userId, Transaction transaction){
        ImageUtil imageUtil = new ImageUtil();
        User user = new User();

        String newImageName = imageUtil.uploadImage(image,"images/userImage","User",userId);
        user.setUserId(userId);
        user.setPicture(newImageName);
        user.setTransaction(transaction);
        userDao.updateImage(user);
    }

    public List<LogInRequest> userLogIn() {
        List<LogInRequest> list = userDao.userLogIn();
        return list;
    }
}