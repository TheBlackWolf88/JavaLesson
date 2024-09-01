package solution.bestiary.utils;

public class DuplicateNameException extends Exception {
    public DuplicateNameException() {
        super("There is already a beast called like that in this bestiary");
    }
}
