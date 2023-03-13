package it.unicam.cs.pa2023.boardGamesLibrary;

import java.util.Scanner;
import java.util.regex.Pattern;

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

    /**
     * Given a string, this method checks if the input is not null and matches the pattern
     * of a letter or number, followed by a comma, followed by a number.
     *
     * @param string The string to be checked.
     * @return true if the string matches the pattern and false otherwise.
     */
    public boolean checkCoordinateInput(String string){
        return string != null && Pattern.matches("[a-zA-Z0-9,]+,[0-9]+", string);
    }
}
