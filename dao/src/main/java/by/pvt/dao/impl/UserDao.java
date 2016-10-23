package by.pvt.dao.impl;

import by.pvt.dao.IDao;
import by.pvt.dao.exception.DaoException;
import by.pvt.entity.User;
import by.pvt.pool.ConnectionPool;
import by.pvt.pool.exception.ConnectionPoolException;

import java.io.Serializable;
import java.sql.*;
import java.util.List;

/**
 * Created by Dmitry on 10/23/2016.
 */
public class UserDao<User, String extends Serializable> implements IDao<User, String> {

    private static final java.lang.String GET_USER_LIST_QUERY = "SELECT * FROM USER";
    private static final java.lang.String GET_USER_QUERY = "SELECT * FROM user WHERE login = ?";
    private static final java.lang.String UPDATE_USER_QUERY = "UPDATE USER SET USER_password = ? WHERE USER_login = ?";
    private static final java.lang.String DELETE_USER_QUERY = "DELETE FROM USER WHERE USER_login = ?";
    private static final java.lang.String CREATE_USER_QUERY = "INSERT INTO USER VALUES(?,?,?,?)";

    // JDBC variables for opening and managing connection


    public UserDao() {
    }

    public User get(String login) throws DaoException {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String loginForQuery = login;
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

                System.out.println("userid : " + userid);
                System.out.println("username : " + username);
                System.out.println("userpass : " + userpass);
                System.out.println("userfirstName : " + userfirstName);
                System.out.println("userlastName : " + userlastName);
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
        return null;
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
