package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.api.DriverApi;
import bo.ucb.edu.ingsoft.dao.*;
import bo.ucb.edu.ingsoft.dto.*;
import bo.ucb.edu.ingsoft.modelo.*;
import bo.ucb.edu.ingsoft.util.ImageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class VehicleBl {
    private ScoreDao scoreDao;
    private DriverDao driverDao;
    private VehicleDao vehicleDao;
    private PersonDao personDao;
    private CompanyDao companyDao;
    private TransactionDao transactionDao;
    private static final Logger LOGGER = LoggerFactory.getLogger(DriverApi.class);

    @Autowired
    public VehicleBl(ScoreDao scoreDao, DriverDao driverDao, VehicleDao vehicleDao, PersonDao personDao, CompanyDao companyDao, TransactionDao transactionDao) {
        this.scoreDao = scoreDao;
        this.driverDao = driverDao;
        this.vehicleDao = vehicleDao;
        this.personDao = personDao;
        this.companyDao = companyDao;
        this.transactionDao = transactionDao;
    }

    public SingleVehicle findVehicleById(Integer vehicleId){

        SingleVehicle singleVehicle = new SingleVehicle();

        Vehicle vehicle = vehicleDao.findVehicleById(vehicleId);

        Driver driver = driverDao.findByDriverId(vehicle.getDriverId());
        Person person = personDao.findByPersonId(driver.getPersonId());

        singleVehicle.setPersonFirstName(person.getFirstName());
        singleVehicle.setPersonFirstSurname(person.getFirstSurname());
        singleVehicle.setVehicleLicensePlate(vehicle.getLicensePlate());
        singleVehicle.setVehicleCapacity(vehicle.getCapacity());
        singleVehicle.setVehicleType(vehicle.getVehicleType());
        singleVehicle.setVehiclePrice(vehicle.getPrice());
        singleVehicle.setVehicleBrand(vehicle.getBrand());
        singleVehicle.setVehicleModel(vehicle.getVehicleModel());
        singleVehicle.setVehicleStatus(vehicle.getVehicleStatus());

        return singleVehicle;
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

        if(company==null){
            singleScore.setVehicleCompany(null);
        }else{
            singleScore.setVehicleCompany(company.getName());
        }

        singleScore.setPersonPhone(person.getPhone());
        singleScore.setVehicleStatus(vehicle.getVehicleStatus());

        return singleScore;



    }

    public List<VehicleDriverRequest> vehicleDriver(){
        List<VehicleDriverRequest>vehicleDriverList = vehicleDao.vehicleDriver();
        return vehicleDriverList;
    }

    public List<VehicleDriverRequest>findVehiclesByType(String vehicleType){
        List<VehicleDriverRequest>vehicleDriverRequests = vehicleDao.findVehiclesByType(vehicleType);
        return vehicleDriverRequests;
    }

    public List<VehicleDriverRequest>findVehicleByBrand(String vehicleBrand){
        List<VehicleDriverRequest>vehicleDriverRequests = vehicleDao.findVehiclesByBrand(vehicleBrand);
        return vehicleDriverRequests;
    }

    public ScoreRequest createNewScore(ScoreRequest scoreRequest, Transaction transaction){
        Score score = new Score();
        score.setVehicleId(scoreRequest.getVehicleId());
        score.setUserId(scoreRequest.getUserId());
        score.setScore(scoreRequest.getScore());
        score.setTransaction(transaction);
        scoreDao.createScore(score);
        return scoreRequest;
    }

    public VehicleRequest createNewVehicle(VehicleRequest vehicleRequest, Transaction transaction){

        Vehicle vehicle = new Vehicle();

        vehicle.setDriverId(vehicleRequest.getVehicleDriverId());
        vehicle.setLicensePlate(vehicleRequest.getVehicleLicensePlate());
        vehicle.setCapacity(vehicleRequest.getVehicleCapacity());
        vehicle.setVehicleType(vehicleRequest.getVehicleType());
        vehicle.setPrice(vehicleRequest.getVehiclePrice());
        vehicle.setVehicleStatus(vehicleRequest.getVehicleStatus());
        vehicle.setBrand(vehicleRequest.getVehicleBrand());
        vehicle.setVehicleModel(vehicleRequest.getVehicleModel());
        vehicle.setTransaction(transaction);
        vehicleDao.createVehicle(vehicle);
        Integer getLastIdVehicle = transactionDao.getLastInsertId();


        return vehicleRequest;
    }

    public void uploadImage(MultipartFile image, Integer vehicleId, Transaction transaction){
        ImageUtil imageUtil = new ImageUtil();
        Vehicle vehicle = new Vehicle();


         String newImageName = imageUtil.uploadImage(image,"images/vehicleImage","Vehicle",vehicleId);
         vehicle.setVehicleId(vehicleId);
         vehicle.setPictures(newImageName);
         vehicle.setTransaction(transaction);
         vehicleDao.updateImage(vehicle);
    }



}
