package it.unicam.cs.pa2023.boardGamesLibrary;

import java.util.ArrayList;
import java.util.Optional;


/**
 * Default implementation of the Board interface.
 * It has 4 attributes: width, height and the numberOfBoard represent the dimension of the chessboard while board is
 * an array of cells used to describe the chessboard.
 */
public class DefaultBoard implements Board {

    private ArrayList<Cell> board;
    private int width, height, numberOfBoard;

    /**
     * DefaultBoard constructor that creates the board changing the color of the cells between DARK and LIGHT.
     *
     * @param width width of the board.
     * @param height height of the board.
     * @param numberOfBoard number of boards.
     * @param initialColor color of the cell first cell of the chessboard (of coordinates 1,1,1).
     */
    public DefaultBoard(int width, int height, int numberOfBoard, Colors initialColor) {
        checkParams(width, height, numberOfBoard);
        this.width = width;
        this.height = height;
        this.numberOfBoard = numberOfBoard;
        this.board = createBoardCells(initialColor);
    }

    /**
     * DefaultBoard constructor that creates the board with all the cells of the same color (BASECOLOR).
     *
     * @param width width of the board.
     * @param height height of the board.
     * @param numberOfBoard number of boards.
     */
    public DefaultBoard(int width, int height, int numberOfBoard) {
        checkParams(width, height, numberOfBoard);
        this.width = width;
        this.height = height;
        this.numberOfBoard = numberOfBoard;
        this.board = createBoardCells(Colors.BASECOLOR);
    }

    /**
     * This method checks if the parameters passed are less than the required amount, and if they are it throws an
     * IllegalArgumentException.
     *
     * @param width The width of the board.
     * @param height The height of the board.
     * @param nBoard The number of boards to be generated.
     */
    private void checkParams(int width, int height, int nBoard){
        if(width <= 0 || height <= 0 || nBoard < 1){
            throw new IllegalArgumentException("The parameters passed are less than the required amount.");
        }
    }

    /**
     * Given the color of the first cell, it creates a board of cells
     * (changing the color for every cell if the first color is LIGHT or DARK and keeping the same
     * one if the color passed is BASECOLOR) and returns it.
     *
     * @param color the color of the first cell of the board.
     * @return An ArrayList of cells.
     */
    private ArrayList<Cell> createBoardCells(Colors color){
        ArrayList<Cell> board = new ArrayList<>();
        for(int n=1; n<=this.getnumberOfBoard(); n++){
            for(int i=1; i<=this.getWidth(); i++){
                for(int j=1; j<=this.getHeight(); j++){
                    Coordinate coordinate = new Coordinate(i, j, n);
                    Cell cell = new Cell(coordinate, color, Optional.empty());
                    color = color.changeColor();
                    board.add(cell);
                }
                if(this.getHeight()%2 == 0){
                    color = color.changeColor();
                }
            }
        }
        return board;
    }

    @Override
    public boolean checkIfCoordinateIsValid(Coordinate coordinate) {
        return this.getCellFromCoordinate(coordinate).isPresent();
    }

    @Override
    public Optional<Cell> getCellFromCoordinate(Coordinate coordinate) {
        for(Cell cell : this.getBoard()){
            if(cell.getCoordinate().equals(coordinate)){
                return Optional.of(cell);
            }
        }
        return Optional.empty();
    }

    @Override
    public Cell getCellFromPiece(Piece piece) {
        for(Cell cell : this.getBoard()){
            if(cell.getPieceOptional().equals(Optional.of(piece))){
                return cell;
            }
        }
        throw new NullPointerException("The passed piece is not in the board.");
    }



    @Override
    public ArrayList<Cell> getCellsWithPiecesOfOneColor(Colors pieceColor) {
        ArrayList<Cell> colorPieceList = new ArrayList<>();
        for(Cell cell : this.getBoard()){
            if(cell.hasPiece()){
                if(cell.getPieceOptional().get().getColor().equals(pieceColor)){
                    colorPieceList.add(cell);
                }
            }
        }
        return colorPieceList;
    }


    @Override
    public boolean removeAllPieces() {
        for (Cell cell : this.getBoard()){
            if(cell.hasPiece()){
                cell.setPieceOptional(Optional.empty());
            }
        }
        return checkIfBoardIsEmpty();
    }

    @Override
    public ArrayList<Cell> getCellsFromDirection(Coordinate coordinate, Integer[] direction) {
        Action<DefaultBoard> action = new DefaultAction<>();
        ArrayList<Cell> cells = new ArrayList<>();
        while(getCellFromCoordinate(action.getCoordinateFromDirection(coordinate, direction[0], direction[1], direction[2])).isPresent()){
            Cell cell = getCellFromCoordinate(action.getCoordinateFromDirection(coordinate,direction[0], direction[1], direction[2])).get();
            cells.add(cell);
            coordinate = action.getCoordinateFromDirection(coordinate, direction[0], direction[1], direction[2]);
        }
        return cells;
    }

    /**
     * If any cell in the board has a piece, return false, otherwise return true.
     *
     * @return true if the board is empty, false otherwise.
     */
    private boolean checkIfBoardIsEmpty(){
        for (Cell cell : this.getBoard()){
            if(cell.hasPiece()){
                return false;
            }
        }
        return true;
    }

    @Override
    public void replacePieceInCell(Coordinate newCoordinate, Optional<Piece> piece) {
        Optional<Cell> cell = getCellFromCoordinate(newCoordinate);
        if(cell.isPresent()){
            cell.get().setPieceOptional(piece);
            this.getBoard().set(this.getBoard().indexOf(cell.get()), cell.get());
        }
    }

    @Override
    public ArrayList<Optional<Cell>> getCellNeighbours(Coordinate coordinate){
        DefaultAction<DefaultBoard> action = new DefaultAction<>();
        ArrayList<Optional<Cell>> neighboursCell = new ArrayList<>();
        neighboursCell.add(getCellFromCoordinate(action.verticalMovement(coordinate,1)));
        neighboursCell.add(getCellFromCoordinate(action.verticalMovement(coordinate,-1)));
        neighboursCell.add(getCellFromCoordinate(action.horizontalMovement(coordinate,1)));
        neighboursCell.add(getCellFromCoordinate(action.horizontalMovement(coordinate,-1)));
        neighboursCell.add(getCellFromCoordinate(action.diagonalMovement(coordinate,-1,1)));
        neighboursCell.add(getCellFromCoordinate(action.diagonalMovement(coordinate,-1,-1)));
        neighboursCell.add(getCellFromCoordinate(action.diagonalMovement(coordinate,1,1)));
        neighboursCell.add(getCellFromCoordinate(action.diagonalMovement(coordinate,1,-1)));
        return neighboursCell;
    }

    public ArrayList<Cell> getBoard() {
        return board;
    }

    public void setBoard(ArrayList<Cell> board) {
        this.board = board;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getnumberOfBoard() {
        return numberOfBoard;
    }

    public void setNumberOfBoard(int numberOfBoard) {
        this.numberOfBoard = numberOfBoard;
    }
}
