package bo.ucb.edu.ingsoft.api;


import bo.ucb.edu.ingsoft.bl.ScoreBl;
import bo.ucb.edu.ingsoft.bl.TransactionBl;
import bo.ucb.edu.ingsoft.dto.SingleDriver;
import bo.ucb.edu.ingsoft.dto.SingleScore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/v1/score")
public class ScoreApi {

    private ScoreBl scoreBl;
    private TransactionBl transactionBl;

    private static final Logger LOGGER = LoggerFactory.getLogger(DriverApi.class);

    @Autowired
    public ScoreApi(ScoreBl scoreBl, TransactionBl transactionBl){
        this.scoreBl = scoreBl;
        this.transactionBl = transactionBl;

    }

    @GetMapping(path="/{scoreId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public SingleScore findById(HttpServletRequest request, @PathVariable String scoreId){
        return scoreBl.findScoreById(Integer.parseInt(scoreId));
    }
}
