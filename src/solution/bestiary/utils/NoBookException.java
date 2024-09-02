package solution.bestiary.utils;

public class NoBookException extends Exception {
    public NoBookException() {
        super("You don't have a bestiary!");
    }
}
