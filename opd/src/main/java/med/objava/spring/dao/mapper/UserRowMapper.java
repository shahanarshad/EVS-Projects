/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package med.objava.spring.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import med.objava.spring.model.User;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author shahzad
 */
public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int i) throws SQLException {
        User u = new User();
        u.setUserid(rs.getInt("userid"));
        u.setEmail(rs.getString("email"));
        u.setName(rs.getString("name"));
        u.setPassword(rs.getString("pass"));
        u.setPhone(rs.getString("phone"));
        u.setType(rs.getString("type"));
        return u;
    }

}
