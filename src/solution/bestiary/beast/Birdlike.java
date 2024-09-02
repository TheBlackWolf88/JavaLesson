package solution.bestiary.beast;

import solution.bestiary.utils.Size;

public final class Birdlike extends Beast{


    @Override
    public String type() {
        return "Birdlike";
    }

    @Override
    public int getMultiplier() {
        return 4;
    }

    public Birdlike(String name, String color, double powerLevel, Size size, String cry) {
        super(name, color, powerLevel, size, cry);
    }
}
