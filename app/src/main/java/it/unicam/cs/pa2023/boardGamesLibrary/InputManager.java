package it.unicam.cs.pa2023.boardGamesLibrary;

import java.util.Scanner;

public class InputManager {

    private static InputManager inputOutputManager;
    private Scanner scanner = new Scanner(System.in);

    private InputManager(){}

    public static InputManager getInstance(){
        if (inputOutputManager == null) {
            inputOutputManager = new InputManager();
        }
        return inputOutputManager;
    }

    public String inputString(){
        String input;
        input = this.scanner.next();
        return input;
    }





}
