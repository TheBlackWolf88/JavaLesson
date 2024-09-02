package solution.bestiary.beast;

import solution.bestiary.utils.Size;

public final class Oxlike extends Beast{


    @Override
    public String type() {
        return "Oxlike";
    }

    @Override
    public int getMultiplier() {
        return 5;
    }

    public Oxlike(String name, String color, double powerLevel, Size size, String cry) {
        super(name, color, powerLevel, size, cry);
    }
}
