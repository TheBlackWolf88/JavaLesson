package solution.bestiary.beast;

public final class Birdlike extends Beast{

    @Override
    public void speak() {
        System.out.println("Csiip");
    }

    @Override
    public String type() {
        return "Birdlike";
    }

    @Override
    public int getMultiplier() {
        return 4;
    }



    public Birdlike(String name, String color, double powerLevel) {
        super(name, color, powerLevel);
    }
}
