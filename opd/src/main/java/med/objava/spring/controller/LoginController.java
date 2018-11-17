/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package med.objava.spring.controller;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import med.objava.spring.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author shahzad
 */
@Controller
public class LoginController {
    
    @Autowired
    private UserDao userTemplate ;

    @RequestMapping("/login.htm")
    public ModelAndView hello() {
        String message = "This is JSP Example for our Spring Class";
        Map<String, String> map = new HashMap<String, String>() ;
        map.put("message", message ) ;
        return new ModelAndView("login", "map", map);
    }
    
    @RequestMapping("/login.json")
    public ModelAndView loginJson() {
        String gson = new Gson().toJson(userTemplate.all())  ;
//        return "" ;
        return new ModelAndView("json", "gson", gson ) ; 
    }

}
