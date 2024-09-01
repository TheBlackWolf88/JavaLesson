package solution.bestiary;

import solution.bestiary.beast.*;
import solution.bestiary.utils.BeastType;

public final class Beastmaster {
    private Bestiary myBook;
    private final String name;

    public Beastmaster(String name) {
        this.name = name;
    }

    public void pledgeBook(BeastType bt) {
        switch (bt) {
            case Oxlike -> myBook = new Bestiary<Oxlike>();
            case Birdlike -> myBook = new Bestiary<Birdlike>();
            case Wolflike -> myBook = new Bestiary<Wolflike>();
            case Fishlike -> myBook = new Bestiary<Fishlike>();
            case Antlike -> myBook = new Bestiary<Antlike>();
        }
    }

    public double getPower() {
        return myBook.calcPower();
    }

    public Bestiary getMyBook() {
        return myBook;
    }

    //returns the winner
    public Beastmaster battle(Beastmaster enemy) {
        if (this.getPower() > enemy.getPower()) return this;
        return enemy;
    }

    public String getName() {
        return name;
    }
}
