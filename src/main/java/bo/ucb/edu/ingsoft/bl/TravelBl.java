package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.dao.AddressDao;
import bo.ucb.edu.ingsoft.dao.TransactionDao;
import bo.ucb.edu.ingsoft.dao.TravelDao;
import bo.ucb.edu.ingsoft.dto.TravelListByDriverRequest;
import bo.ucb.edu.ingsoft.dto.TravelRequest;
import bo.ucb.edu.ingsoft.dto.VehicleListRequest;
import bo.ucb.edu.ingsoft.modelo.Address;
import bo.ucb.edu.ingsoft.modelo.Transaction;
import bo.ucb.edu.ingsoft.modelo.Travel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravelBl {

    private TravelDao travelDao;
    private AddressDao addressDao;
    private TransactionDao transactionDao;

    @Autowired
    public TravelBl(TravelDao travelDao, AddressDao addressDao, TransactionDao transactionDao) {
        this.travelDao = travelDao;
        this.addressDao = addressDao;
        this.transactionDao = transactionDao;
    }
    public TravelRequest createNewTravel(TravelRequest travelRequest, Transaction transaction){

        Address address1 = new Address();
        address1.setNumber(travelRequest.getStartAddressNumber());
        address1.setStreet(travelRequest.getStartAddressStreet());
        address1.setZone(travelRequest.getStartAddressZone());
        address1.setCity(travelRequest.getStartAddressCity());
        address1.setCountry(travelRequest.getStartAddressCountry());
        address1.setTransaction(transaction);
        addressDao.createAddress(address1);
        Integer getLastIdStartTravel = transactionDao.getLastInsertId();

        Address address2 = new Address();
        address2.setNumber(travelRequest.getDeliveryAddressNumber());
        address2.setStreet(travelRequest.getDeliveryAddressStreet());
        address2.setZone(travelRequest.getDeliveryAddressZone());
        address2.setCity(travelRequest.getDeliveryAddressCity());
        address2.setCountry(travelRequest.getDeliveryAddressCountry());
        address2.setTransaction(transaction);
        addressDao.createAddress(address2);
        Integer getLastIdDeliveryTravel = transactionDao.getLastInsertId();

        Travel travel=new Travel();
        travel.setUserId(travelRequest.getTravelUserId());
        travel.setDriverId(travelRequest.getTravelDriverId());
        travel.setStartAddressId(getLastIdStartTravel);
        travel.setDeliveryAddressId(getLastIdDeliveryTravel);
        travel.setDateDelivery(travelRequest.getTravelDateDelivery());
        travel.setTravelStatus(travelRequest.getTravelStatus());
        travel.setTransaction(transaction);
        travelDao.createTravel(travel);

        return travelRequest;
    }

    public List<TravelListByDriverRequest> travelsList(int driverId){
        List<TravelListByDriverRequest>vehicleListRequests = travelDao.findTravelByIdDriver(driverId);
        return vehicleListRequests;
    }


}
