package com.tdm.demo.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tdm.demo.domain.Address;
import com.tdm.demo.domain.User;
import com.tdm.demo.service.AddressService;
import com.tdm.demo.service.TeamService;
import com.tdm.demo.service.UserService;

@Controller
public class HomeController {
    
    Logger logger = Logger.getLogger(HomeController.class);

    @Autowired
    private UserService userService;
    
    @Autowired
    private TeamService teamService;
    
    @Autowired
    private AddressService addressService;
    
    @RequestMapping("/home.htm")
    public String home(ModelMap model){
        model.addAttribute("greeting", "hello guys");
        logger.warn("access home.htm" + new Date());
        return "home";
    }
    
    @RequestMapping("/save.htm")
    public String save(Integer age, String name){
        User user = new User();
        user.setAge(22);
        user.setName(name);
        userService.persiste(user);
        return "home";
    }
    
    @RequestMapping("/list.htm")
    public String list(ModelMap model){
        List<User> users = userService.list();
        model.addAttribute("users", users);
        return "list";
    }
    
    @RequestMapping("/show.htm")
    public String show(ModelMap model, Integer id){
        User user = userService.getById(id);
        model.addAttribute("user", user);
        user.setName(user.getName() + "+");
        userService.update(user);
        return "show";
    }
    
    @RequestMapping("/testTx.htm")
    public String testTx(Integer flag) throws Exception{
        teamService.saveTeamAndMembers(flag);
        return "testTx";
    }
    
    @RequestMapping("/address/add")
    public String addAddresToUser(Integer id){
        User user = userService.getById(id);
        Address address = new Address();
        address.setName("Wenshui");
        address.setUser(user);
        addressService.save(address);
        user.getAddresses().add(address);
        userService.update(user);
        return "ok";
    }
    
    @RequestMapping("/redirect")
    public String redirect(HttpServletRequest request){
        StringBuffer url = request.getRequestURL();
        System.out.println(url.toString());
        return "redirect:http://www.baidu.com/s?wd=dada";
    }
}
