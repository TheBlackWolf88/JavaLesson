package solution.bestiary.beast;

import solution.bestiary.utils.Size;

public final class Antlike extends Beast{

    @Override
    public String type() {
        return "Antlike";
    }

    @Override
    public int getMultiplier() {
        return 1;
    }

    public Antlike(String name, String color, double powerLevel, Size size, String cry) {
        super(name, color, powerLevel, size, cry);
    }
}
