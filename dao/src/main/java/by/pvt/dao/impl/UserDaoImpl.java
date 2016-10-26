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

    public UserDaoImpl() {
    }

    public User getUserByLogin(String login){
        log.info("Getting object User in class UserDaoImpl metod getUserByLogin() by login: " + login);
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String loginForQuery = login;
        User user = new User();

        try {
            // opening database connection to MySQL server
            try {
                con = ConnectionPool.getInstance().takeConnection();
            } catch (ConnectionPoolException e) {
                e.printStackTrace();
            }
            // getting Statement object to execute query
            stmt = con.createStatement();
            // executing SELECT query
            rs = stmt.executeQuery("SELECT * FROM user WHERE login = '" + loginForQuery + "' ");

            while (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("password"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setUserType(rs.getInt("userType"));
                user.setInBlackList(rs.getInt("inBlackList"));
            }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try {
                con.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                stmt.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                rs.close();
            } catch (SQLException se) { /*can't do anything */ }
        }
        return (User)user;
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
        Connection con = null;
        PreparedStatement stmt = null;

        User user = entity;
        String loginEntity = user.getLogin();
        String passwordEntity = user.getPassword();
        String firstNameEntity = user.getFirstName();
        String lastNameEntity = user.getLastName();
        int userTypeEntity = user.getUserType();
        int inBlackListEntity = user.getInBlackList();

        try {
            // opening database connection to MySQL server
            try {
                con = ConnectionPool.getInstance().takeConnection();
            } catch (ConnectionPoolException e) {
                e.printStackTrace();
            }
            // getting Statement object to execute query
            stmt = con.prepareStatement("INSERT INTO user(login, password, firstName, lastName, userType, inBlackList) VALUES(?, ?, ?, ?, ?, ?);");
            stmt.setString(1, loginEntity);
            stmt.setString(2, passwordEntity);
            stmt.setString(3, firstNameEntity);
            stmt.setString(4, lastNameEntity);
            stmt.setInt(5, userTypeEntity);
            stmt.setInt(6, inBlackListEntity);
            stmt.execute();

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try {
                con.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                stmt.clearParameters();
                stmt.close();
            } catch (SQLException se) { /*can't do anything */ }
        }
        return true;
    }

    @Override
    public User update(User entity) {
        return null;
    }
}
