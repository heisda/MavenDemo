package com.tdm.demo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    private Logger logger = Logger.getLogger(TestController.class); 
    private static String SERVER_PATH = "http://www.baidu.com";
    private static String SPID = "";
    
    private String userToken;
    private String returnURL;
    private String expiredTime;
    
    @RequestMapping("/getUserToken")
    public String getUserToken(HttpServletRequest request){
        requestInfo(request);
        logger.info("cookie usertoken:" + this.userToken);
        
        String userToken = request.getParameter("UserToken");
        logger.info("response usertoken:" + this.userToken);
        
        if(this.userToken == null && userToken == null){
            return "redirect:" + SERVER_PATH + "" +  "?SPID=" + SPID + "&ReturnURL=" + returnURL + "&action=UserTokenRequest";
        }
        
        String result = request.getParameter("Result");
        logger.info("response result:" + result);
        logger.info("expired time : " + request.getParameter("ExpiredTime"));
        if("0".equals(result)){
            this.userToken = userToken;
        }
        return "result";
    }
    
    @RequestMapping("/refreshUserToken")
    public String refreshUserToken(HttpServletRequest request){
        requestInfo(request);
        
        String newUserToken = request.getParameter("NewUserToken");
        logger.info("NewUserToken:" + newUserToken);
        
        if(isExpired() && newUserToken == null){
            return "redirect:" + SERVER_PATH + "" + "?OldUserToken=" + userToken + "&ReturnURL=" + returnURL + "&Action=UserTokenExpired";
        }
        
        logger.info("response result:" + request.getParameter("Result"));
        logger.info("expired time : " + request.getParameter("TokenExpiredTime"));
        logger.info("UserID : " + request.getParameter("UserID"));
        return "result";
    }
    
    @RequestMapping("/orderProduct")
    public String order(HttpServletRequest request){
        requestInfo(request);
        
        String result = request.getParameter("Result");
        if(result == null){
            return "redirect:" + SERVER_PATH + "" + "?UserToken=" + userToken + "&ReturnURL=" + returnURL + "&Action=ProductOrder";
        }
        logger.info("result : " + request.getParameter("Result"));
        logger.info("service id : " + request.getParameter("ServiceID"));
        logger.info("product id : " + request.getParameter("ProductID"));
        logger.info("purchase type : " + request.getParameter("PurchaseType"));
        return "result";
    }
    
    private void requestInfo(HttpServletRequest request){
        returnURL = request.getRequestURL().toString();
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies){
            if(cookie.getName().equalsIgnoreCase("userToken")){
                userToken = cookie.getValue();
            }
            if(cookie.getName().equalsIgnoreCase("expiredTime")){
                expiredTime = cookie.getValue();
            }
        }
    }
    
    private boolean isExpired(){
        if(expiredTime != null){
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
            try {
                return format.parse(expiredTime).before(new Date());
            } catch (ParseException e) {
                logger.error(e);
            }
        }
        return false;
    }
    
    private String generateRedirectURL(String type, String action){
        return SERVER_PATH + type +  "?spid=" + SPID + "&returnURL=" + returnURL + "&actioin=" + action;
    }
    
    public static void main(String[] args) {
        System.out.println(new TestController().generateRedirectURL("", "UserTokenRequest"));
    }
}
