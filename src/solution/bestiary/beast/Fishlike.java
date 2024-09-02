package solution.bestiary.beast;

import solution.bestiary.utils.Size;

public final class Fishlike extends Beast{

    @Override
    public String type() {
        return "Fishlike";
    }

    @Override
    public int getMultiplier() {
        return 2;
    }

    public Fishlike(String name, String color, double powerLevel, Size size, String cry) {
        super(name, color, powerLevel, size, cry);
    }
}
