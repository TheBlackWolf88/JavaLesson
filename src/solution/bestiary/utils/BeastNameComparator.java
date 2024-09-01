package solution.bestiary.utils;

import solution.bestiary.beast.Beast;

import java.util.Comparator;

public class BeastNameComparator implements Comparator<Beast> {
    @Override
    public int compare(Beast o1, Beast o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
