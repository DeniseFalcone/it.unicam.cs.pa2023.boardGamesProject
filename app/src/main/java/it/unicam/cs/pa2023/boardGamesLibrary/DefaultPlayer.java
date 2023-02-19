package it.unicam.cs.pa2023.boardGamesLibrary;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class DefaultPlayer<E extends DefaultGame, D extends DefaultCoordinateMapper> implements Player<E>{

    private int score;
    private Scanner scanner;
    private String name;
    private Colors color;
    private ArrayList<Piece> playersPieces;
    private D defaultCoordinateMapper;

    public DefaultPlayer(String name, Colors color, ArrayList<Piece> playersPieces, int score, D defaultCoordinateMapper) {
        this.name = name;
        this.color = color;
        this.playersPieces = playersPieces;
        this.score = score;
        this.defaultCoordinateMapper = defaultCoordinateMapper;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Colors getColor() {
        return color;
    }

    public void setColor(Colors color) {
        this.color = color;
    }

    public ArrayList<Piece> getPlayersPieces() {
        return playersPieces;
    }

    public void setPlayersPieces(ArrayList<Piece> playersPieces) {
        this.playersPieces = playersPieces;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public D getDefaultCoordinateMapper() {
        return defaultCoordinateMapper;
    }

    public void setDefaultCoordinateMapper(D defaultCoordinateMapper) {
        this.defaultCoordinateMapper = defaultCoordinateMapper;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultPlayer that = (DefaultPlayer) o;
        return Objects.equals(getName(), that.getName()) && getColor() == that.getColor() && Objects.equals(getPlayersPieces(), that.getPlayersPieces());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getColor(), getPlayersPieces());
    }

    @Override
    public String toString() {
        return "DefaultPlayer: " +
                "name='" + name + '\'' +
                ", color=" + color;
    }

    @Override
    public Piece selectPiece() {
        String chosenPiece;
        this.scanner = new Scanner(System.in);
        boolean pieceExist = true;
        do{
            System.out.println("Select a piece: ");
            showPiece();
            chosenPiece = inputString();
            pieceExist = checkValidPieceId(chosenPiece);
        }while (!pieceExist);
        this.scanner.close();
        return this.getPlayersPieces().get(Integer.parseInt(chosenPiece)-1);
    }

    private void showPiece(){
        int pieceId = 0;
        for(Piece piece : this.getPlayersPieces()){
            System.out.println(pieceId + ". " + piece.toString());
            pieceId++;
        }
    }

    private boolean checkValidPieceId(String chosenPiece){
        if(Integer.parseInt(chosenPiece) >= this.getPlayersPieces().size()){
            System.out.println("The piece id is not valid. Please insert a valid number.");
            return false;
        }else{
            return true;
        }
    }

    @Override
    public Coordinate insertCoordinate() {
        System.out.println("Insert a set of coordinate separated by comma: ");
        this.scanner = new Scanner(System.in);
        String input = inputString();
        String[] coordinateInput = input.split(",");
        Integer[] coordinates = mapCoordinate(coordinateInput);
        return new Coordinate(coordinates[0], coordinates[1], coordinates[2]);
    }

    private Integer[] mapCoordinate(String[] inputCoordinate){
        Integer[] coordinateArray = new Integer[3];
        if(inputCoordinate.length == 2){
            coordinateArray[2] = Integer.valueOf(1);
        }
        for (int i=0; i<inputCoordinate.length; i++) {
            if(!isNumeric(inputCoordinate[i])){
                Character character = Character.valueOf(inputCoordinate[i].toCharArray()[0]);
                coordinateArray[i] = defaultCoordinateMapper.getValueFromMap(character);
            }else{
                coordinateArray[i] = Integer.parseInt(inputCoordinate[i]);
            }
        }
        return coordinateArray;
    }

    private boolean isNumeric(String string) {
        if (string == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(string);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    @Override
    public E chooseGame(ArrayList<E> listOfGames) {
        String chosenGame;
        this.scanner = new Scanner(System.in);
        boolean gameExist = true;
        do{
            System.out.println("Select the game you want to play:\n");
            showAvailableGames(listOfGames);
            chosenGame = inputString();
            gameExist = checkValidGameId(listOfGames,chosenGame);
        }while (!gameExist);
        this.scanner.close();
        return listOfGames.get(Integer.parseInt(chosenGame)-1);
    }

    private boolean checkValidGameId(ArrayList<E> listOfGames, String chosenGame){
        if(Integer.parseInt(chosenGame) >= listOfGames.size()){
            System.out.println("The game id is not valid. Please insert a valid number.");
            return false;
        }else{
            return true;
        }
    }

    private void showAvailableGames(ArrayList<E> listOfGames){
        int gameId = 0;
        for(E game : listOfGames){
            System.out.println(gameId + ". " + game.getGameName());
            gameId++;
        }
    }

    private String inputString(){
        String input;
        input = this.scanner.next();
        return input;
    }
}
