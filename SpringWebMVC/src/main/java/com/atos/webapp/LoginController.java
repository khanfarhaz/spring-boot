package com.atos.webapp;

 

import java.util.List;

 

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

 

@Controller
public class LoginController {
    LoginDAO dao = new LoginDAO();

 

    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Login> getAllLogins() {
        List<Login> list = dao.getAllLogins();
        return list;
    }

 

    @ResponseBody
    @RequestMapping(value = "/login/{id}", method = RequestMethod.GET)
    public Login getLogin(@PathVariable("id") int id) {
        Login login = dao.getLogin(id);
        return login;
    }

 

    @RequestMapping(value = "/update ", method = RequestMethod.PUT)
    public String updateLogin(@ModelAttribute Login login) {
        String str = null;
        int i = dao.updateLogin(login);
        if (i == 1) {
            str = "success";
        } else {
            str = "failed";
        }
        return str;
    }
}