/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package med.objava.spring.dao.template;

import java.util.List;
import javax.sql.DataSource;
import med.objava.spring.dao.UserDao;
import med.objava.spring.dao.mapper.UserRowMapper;
import med.objava.spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author shahzad
 */
public class UserJdbcTemplate implements UserDao {

    @Autowired
    private DataSource dataSource;
    
    private JdbcTemplate jdbcTemplateObject;

    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    public void create(String name, String password, String email, String phone, String type) {
        // Create
        String sql = "INSERT INTO user ( name, pass, email, phone, type ) value (?,?,?,?,?)";
        jdbcTemplateObject.update(sql, name, password, email, phone, type);
    }

    @Override
    public User get(Integer userid) {
        String sql = query + "WHERE userid=?";
        User user = jdbcTemplateObject
                .queryForObject(
                        sql,
                        new Object[]{userid},
                        new UserRowMapper());
        return user;
    }

    @Override
    public User validate(String email, String password) {
        String sql = query + "WHERE email=? and pass=?";
        User user = jdbcTemplateObject
                .queryForObject(
                        sql,
                        new Object[]{email, password},
                        new UserRowMapper());
        return user;
    }

    @Override
    public List<User> all() {
        List<User> list = jdbcTemplateObject
                .query(query, new UserRowMapper());
        return list;
    }

    @Override
    public void delete(Integer userid) {
        String sql = "DELETE FROM user "
                + "WHERE userid=?";
        jdbcTemplateObject.update(sql,
                new Object[]{userid});
    }

    @Override
    public void update(Integer userid, String name, String password, String email, String phone, String type) {
        String sql = "UPDATE user "
                + "SET "
                + " name=?, pass=?, email=?, phone=?, type=? "
                + "WHERE userid=?";
        jdbcTemplateObject.update(sql,
                new Object[]{name, password, email, phone, type, userid});
    }

}
