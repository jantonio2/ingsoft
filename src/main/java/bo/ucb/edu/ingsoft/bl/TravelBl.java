package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.dao.AddressDao;
import bo.ucb.edu.ingsoft.dao.ContactDao;
import bo.ucb.edu.ingsoft.dao.TransaccionDao;
import bo.ucb.edu.ingsoft.dao.TravelDao;
import bo.ucb.edu.ingsoft.dto.TravelRequest;
import bo.ucb.edu.ingsoft.modelo.Address;
import bo.ucb.edu.ingsoft.modelo.Transaction;
import bo.ucb.edu.ingsoft.modelo.Travel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TravelBl {

    private TravelDao travelDao;
    private AddressDao addressDao;
    private TransaccionDao transaccionDao;

    @Autowired
    public TravelBl(TravelDao travelDao, AddressDao addressDao, TransaccionDao transaccionDao) {
        this.travelDao = travelDao;
        this.addressDao = addressDao;
        this.transaccionDao = transaccionDao;
    }
    public TravelRequest createNewTravel(TravelRequest travelRequest, Transaction transaction){
        Travel travel=new Travel();
        travel.setUserId(travelRequest.getTravelUserId());
        travel.setDriverId(travelRequest.getTravelDriverId());
        travel.setDateDelivery(travelRequest.getTravelDateDelivery());
        travelDao.createTravel(travel);
        Integer getLastId=transaccionDao.getLastInsertId();

        Address address= new Address();
        address.setStartTravelId(travelRequest.getAddressStartTravelId());
        address.setNumber(travelRequest.getAddressNumber());
        address.setStreet(travelRequest.getAddressStreet());
        address.setZone(travelRequest.getAddressZone());
        address.setCity(travelRequest.getAddressCity());
        address.setCountry(travelRequest.getAddressCountry());
        address.setStartTravelId(travel.getTravelId());
        addressDao.createAddress(address);

        return travelRequest;
    }


}
