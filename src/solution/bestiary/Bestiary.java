package solution.bestiary;

import solution.bestiary.beast.Beast;
import solution.bestiary.utils.DuplicateNameException;
import solution.bestiary.utils.NoBeastFoundException;
import solution.bestiary.utils.SearchTuple;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

public final class Bestiary {
    private final ArrayList<Beast> beasts;

    public Bestiary() {
        this.beasts = new ArrayList<Beast>();
    }

    public double calcPower() {
        return beasts.stream().mapToDouble(Beast::getPowerLevel).sum();
    }

    public void sort(Comparator<Beast> comp) {
        beasts.sort(comp);
    }

    public void add(Beast beast) throws DuplicateNameException {
        if (!beasts.contains(beast)) {
            beasts.add(beast);
        }
        else throw new DuplicateNameException();
    }

    private SearchTuple search(String name) {
        for(int i = 0; i < beasts.size(); i++) {
            Beast el = beasts.get(i);
            if (Objects.equals(el.getName(), name)) {
                return new SearchTuple(i, true);
            }
        }
        return new SearchTuple(-1, false);
    }

    public Beast get(String name) throws NoBeastFoundException {
        SearchTuple st = search(name);
        if (st.found) {
            return beasts.get(st.ind);
        } else throw new NoBeastFoundException();
    }

    public void rem(String name) throws NoBeastFoundException {
        SearchTuple st = search(name);
        if (st.found) {
            beasts.remove(st.ind);
        }
        else throw new NoBeastFoundException();
    }

    @Override
    public String toString() {
        return "Powerlevel: " + calcPower() + "\nContents\n" + beasts.toString();
    }
}
