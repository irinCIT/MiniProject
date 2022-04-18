package Project.Services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class AddUser {

    public static Scanner input = new Scanner(System.in);

    public static User u;

    // a static LinkedList object so all the methods can use it
    public static LinkedList<User> listOfUsers;

    /*
        a method than returns a LinkedList and has an u (Project.Services.User parameter),
        firstly checks the credentials of this user with the validators, if correct, add this user to the list
        if not correct, print a message but don't store it into the list
        printInFIle() method to add this new Project.Services.User to the text file
        displayList() method to print all the users on the terminal
        return this list of users
     */
    public static LinkedList<User> addUser(User u){

        if (ValidateUser.validateStorage(u.getUserFirstName(), u.getUserLastName(), u.getUserPosition(), u.getUserCode())){
            listOfUsers.add(u);
        }else{
            System.out.println("The credentials you entered for are not correct!!");
        }
        printInFile(listOfUsers);

        displayList();
        return listOfUsers;
    }

    /*
    void method that takes a LinkedList as a parameter, reads all the actual lines of the text file,
    stores them into an Array list, iterates through the users in the listOfUsers, adds them to the ArrayList
    iterates the ArrayList and prints all the lines into the text file
     */
    public static void printInFile(LinkedList<User> list){
        Iterator<User> iterator = list.iterator();
        try{
            FileReader fileReader = new FileReader("C:\\Users\\User\\eclipse-workspace\\MiniProject\\src\\Project\\Services\\storage.txt");
            BufferedReader br = new BufferedReader(fileReader);
            List<String> lines = new ArrayList<String>();
            String line = null;
            while ((line = br.readLine()) != null){
                lines.add(line);
            }
            while (iterator.hasNext()){
                lines.add(iterator.next().toString());
            }
            br.close();
            FileWriter file = new FileWriter(("C:\\Users\\User\\eclipse-workspace\\MiniProject\\src\\Project\\Services\\storage.txt"));
            for (String str: lines){
                file.write(str + "\r\n");
            }
            file.close();
        }catch (IOException | Error e){
            System.err.println(e.getMessage());
        }
    }

    /*
        void method, to read all the lines from the text file, store them into an ArrayList,
        iterate through this ArrayList and print the lines into the terminal
     */
    public static void displayList(){
        System.out.println("\nUsers registered are: ");
        try{
            FileReader fileReader = new FileReader("C:\\Users\\User\\eclipse-workspace\\MiniProject\\src\\Project\\Services\\storage.txt");
            BufferedReader br = new BufferedReader(fileReader);
            List<String> lines = new ArrayList<String>();
            String line = null;
            while ((line = br.readLine()) != null){
                lines.add(line);
            }

            for (String str: lines){
                System.out.println(str);
            }
            System.out.println();
        }catch (IOException | Error e){
            System.out.println(e.getMessage());
        }
    }

    /*
        a Project.Services.User method, prints messages to inform the user what credentials he/she should enter,
        gets these inputs, checks them into the validators, if they are in the correct form,
        create a Project.Services.User object and the methods returns this object or null if the credentials are not in the requested format
     */
    public static User enterUserCredentials(){

        Scanner input = new Scanner(System.in);
        System.out.println("\nEnter name:");
        try{
            String userName = input.next();
            if (ValidateUser.validateUserName(userName)){
                System.out.println("Enter last name: ");
                String surname = input.next();
                if (ValidateUser.validateUserLastName(surname)){
                    System.out.println("Enter position: ");
                    String position = input.next();;
                    if (ValidateUser.validateUserPosition(position)){
                        System.out.println("Enter user code: ");
                        String code = input.next();
                        if (ValidateUser.validateUserCode(code)){
                            u = new User(userName, surname, position, code);
                            return u;
                        }else {
                            System.err.println("\nThe code should have started with 000 and 4 numbers from 1 to 4\n***0001234*** is an example\nTry Again!");
                            enterUserCredentials();
                        }
                    }else {
                        System.err.println("\nThe position is only one word capitalised\n***Position*** is an example\nTry Again!");
                        enterUserCredentials();
                    }
                }else{
                    System.err.println("\nThe last name should contain only one word capitalised\n***Lastname*** is an example\nTry Again!");
                    enterUserCredentials();
                }
            }else {
                System.err.println("\nThe first name should contain only one word capitalised\n***Firstname*** is an example\nTry Again!");
                enterUserCredentials();
            }
        }catch (InputMismatchException e){
            System.err.println("Invalid input!");
        }catch (Error eg){
            System.err.println(eg.getMessage());
        }
        return null;
    }
}
