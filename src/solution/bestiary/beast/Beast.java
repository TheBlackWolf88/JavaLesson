package solution.bestiary.beast;
import solution.bestiary.utils.Size;
import java.util.Objects;

public abstract class Beast implements Comparable<Beast> {
    private final String name;
    private final String color;
    private final double  powerLevel;
    private final Size size;

    public abstract void speak();

    public abstract String type();

    public double getPowerLevel() {
        return powerLevel;
    }

    public abstract int getMultiplier();

    public Beast(String name, String color, double powerLevel, Size size) {
        this.name = name;
        this.color = color;
        this.powerLevel = powerLevel*getMultiplier();
        this.size = size;
    }

    public String getName() {
        return name;
    }

    //Ez azért lesz jó, mert csak a containsnél fogjuk alkalmazni, amúgy annyira nem jó
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Beast that) {
            return Objects.equals(this.name, that.name);
        }
        return false;
    }

    @Override
    public int compareTo(Beast o) {
        return (int) (this.powerLevel - o.powerLevel);
    }

    @Override
    public String toString() {
       return "(" + name + ", " + type() + ", " + color + ", " + size + ", " + String.format("%.2f", powerLevel);
    }
}
