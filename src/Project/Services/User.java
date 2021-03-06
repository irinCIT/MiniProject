package Project.Services;

public class User {

    protected String userFirstName;
    protected String userLastName;
    protected String userPosition;
    protected String userCode;

    /*
        in this class, it is a User class, with 2 constructors, one of them has 4 arguments, all of them of the String type,
        which are the User credentials. then, there are some simple getters and setters for each parameter.
        in the end there is a toString() method which returns a user object information, all the four credentials, separated by space
     */

    public User(String name, String surname, String pos, String code){
        this.userFirstName = name;
        this.userLastName = surname;
        this.userPosition = pos;
        this.userCode = code;
    }

    public User(){}

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserPosition() {
        return userPosition;
    }

    public void setUserPosition(String userPosition) {
        this.userPosition = userPosition;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    @Override
    public String toString() {
        return userFirstName + " " + userLastName + " " + userPosition + " " + userCode ;
    }
}
