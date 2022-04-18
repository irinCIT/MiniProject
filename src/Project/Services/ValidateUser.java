package Project.Services;

public class ValidateUser {

    public static boolean validateUserName(String inputName){
//        Name
        return inputName.matches("[A-Z][a-zA-Z]*");
    }

    public static boolean validateUserLastName(String inputLastName){
//        Surname
        return inputLastName.matches("[A-Z][a-zA-Z]*");
    }

    public static boolean validateUserPosition(String inputPosition){
//        Position
        return inputPosition.matches("[A-Z][a-zA-Z]*");
    }

    public static boolean validateUserCode(String inputCode){
//        0001234
        return inputCode.matches("(000)?[0-5]\\d{3}+");
    }

    public static boolean validateStorage(String name, String lName, String pos, String code){
        return validateUserName(name) && validateUserLastName(lName) && validateUserPosition(pos) && validateUserCode(code);
    }
}
