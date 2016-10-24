package by.pvt.dao.impl;

import by.pvt.dao.IDao;
import by.pvt.dao.exception.DaoException;
import by.pvt.pool.ConnectionPool;
import by.pvt.pool.exception.ConnectionPoolException;

import java.io.Serializable;
import java.sql.*;
import java.util.List;

/**
 * Created by Dmitry on 10/23/2016.
 */
public class UserDao<User, String extends Serializable> implements IDao<User, String> {

    public UserDao() {

    }

    public User get(String login) throws DaoException {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String loginForQuery = login;
        by.pvt.entity.User user = new by.pvt.entity.User();


        System.out.println("------------------------" + loginForQuery);
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

                int userid = rs.getInt("id");
                java.lang.String username = rs.getString("login");
                java.lang.String userpass = rs.getString("password");
                java.lang.String userfirstName = rs.getString("firstName");
                java.lang.String userlastName = rs.getString("lastName");
                int userType = rs.getInt("userType");
                int inBlackList = rs.getInt("inBlackList");

                user.setId(userid);
                user.setLogin(username);
                user.setPassword(userpass);
                user.setFirstName(userfirstName);
                user.setLastName(userlastName);
                user.setUserType(userType);
                user.setInBlackList(inBlackList);
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

    public List<User> getAll() throws DaoException {
        return null;
    }

    public void add(User object) throws DaoException {

    }

    public void update(User object) throws DaoException {

    }

    public void delete(User object) throws DaoException {

    }
}
