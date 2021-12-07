package com.atos.webapp;

 

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

 

public class LoginDAO {
    Map<Integer, Login> db = new LinkedHashMap<Integer, Login>();

 

    public List<Login> getAllLogins() {
        List<Login> list = new ArrayList<>();
        Set<Integer> keys = getDB().keySet();
        for (Integer key : keys) {
            list.add(db.get(key));
        }
        return list;
    }

 

    public Login getLogin(int id) {
        Login login = null;
        boolean flag = getDB().containsKey(id);
        if (flag) {
            login = getDB().get(id);
        }
        return login;
    }

 

    public int newLogin() {
        return 0;

 

    }

 

    public int updateLogin(Login login) {
        int i = 0;
        Login login2 = getDB().remove(login.getId());
         getDB().put(login.getId(), login);
        if (login.getId() == login2.getId()) {
            i = 1;
        } else {
            i = 0;
        }
        return i;
    }

 

    public int removeLogin() {
        return 0;
    }

 

    public Map<Integer, Login> getDB() {
        Login login1 = new Login(1001, "admin", "admin", "admin");
        Login login2 = new Login(1002, "kannan", "kannan", "trainer");
        Login login3 = new Login(1003, "kumar", "kumar", "trainee");
        Login login4 = new Login(1004, "reena", "reena", "trainee");
        Login login5 = new Login(1005, "meena", "meena", "trainer");
        db.put(1001, login1);
        db.put(1002, login2);
        db.put(1003, login3);
        db.put(1004, login4);
        db.put(1005, login5);
        return db;
    }
}