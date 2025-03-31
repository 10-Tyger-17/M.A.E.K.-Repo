package main;

import controller.Controller;

/**
 * The Main class serves as the entry point for the application.
 * It initializes the Controller and displays the login screen.
 */
public class Main {

    /**
     * The main method is the entry point of the application.
     * It creates an instance of the Controller and shows the login screen.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Controller frameLogin = new Controller();
        frameLogin.showScreen();
    }
}