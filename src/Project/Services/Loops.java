package Project.Services;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Loops {
    public static Scanner input = new Scanner(System.in);

    public static void loop(){
        int index = 0;
        System.out.println("\nYou can\nAdd (A)\nDelete (D)\nStatistics (S)\nEXIT (E)");
        try{
            String answer = input.next();

            if (answer.equalsIgnoreCase("a")){
                //add user
                AddUser.addUser(AddUser.enterUserCredentials());
            }
            else if (answer.equalsIgnoreCase("d")){
                //delete user
                System.out.println("\nEnter code: ");
                try{
                    String code = input.next();
                    DeleteUser.deleteFromFIle(code);
                }catch (InputMismatchException e){
                    System.err.println("Invalid type of input!");
                }catch (Error eg){
                    System.err.println(eg.getMessage());
                }
            }else if (answer.equalsIgnoreCase("s")){
                //statistics
                loop2();
            }else if (answer.equalsIgnoreCase("e")){
                //exit
                System.exit(1);
            }else{
                System.err.println("That was not an option, try again");
                loop();
            }
            loop();
        }catch (InputMismatchException e){
            System.err.println("Invalid!");
        }catch (Error eg){
            System.err.println(eg.getMessage());
        }
    }

    public static void loop2(){
        System.out.println("""
                
                You can convert a name into:\s
                Morse Code (M)
                ASCII encoding (A)
                Encryption with Vigenere Cipher (V)
                Sort employees however you want (S)
                Count the names (C)
                EXIT (E)
                """);

        try{
            String answer = input.next();
            if (answer.equalsIgnoreCase("m") || answer.equalsIgnoreCase("a") || answer.equalsIgnoreCase("v")){
                //if the users wants either one of code morse, ascii encoding or encryption with vigenere cipher the systems asks for a name
                System.out.println("Enter the name");
                try{
                    String name= input.next();
                    if (answer.equalsIgnoreCase("m")){
                        Statistics.codeMorse(name);
                        loop2();
                    }else if (answer.equalsIgnoreCase("a")){
                        Statistics.asciiValues(name);
                        loop2();
                    }else {
                        Statistics.encryption(name);
                        loop2();
                    }
                }catch (InputMismatchException e){
                    System.err.println("That is not a proper name!");
                }catch (Error eg){
                    System.err.println(eg.getMessage());
                }
            }else {
                if (answer.equalsIgnoreCase("s")){
                    Statistics.storageOfUsers();  // so the lines of the file get stored into an array of User
                    Statistics.baseSorting();
                    loop2();
                }else if (answer.equalsIgnoreCase("c")){
                    Statistics.wordCounter();
                    loop2();
                }else if (answer.equalsIgnoreCase("e")){
                    loop();
                }
            }
        }catch (InputMismatchException eg){
            System.err.println("Invalid input");
        }catch (Error e){
            e.printStackTrace();
        }
    }
}
