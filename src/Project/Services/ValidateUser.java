package Project.Services;

public class ValidateUser {

    // this method, returns a boolean, checks if there is just one word capitalised
    public static boolean validateUserName(String inputName){
//        Name
        return inputName.matches("[A-Z][a-zA-Z]*");
    }

    // this method, returns a boolean, checks if there is just one word capitalised
    public static boolean validateUserLastName(String inputLastName){
//        Surname
        return inputLastName.matches("[A-Z][a-zA-Z]*");
    }

    // this method, returns a boolean, checks if there is just one word capitalised
    public static boolean validateUserPosition(String inputPosition){
//        Position
        return inputPosition.matches("[A-Z][a-zA-Z]*");
    }

    // this method, returns a boolean, checks if the number starts with 000 and is completed by precisely 4 more numbers in the range 0-5
    public static boolean validateUserCode(String inputCode){
//        0001234
        return inputCode.matches("(000)?[0-5]\\d{3}+");
    }

    // // this method, returns true if all the arguments are validated, false if at least one of them is not valid
    public static boolean validateStorage(String name, String lName, String pos, String code){
        return validateUserName(name) && validateUserLastName(lName) && validateUserPosition(pos) && validateUserCode(code);
    }
}
