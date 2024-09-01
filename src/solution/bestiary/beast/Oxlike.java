package solution.bestiary.beast;

public final class Oxlike extends Beast{

    @Override
    public void speak() {
        System.out.println("Moo");
    }

    @Override
    public String type() {
        return "Oxlike";
    }

    @Override
    public int getMultiplier() {
        return 5;
    }



    public Oxlike(String name, String color, double powerLevel) {
        super(name, color, powerLevel);
    }
}
