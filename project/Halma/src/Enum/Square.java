package Enum;

public enum Square{
    Black,Red,White,Green;
    public static Square of(int index){
        if (index < 0 || index >= Square.values().length)
            throw new IllegalArgumentException();

        return Square.values()[index];
    }
}