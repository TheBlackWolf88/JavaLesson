package solution.bestiary.beast;

public final class Fishlike extends Beast{
    @Override
    public void speak() {
        System.out.println("Glug");
    }

    @Override
    public String type() {
        return "Fishlike";
    }

    @Override
    public int getMultiplier() {
        return 2;
    }



    public Fishlike(String name, String color, double powerLevel) {
        super(name, color, powerLevel);
    }
}
