package it.unicam.cs.pa2023.boardGamesLibrary;

/**
 * This enumeration is used to define the possible colors that we can find in a chessboard game.
 */
public enum Colors {

    DARK, LIGHT, BASECOLOR;

    /**
     * If the current color is DARK, return LIGHT, if it's LIGHT then return DARK and if it's BASECOLOR return BASECOLOR.
     *
     * @return the switched color.
     */
    public Colors changeColor(){
        return switch (this){
            case DARK -> LIGHT;
            case LIGHT -> DARK;
            case BASECOLOR -> BASECOLOR;
        };
    }

}
