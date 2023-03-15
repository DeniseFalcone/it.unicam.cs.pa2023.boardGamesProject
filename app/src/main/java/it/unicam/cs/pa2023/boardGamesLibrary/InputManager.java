package it.unicam.cs.pa2023.boardGamesLibrary;

import java.util.Scanner;

/**
 * This class is used to manage the input.
 */
public class InputManager {

    private static InputManager inputOutputManager;
    private Scanner scanner;

    private InputManager(){}

    public static InputManager getInstance(){
        if (inputOutputManager == null) {
            inputOutputManager = new InputManager();
        }
        return inputOutputManager;
    }

    /**
     * This method takes a string from the user and returns it.
     *
     * @return the string inserted by the user.
     */
    public String inputString(){
        String input;
        this.scanner = new Scanner(System.in);
        input = this.scanner.next();
        return input;
    }


    /**
     * This method is used to close the scanner.
     */
    public void closeScanner() {
        this.scanner.close();
    }


}
