package it.unicam.cs.pa2023.boardGamesLibrary;

import java.util.ArrayList;
import java.util.Optional;

public class DefaultBoard implements Board {

    private ArrayList<Cell> board;
    private int width, height, numberOfBoard;

    public DefaultBoard(int width, int height, int numberOfBoard, Colors initialColor) {
        checkParams(width, height, numberOfBoard);
        this.width = width;
        this.height = height;
        this.numberOfBoard = numberOfBoard;
        this.board = createBoardCells(initialColor);
    }

    public DefaultBoard(int width, int height, int numberOfBoard) {
        checkParams(width, height, numberOfBoard);
        this.width = width;
        this.height = height;
        this.numberOfBoard = numberOfBoard;
        this.board = createBoardCells(Colors.LIGHT);
        for (Cell c: this.getBoard()) {
            c.setColor(Colors.LIGHT);
        }
    }

    private void checkParams(int width, int height, int nBoard){
        if(width <= 0 || height <= 0 || nBoard < 1){
            throw new IllegalArgumentException("The parameters passed are less than the required amount.");
        }
    }

    /**
     * It creates a board of cells with the given color and returns it.
     *
     * @param color the color of the first cell of the board
     * @return An ArrayList of Cells.
     */
    private ArrayList<Cell> createBoardCells(Colors color){
        ArrayList<Cell> board = new ArrayList<>();
        for(int n=1; n<=this.getnumberOfBoard(); n++){
            for(int i=1; i<=this.getWidth(); i++){
                for(int j=1; j<=this.getHeight(); j++){
                    Coordinate coordinate = new Coordinate(Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(n));
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

    //ToDO
    @Override
    public boolean isActionValid(Coordinate coordinate) {
        return false;
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
            if(cell.getPieceOptional().isPresent()){
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
            if(cell.getPieceOptional().isPresent()){
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

    private boolean checkIfBoardIsEmpty(){
        for (Cell cell : this.getBoard()){
            if(cell.getPieceOptional().isPresent()){
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
