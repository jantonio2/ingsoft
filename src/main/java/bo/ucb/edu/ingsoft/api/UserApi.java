package bo.ucb.edu.ingsoft.api;

import bo.ucb.edu.ingsoft.bl.TransactionBl;
import bo.ucb.edu.ingsoft.bl.UserBl;
import bo.ucb.edu.ingsoft.dto.LogInRequest;
import bo.ucb.edu.ingsoft.dto.SingleUser;
import bo.ucb.edu.ingsoft.dto.UserHistoryRequest;
import bo.ucb.edu.ingsoft.dto.UserRequest;
import bo.ucb.edu.ingsoft.modelo.Transaction;
import bo.ucb.edu.ingsoft.modelo.User;
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
@RequestMapping(value = "/v1/user")
public class    UserApi {

    private UserBl userBl;
    private TransactionBl transactionBl;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserApi.class);

    @Autowired
    public UserApi(UserBl userBl, TransactionBl transactionBl) {
        this.userBl = userBl;
        this.transactionBl = transactionBl;
    }

//    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public SingleUser findById(HttpServletRequest request, @RequestParam Integer userId) {
//        //int userId=2;
//        return userBl.findUserById(userId);
//    }

    @GetMapping(path="/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public SingleUser findById(HttpServletRequest request, @PathVariable String userId){
        return userBl.findUserById(Integer.parseInt(userId));
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserRequest createUser(@RequestBody UserRequest userRequest, HttpServletRequest request) {
        // Creamos transaccion para la operaciónn
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        UserRequest userResponse = userBl.createUser(userRequest, transaction);
        return userResponse;
    }

    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserRequest update(@RequestBody UserRequest userRequest, HttpServletRequest request) {
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        userBl.updateUser(userRequest,transaction);
        return userRequest;
    }

    /*@RequestMapping(path="/history",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserHistoryRequest> chatsList(@RequestBody User user, HttpServletRequest request) {
        List<UserHistoryRequest> userList=userBl.userHistory(user);
        return userList;
    }*/

    @GetMapping(path="/{userId}/payment", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserHistoryRequest> chatsList(HttpServletRequest request, @PathVariable String userId){
        Integer us = Integer.parseInt(userId);
        List<UserHistoryRequest> userList=userBl.userHistory(us);
        return userList;
    }


    @PutMapping(path="/{userId}/image", produces = MediaType.APPLICATION_JSON_VALUE)
    public String uploadImage(@RequestParam MultipartFile image, @PathVariable String userId, HttpServletRequest request){
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        userBl.uploadImage(image,Integer.parseInt(userId),transaction);
        return "Succesful process";
    }

    @RequestMapping(path="/sesion",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<LogInRequest> logList(HttpServletRequest request) {
        List<LogInRequest> log=userBl.userLogIn();
        return log;
    }
}
