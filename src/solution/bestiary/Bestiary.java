package solution.bestiary;

import solution.bestiary.beast.Beast;
import solution.bestiary.utils.DuplicateNameException;
import solution.bestiary.utils.NoBeastFoundException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

class SearchTuple {
    public boolean found;
    public int ind;

    public SearchTuple(int ind, boolean found) {
        this.ind = ind;
        this.found = found;
    }
}

public final class Bestiary<T extends Beast> {
    private ArrayList<T> beasts;

    public double calcPower() {
        return beasts.stream().mapToDouble(T::getPowerLevel).sum();
    }

    public void sort(Comparator<T> comp) {
        beasts.sort(comp);
    }

    public void add(T beast) throws DuplicateNameException {
        if (!beasts.contains(beast)) {
            beasts.add(beast);
        }
        else throw new DuplicateNameException();
    }

    private SearchTuple search(String name) {
        for(int i = 0; i < beasts.size(); i++) {
            T el = beasts.get(i);
            if (Objects.equals(el.getName(), name)) {
                return new SearchTuple(i, true);
            }
        }
        return new SearchTuple(-1, false);
    }

    //TODO refactor this shit, this is terrible
    public Beast get(String name) {
        SearchTuple st = search(name);
        return null;
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
