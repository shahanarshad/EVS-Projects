/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package med.objava.spring.dao;

import java.util.List;
import javax.sql.DataSource;
import med.objava.spring.model.User;

/**
 *
 * @author shahzad
 */
public interface UserDao {
    
    public String query = "SELECT userid, name, pass, email, phone, type FROM user " ;

    public void setDataSource(DataSource ds);

    public void create(String name, String password, String email, String phone, String type);

    public User get(Integer userid);

    public User validate(String email, String password);

    public List<User> all();

    public void delete(Integer userid);

    public void update(Integer userid, String name, String password, String email, String phone, String type);

}
