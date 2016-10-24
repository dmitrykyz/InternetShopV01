package by.pvt.entity;

/**
 * Created by Dmitry on 10/23/2016.
 */
public class User {
    private int id;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private int userType = 0; //0 - user; 1 - admin
    private int inBlackList = 0; //0 - not in blackList; 1 - in blackList

    public User() {
    }

    public User(int id, String login, String password, String firstName, String lastName, int userType, int inBlackList) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userType = userType;
        this.inBlackList = inBlackList;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getUserType() {
        return userType;
    }

    public int getInBlackList() {
        return inBlackList;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public void setInBlackList(int inBlackList) {
        this.inBlackList = inBlackList;
    }

}
