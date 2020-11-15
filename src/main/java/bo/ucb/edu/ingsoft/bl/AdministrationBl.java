package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.api.AdministrationApi;
import bo.ucb.edu.ingsoft.dao.AdministrationDao;
import bo.ucb.edu.ingsoft.dao.PersonDao;
import bo.ucb.edu.ingsoft.dao.TransactionDao;
import bo.ucb.edu.ingsoft.dto.AdministrationRequest;
import bo.ucb.edu.ingsoft.modelo.Administration;
import bo.ucb.edu.ingsoft.modelo.Person;
import bo.ucb.edu.ingsoft.modelo.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministrationBl {
    private AdministrationDao administrationDao;
    private TransactionDao transactionDao;
    private PersonDao personDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(AdministrationApi.class);

    @Autowired
    public AdministrationBl(AdministrationDao administrationDao, TransactionDao transactionDao, PersonDao personDao){
        this.administrationDao = administrationDao;
        this.transactionDao = transactionDao;
        this.personDao = personDao;
    }

    public AdministrationRequest createAdministration(AdministrationRequest administrationRequest, Transaction transaction){
        Administration administration = new Administration();
        Person person = new Person();
        LOGGER.error(administrationRequest.getFirstName());

        person.setFirstName(administrationRequest.getFirstName());
        person.setFirstSurname(administrationRequest.getFirstSurname());
        person.setSecondSurname(administrationRequest.getSecondSurname());
        person.setCi(administrationRequest.getCi());
        person.setPhone(administrationRequest.getPhone());
        person.setTransaction(transaction);
        personDao.createPerson(person);
        Integer getLastIdPerson = transactionDao.getLastInsertId();
        person.setPersonId(getLastIdPerson);

        LOGGER.error(getLastIdPerson.toString());
        administration.setPersonId(getLastIdPerson);
        administration.setEmail(administrationRequest.getEmail());
        administration.setPassword(administrationRequest.getPassword());
        administration.setTransaction(transaction);
        administrationDao.createAdministration(administration);

        return administrationRequest;
    }

}
