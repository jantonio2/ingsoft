package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.api.DriverApi;
import bo.ucb.edu.ingsoft.dao.*;
import bo.ucb.edu.ingsoft.dto.SingleScore;
import bo.ucb.edu.ingsoft.modelo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreBl {
    private ScoreDao scoreDao;
    private DriverDao driverDao;
    private VehicleDao vehicleDao;
    private PersonDao personDao;
    private CompanyDao companyDao;
    private TransactionDao transactionDao;
    private static final Logger LOGGER = LoggerFactory.getLogger(DriverApi.class);

    @Autowired
    public ScoreBl(ScoreDao scoreDao,DriverDao driverDao,VehicleDao vehicleDao,PersonDao personDao,CompanyDao companyDao,TransactionDao transactionDao) {
        this.scoreDao = scoreDao;
        this.driverDao = driverDao;
        this.vehicleDao = vehicleDao;
        this.personDao = personDao;
        this.companyDao = companyDao;
        this.transactionDao = transactionDao;
    }

    public SingleScore findScoreById(Integer scoreId){

        SingleScore singleScore =new SingleScore();

        Score score = scoreDao.findScoreById(scoreId);
        Vehicle vehicle = vehicleDao.findVehicleById(score.getVehicleId());
        Driver driver = driverDao.findByDriverId(vehicle.getDriverId());
        Company company = companyDao.findCompanyById(driver.getCompanyId());
        Person person =personDao.findByPersonId(driver.getPersonId());

        singleScore.setScore(score.getScore());
        singleScore.setVehicleType(vehicle.getVehicleType());
        singleScore.setVehicleBrand(vehicle.getBrand());
        singleScore.setVehicleModel(vehicle.getVehicleModel());
        singleScore.setPersonFirstName(person.getFirstName());
        singleScore.setPersonFirstSurname(person.getFirstSurname());
        singleScore.setVehicleLicensePlate(vehicle.getLicensePlate());
        singleScore.setVehicleCapacity(vehicle.getCapacity());
        singleScore.setVehicleCompany(company.getName());
        singleScore.setPersonPhone(person.getPhone());
        singleScore.setVehicleStatus(vehicle.getVehicleStatus());

        return singleScore;



    }


}
