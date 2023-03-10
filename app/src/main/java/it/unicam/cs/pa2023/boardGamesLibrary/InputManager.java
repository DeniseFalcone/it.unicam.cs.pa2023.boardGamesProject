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

    public String inputString(){
        String input;
        this.scanner = new Scanner(System.in);
        input = this.scanner.next();
        return input;
    }


    public void closeScanner() {
        this.scanner.close();
    }

    public boolean checkCoordinateInput(String string){
        return string != null && Pattern.matches("[a-zA-Z0-9,]+,[0-9]+", string);
    }
}
