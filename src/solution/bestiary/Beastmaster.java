package solution.bestiary;

import solution.bestiary.utils.NoBookException;

import java.util.Objects;

public final class Beastmaster {
    private Bestiary myBook;
    private final String name;

    public Beastmaster(String name) {
        this.name = name;
    }

    public void newBook() {
        this.myBook = new Bestiary();
    }

    public double getPower() {
        return myBook.calcPower();
    }

    public Bestiary getMyBook() throws NoBookException {
        if (myBook != null) {
            return myBook;
        }
        throw new NoBookException();
    }

    //returns the winner
    public Beastmaster battle(Beastmaster enemy) {
        if (this.getPower() > enemy.getPower()) return this;
        return enemy;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if(obj instanceof Beastmaster that) {
            return Objects.equals(this.name, that.getName());
        }
        return false;
    }

    @Override
    public String toString() {
        return "Beastmaster " + name;
    }
}
