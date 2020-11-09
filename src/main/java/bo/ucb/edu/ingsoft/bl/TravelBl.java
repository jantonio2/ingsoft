package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.dao.AddressDao;
import bo.ucb.edu.ingsoft.dao.TransactionDao;
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
    private TransactionDao transactionDao;

    @Autowired
    public TravelBl(TravelDao travelDao, AddressDao addressDao, TransactionDao transactionDao) {
        this.travelDao = travelDao;
        this.addressDao = addressDao;
        this.transactionDao = transactionDao;
    }
    public TravelRequest createNewTravel(TravelRequest travelRequest, Transaction transaction){

        Transaction travelTransaction = new Transaction();
        travelTransaction.setTxId(transaction.getTxId());
        travelTransaction.setTxUserId(transaction.getTxUserId());
        travelTransaction.setTxHost(transaction.getTxHost());
        travelTransaction.setTxDate(transaction.getTxDate());

        Travel travel=new Travel();
        travel.setUserId(travelRequest.getTravelUserId());
        travel.setDriverId(travelRequest.getTravelDriverId());
        travel.setDateDelivery(travelRequest.getTravelDateDelivery());
        travel.setTravelStatus(travelRequest.getTravelStatus());
        travel.setTransaction(travelTransaction);
        travelDao.createTravel(travel);
        travel.getTransaction();
        Integer getLastId=transactionDao.getLastInsertId();

        Address address= new Address();
        address.setNumber(travelRequest.getAddressNumber());
        address.setStreet(travelRequest.getAddressStreet());
        address.setZone(travelRequest.getAddressZone());
        address.setCity(travelRequest.getAddressCity());
        address.setCountry(travelRequest.getAddressCountry());
        address.setStartTravelId(getLastId);
        address.setTransaction(travelTransaction);
        addressDao.createStartTravelAddress(address);

        return travelRequest;
    }


}
