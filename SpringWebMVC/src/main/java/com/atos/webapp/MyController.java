package com.atos.webapp;

 

import java.util.ArrayList;
import java.util.List;

 

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

 

@Controller
public class MyController {

 

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "login";
    }

 

    @ResponseBody
    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public String signin(@RequestParam("username") String uname, @RequestParam("password") String pwd) {
        String msg = "Username or Password Wrong!.";
        if (uname != null && pwd != null) {
            if (uname.length() >= 6 && pwd.length() >= 6) {
                msg = "Hello " + uname + ", login successfully ";
            }
        }
        return msg;
    }
    
    @ResponseBody
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public List<Login> getAllLogins() {
        Login login1 =new Login(1001, "admin", "admin", "admin");
        Login login2 =new Login(1002, "kannan", "kannan", "trainer");
        Login login3 =new Login(1003, "kumar", "kumar", "trainee");
        Login login4 =new Login(1004, "reena", "reena", "trainee");
        Login login5 =new Login(1005, "meena", "meena", "trainer");
        List<Login> list = new ArrayList<>();
        list.add(login1);
        list.add(login2);
        list.add(login3);
        list.add(login4);
        list.add(login5);
        return list;
    }

 

    @ResponseBody
    @RequestMapping(value = "/requesthead", method = RequestMethod.GET)
    public String head(@RequestHeader(value = "Accept") String accept, @RequestHeader(value = "Host") String host,
            @RequestHeader(value = "Accept-Language") String language,
            @RequestHeader(value = "User-Agent") String agent) {
        String header = "Accept " + accept + "<br>Accept-Language " + language;
        header += "<br>Host :: " + host + "<br>User-Agent  " + agent;
        return header;
    }

 

    @RequestMapping(value = "/responsehead", method = RequestMethod.GET)
    public String reshead() {
        return "header";
    }
}