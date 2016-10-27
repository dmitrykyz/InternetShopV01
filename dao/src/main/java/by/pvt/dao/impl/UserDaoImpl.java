package by.pvt.dao.impl;

import by.pvt.dao.AbstractDAO;
import by.pvt.entity.User;
import by.pvt.pool.ConnectionPool;
import by.pvt.pool.exception.ConnectionPoolException;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.List;

/**
 * Created by Dmitry on 10/25/2016.
 */
public class UserDaoImpl extends AbstractDAO<Integer, User> {
    private static Logger log = Logger.getLogger(UserDaoImpl.class);
    private static final String CREATE_USER = "INSERT INTO user(login, password, firstName, lastName, userType, inBlackList) VALUES(?, ?, ?, ?, ?, ?);";
    private static final String SELECT_USER_BY_LOGIN = "SELECT * FROM user WHERE login = '";

    public UserDaoImpl() {
    }

    public User getUserByLogin(String login){
        log.info("Getting object User in class UserDaoImpl metod getUserByLogin() by login: " + login);

        String loginForQuery = login;
        User user = new User();

        // opening database connection to MySQL server
        // getting Statement object to execute query
        // executing SELECT query
        try(Connection con = ConnectionPool.getInstance().takeConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SELECT_USER_BY_LOGIN + loginForQuery + "' ")) {

            while (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("password"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setUserType(rs.getInt("userType"));
                user.setInBlackList(rs.getInt("inBlackList"));
            }
        } catch (SQLException | ConnectionPoolException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User getEntityById(Integer id) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean delete(User entity) {
        return false;
    }

    @Override
    public boolean create(User entity) {
        log.info("Create new User in class UserDaoImpl and write in tabel User");

        User user = entity;
        String loginEntity = user.getLogin();
        String passwordEntity = user.getPassword();
        String firstNameEntity = user.getFirstName();
        String lastNameEntity = user.getLastName();
        int userTypeEntity = user.getUserType();
        int inBlackListEntity = user.getInBlackList();

        // opening database connection to MySQL server
        // and getting Statement object to execute query
        try (Connection con = ConnectionPool.getInstance().takeConnection();
             PreparedStatement stmt  = con.prepareStatement(CREATE_USER)) {

            stmt.setString(1, loginEntity);
            stmt.setString(2, passwordEntity);
            stmt.setString(3, firstNameEntity);
            stmt.setString(4, lastNameEntity);
            stmt.setInt(5, userTypeEntity);
            stmt.setInt(6, inBlackListEntity);
            stmt.execute();

        } catch (SQLException | ConnectionPoolException e) {
            e.printStackTrace();
        }


        return true;
    }


    @Override
    public User update(User entity) {
        return null;
    }
}
