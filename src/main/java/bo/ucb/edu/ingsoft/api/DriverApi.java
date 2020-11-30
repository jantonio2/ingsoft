package bo.ucb.edu.ingsoft.api;

import bo.ucb.edu.ingsoft.bl.DriverBl;
import bo.ucb.edu.ingsoft.bl.TransactionBl;
import bo.ucb.edu.ingsoft.dto.*;
import bo.ucb.edu.ingsoft.modelo.Transaction;
import bo.ucb.edu.ingsoft.modelo.Driver;
import bo.ucb.edu.ingsoft.util.TransactionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/driver")
public class DriverApi {
    private DriverBl driverBl;
    private TransactionBl transactionBl;

    private static final Logger LOGGER = LoggerFactory.getLogger(DriverApi.class);

    @Autowired
    public DriverApi(DriverBl driverBl, TransactionBl transactionBl) {
        this.driverBl = driverBl;
        this.transactionBl = transactionBl;
    }

//    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public SingleDriver findById(HttpServletRequest request, @RequestParam Integer driverId) {
//        //int userId=2;
//        return driverBl.findDriverById(driverId);
//    }

    @GetMapping(path="/{driverId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public SingleDriver findById(HttpServletRequest request, @PathVariable String driverId){
        return driverBl.findDriverById(Integer.parseInt(driverId));
    }
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public DriverRequest createDriver(@RequestBody DriverRequest driverRequest, HttpServletRequest request) {
        // Creamos transaccion para la operaciónn
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        DriverRequest driverResponse = driverBl.createDriver(driverRequest, transaction);
        return driverResponse;
    }

    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public DriverRequest update(@RequestBody DriverRequest driverRequest, HttpServletRequest request) {
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        driverBl.updateDriver(driverRequest,transaction);
        return driverRequest;
    }
    @RequestMapping(path="/history",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DriverHistoryRequest> chatsList(@RequestBody Driver driver, HttpServletRequest request) {
        List<DriverHistoryRequest> driverList=driverBl.driverHistory(driver);
        return driverList;
    }

    @RequestMapping(path="/vehicle",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DriverVehicleRequest> vehicleList(@RequestBody Driver driver, HttpServletRequest request) {
        List<DriverVehicleRequest> driverList=driverBl.driverVehicle(driver);
        return driverList;
    }

    @RequestMapping(path="/contact",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DriverContactRequest> chatsList(HttpServletRequest request) {
        List<DriverContactRequest> driverListContact=driverBl.driverContact();
        return driverListContact;
    }


    @PutMapping(path="/{driverId}/image", produces = MediaType.APPLICATION_JSON_VALUE)
    public String uploadImage(@RequestParam MultipartFile image, @PathVariable String driverId, HttpServletRequest request){
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        driverBl.uploadImage(image,Integer.parseInt(driverId),transaction);
        return "Succesful process";
    }

    @RequestMapping(path="/company",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CompanyRequest> companyList(HttpServletRequest request) {
        List<CompanyRequest> companies=driverBl.getCompanies();
        return companies;
    }
}
