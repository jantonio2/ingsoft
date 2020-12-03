package bo.ucb.edu.ingsoft.api;

import bo.ucb.edu.ingsoft.bl.TransactionBl;
import bo.ucb.edu.ingsoft.bl.TravelBl;
import bo.ucb.edu.ingsoft.dto.TravelListByDriverRequest;
import bo.ucb.edu.ingsoft.dto.CardCollectionRequest;
import bo.ucb.edu.ingsoft.dto.SingleDriver;
import bo.ucb.edu.ingsoft.dto.TravelIdRequest;
import bo.ucb.edu.ingsoft.dto.TravelRequest;
import bo.ucb.edu.ingsoft.dto.VehicleListRequest;
import bo.ucb.edu.ingsoft.modelo.Transaction;
import bo.ucb.edu.ingsoft.util.TransactionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/travel")
public class TravelApi {

    private TravelBl travelBl;
    private TransactionBl transactionBl;

    private static final Logger LOGGER = LoggerFactory.getLogger(TravelApi.class);

    @Autowired
    public TravelApi(TravelBl travelBl, TransactionBl transactionBl) {
        this.travelBl = travelBl;
        this.transactionBl = transactionBl;
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public TravelRequest createTravel(@RequestBody TravelRequest travelRequest , HttpServletRequest request) {
        // Creamos transaccion para la operación.
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        TravelRequest travelRequest1 = travelBl.createNewTravel(travelRequest,transaction);
        return travelRequest1;
    }

    @RequestMapping(path="/findDriver/{driverId}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TravelListByDriverRequest> findVehiclesByCompany(HttpServletRequest request, @PathVariable int driverId) {
        List<TravelListByDriverRequest> vehicleListDriver=travelBl.travelsList(driverId);
        return vehicleListDriver;
    }

    @GetMapping(path="/{userId}/{driverId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TravelIdRequest> findTravelById(HttpServletRequest request, @PathVariable String userId,@PathVariable String driverId){
        List<TravelIdRequest> travelList=travelBl.getIdsTravel(Integer.parseInt(userId),Integer.parseInt(driverId));
        LOGGER.error("travelId");
        return travelList;
//        return travelBl.get(Integer.parseInt(userId),Integer.parseInt(driverId));
    }

}
