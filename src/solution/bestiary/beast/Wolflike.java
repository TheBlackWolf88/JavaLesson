package solution.bestiary.beast;

public final class Wolflike extends Beast{

    @Override
    public void speak() {
        System.out.println("Vau");
    }

    @Override
    public String type() {
        return "Wolflike";
    }

    @Override
    public int getMultiplier() {
        return 3;
    }



    public Wolflike(String name, String color, double powerLevel) {
        super(name, color, powerLevel);
    }
}
