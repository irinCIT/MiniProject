package Project.Services;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        AddUser.listOfUsers = new LinkedList<>(); //declaring a LinkedList from the AddUser class
        AddUser.displayList(); // calling the displayList() from the AddUser class
        Loops.loop(); // calling the main loop from Loops class
    }


}
