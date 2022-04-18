package Project.Services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Statistics {

    public static User[] listUser;

    // getter and setter of listUser
    public static User[] getListUser() {
        return listUser;
    } public static void setListUser(User[] listUser) {
        Statistics.listUser = listUser;
    }

    /*
        a boolean method, gets the information from the lines that readFromFile() returns,
        iterates through them, splits, only the first token per line gets stored into a LinkedList,
        if the name (a parameter) the user entered is in this list, it will return true, otherwise, print a message, calls the loop and returns false
     */
    public static boolean nameChecker(String name){
        String[] parts;
        List<String> names = new LinkedList<>();

        for (String line: readFromFile()){
            parts = line.split(" ");
            names.add(parts[0]);
        }

        if (names.contains(name)){
            return true;
        }else {
            System.err.println(name + " does not exist!");
            Loops.loop2();
            return false;
        }

    }

    /*
        a void method, calls nameChecker, if it returns true, converts the name (a parameter) to lowercase, prints a message,
        and then iterates through its length, prints the value of the array which correspond to the char of name - a
     */
    public static void codeMorse(String name){
        // asks for a name, gets the name from the list or from the file, breaks it into char and then converts it into morse code
        if (nameChecker(name)){
            String[] code = { ".-", "-...", "-.-.", "-..",  ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..",
                    "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", "|" };
            name = name.toLowerCase();
            System.out.printf("Morse code of %s is ", name);

            for (int i = 0; i < name.length(); i++){
                System.out.print(code[name.charAt(i) - 'a'] + " ");
            }
        }
    }

    /*
        a void method, calls nameChecker, if it returns true, converts the name (a parameter) to uppercase, prints a message,
        tokenizes the name into chars , prints the value of the conversion of each char into int
     */
    public static void asciiValues(String name){
        // asks for a name, gets it from the list or from the file, breaks it into characters and then converts it into ascii values
        if (nameChecker(name)){
            name = name.toUpperCase();
            System.out.printf("%s has these values in ascii encoding: ", name);
            char[] tokens = name.toCharArray();

            for (char token: tokens){
                int ascii = token;
                System.out.print(ascii + "/");
            }
            System.out.println();
        }

    }

    /*
        void method, calls nameChecker, if it returns true, breaks the name(a parameter) into chars,
        declares a key and a encryptedMessage(bot arrays of chars with the length of the name),
        iterates through the length of the name, creates the key, then finds which value corresponds with the
        VIGENERE CIPHER table, the first char of name is a column, the first char of key is row,
        the crossing of these rows and columns are the encrypted values
     */
    public static void encryption(String name){
        // asks for a name, gets the name and its surname, removes the space, convert into uppercase, and encrypts it using vigenere cipher with a keyword as the first name
        if (nameChecker(name)){
            char[] msg = name.toCharArray();

            char[] key = new char[msg.length];
            char[] encryptedMessage = new char[msg.length];

            for (int i = 0, j = 0; i < msg.length; ++i, ++j){
                if (j == name.length()){
                    j = 0;
                }
                key[i] = name.charAt(j);
            }

            for (int i = 0; i< msg.length; ++i){
                encryptedMessage[i] = (char) (((msg[i] + key[i]) % 26) + 'A');
            }

            System.out.println();
            System.out.println("Original name: " + name);
            System.out.println("Encrypted message: " + String.valueOf(encryptedMessage));
        }
    }

    /*
        void method, declares a HashMap of String and Integer. iterates through the lines returned by readFromFIle() method,
        tokenizes each line, each token gets converted into lowercase and gets stored into the HashMap with its occurrence,
        if the map already has this token, raise its occurrence, if the map does not contain the token, store it with the occurrence 1
     */
    public static void wordCounter(){
        Map<String, Integer> map = new HashMap<>();
        String[] tokens;
        int x = 0;
        for (String line: readFromFile()){
            tokens = line.split(" ");
            for (String token: tokens){
                String word = token.toLowerCase();
                if (map.containsKey(word)){
                    int count = map.get(word);
                    map.put(word, count+1);
                }else{
                    map.put(word, 1);
                }
            }
        }

        Set<String> keys = map.keySet();

        TreeSet<String> sortedKeys = new TreeSet<>(keys);

        System.out.printf("%nMap contains:%nKey\t\t\tValue%n");

        for (String key: sortedKeys){
            System.out.printf("%-15s%-15s%n", key, map.get(key));
        }
    }

    /*
        method that returns a List of strings that contains the lines of the text file, reads in a file text,
        declares a null String, while the file has a next line, each line of the text file,
        is stored into the null String, and this String into the List of Strings
     */
    public static List<String> readFromFile(){
        List<String> lines = new ArrayList<String>();
        try{
            FileReader fileReader = new FileReader("storage.txt");
            BufferedReader br = new BufferedReader(fileReader);
            String line = null;
            while ((line = br.readLine()) != null){
                lines.add(line);
            }
        }
        catch (IOException | Error e){
            System.err.println(e.getMessage());
        }
        return lines;
    }

    /*
        method that converts each line of the text file(gets information from readFromFIle() method),
        into User objects, and stores these objects into the listUser
     */
    public static void storageOfUsers(){
        String[] parts;

        User[] listUser = new User[readFromFile().size()];
        int x = 0;
        for (String token: readFromFile()){
            parts = token.split(" ");
            listUser[x] = new User(parts[0], parts[1], parts[2], parts[3]);
            x++;
        }

        setListUser(listUser);
    }

    // asks the user from where he wants to sort te employees(name, lName, position code) and then displays the output
    // gets the information from listUser
    // uses streams to convert to list, to stream, to map, to print, to compare etc.
    public static void baseSorting(){
        Scanner input = new Scanner(System.in);
        System.out.println("Do you want to sort by:\nName (N)\nSurname (S)\nPosition (P)\nCode (C)\n\nEXIT (E)");
        try{
            String userInput = input.next();
            if (userInput.equalsIgnoreCase("n")){
                System.out.println("\nSorting by name: ");
                Arrays.asList(getListUser()).stream().sorted(Comparator.comparing(User::getUserFirstName)).forEach(System.out::println);
            }else if (userInput.equalsIgnoreCase("s")){
                System.out.println("\nSorting by surname: ");
                Arrays.asList(getListUser()).stream().sorted(Comparator.comparing(User::getUserLastName)).forEach(System.out::println);
            }else if (userInput.equalsIgnoreCase("p")){
                System.out.println("\nSorting by position: ");
                Arrays.asList(getListUser()).stream().sorted(Comparator.comparing(User::getUserPosition)).forEach(System.out::println);
            }else if (userInput.equalsIgnoreCase("c")){
                System.out.println("\nSorting by code: ");
                Arrays.asList(getListUser()).stream().sorted(Comparator.comparing(User::getUserCode)).forEach(System.out::println);
            }else if (userInput.equalsIgnoreCase("e")){
                Loops.loop2();
            }else{
                System.err.println("Not an option! Try Again");
                baseSorting();
            }
        }catch (InputMismatchException e){
            e.printStackTrace();
        }catch (Error er){
            System.err.println(er.getMessage());
        }

    }
}
