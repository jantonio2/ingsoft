package bo.ucb.edu.ingsoft.api;

import bo.ucb.edu.ingsoft.bl.TransactionBl;
import bo.ucb.edu.ingsoft.bl.VehicleBl;
import bo.ucb.edu.ingsoft.dto.*;
import bo.ucb.edu.ingsoft.modelo.Transaction;
import bo.ucb.edu.ingsoft.modelo.Vehicle;
import bo.ucb.edu.ingsoft.util.TransactionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/vehicle")
public class VehicleApi {
    private VehicleBl vehicleBl;
    private TransactionBl transactionBl;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserApi.class);

    @Autowired
    public VehicleApi(VehicleBl vehicleBl, TransactionBl transactionBl) {
        this.vehicleBl = vehicleBl;
        this.transactionBl = transactionBl;
    }

    @GetMapping(path="/{vehicleId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public SingleVehicle findById(HttpServletRequest request, @PathVariable String vehicleId){
        return vehicleBl.findVehicleById(Integer.parseInt(vehicleId));
    }

    @RequestMapping(method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<VehicleDriverRequest> findVehiclesByDriver(HttpServletRequest request) {
        List<VehicleDriverRequest> vehicleListDriver=vehicleBl.vehicleDriver();
        return vehicleListDriver;
    }

    @RequestMapping(path="/type", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<VehicleDriverRequest> findVehiclesByType(@RequestBody Vehicle vehicle, HttpServletRequest request) {
        List<VehicleDriverRequest> vehicleListDriver=vehicleBl.findVehiclesByType(vehicle.getVehicleType());
        return vehicleListDriver;
    }

    @RequestMapping(path="/brand", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<VehicleDriverRequest> findVehiclesByBrand(@RequestBody Vehicle vehicle, HttpServletRequest request) {
        List<VehicleDriverRequest> vehicleListDriver=vehicleBl.findVehicleByBrand(vehicle.getBrand());
        return vehicleListDriver;
    }


    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public VehicleRequest createVehicle(@RequestBody VehicleRequest vehicleRequest, HttpServletRequest request){
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        VehicleRequest vehicleResponse = vehicleBl.createNewVehicle(vehicleRequest,transaction);
        return vehicleResponse;
    }



}
