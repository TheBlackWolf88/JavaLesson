package solution.bestiary.beast;

import solution.bestiary.utils.Size;

public final class Wolflike extends Beast{


    @Override
    public String type() {
        return "Wolflike";
    }

    @Override
    public int getMultiplier() {
        return 3;
    }

    public Wolflike(String name, String color, double powerLevel, Size size, String cry) {
        super(name, color, powerLevel, size, cry);
    }
}
