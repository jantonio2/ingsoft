package bo.ucb.edu.ingsoft.api;


import bo.ucb.edu.ingsoft.bl.VehicleBl;
import bo.ucb.edu.ingsoft.bl.TransactionBl;
import bo.ucb.edu.ingsoft.dto.ScoreRequest;
import bo.ucb.edu.ingsoft.dto.SingleScore;
import bo.ucb.edu.ingsoft.modelo.Transaction;
import bo.ucb.edu.ingsoft.util.TransactionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/v1/score")
public class ScoreApi {

    private VehicleBl vehicleBl;
    private TransactionBl transactionBl;

    private static final Logger LOGGER = LoggerFactory.getLogger(DriverApi.class);

    @Autowired
    public ScoreApi(VehicleBl vehicleBl, TransactionBl transactionBl){
        this.vehicleBl = vehicleBl;
        this.transactionBl = transactionBl;

    }

    @GetMapping(path="/{scoreId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public SingleScore findById(HttpServletRequest request, @PathVariable String scoreId){
        return vehicleBl.findScoreById(Integer.parseInt(scoreId));
    }


    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ScoreRequest createScore(@RequestBody ScoreRequest scoreRequest, HttpServletRequest request){
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        ScoreRequest scoreResponse  = vehicleBl.createNewScore(scoreRequest,transaction);
        return scoreResponse;
    }
}
