package solution.bestiary.beast;

public final class Antlike extends Beast{

    @Override
    public void speak() {
        System.out.println("...");
    }

    @Override
    public String type() {
        return "Antlike";
    }

    @Override
    public int getMultiplier() {
        return 1;
    }



    public Antlike(String name, String color, double powerLevel) {
        super(name, color, powerLevel);
    }
}
