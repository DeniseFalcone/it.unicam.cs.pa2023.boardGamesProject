package it.unicam.cs.pa2023.boardGamesLibrary;

public enum Colors {

    DARK, LIGHT, BASECOLOR;


    /**
     * If the current color is DARK, return LIGHT, otherwise return DARK.
     *
     * @return A Colors object
     */
    public Colors changeColor(){
        return switch (this){
            case DARK -> LIGHT;
            case LIGHT -> DARK;
            case BASECOLOR -> BASECOLOR;
        };
    }

}
