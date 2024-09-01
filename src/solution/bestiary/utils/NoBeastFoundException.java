package solution.bestiary.utils;

public class NoBeastFoundException extends Exception {
    public NoBeastFoundException() {
        super("No such beast was found");
    }
}
