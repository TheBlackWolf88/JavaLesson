package solution.bestiary.utils;

import solution.bestiary.beast.Beast;

import java.util.Comparator;

public class BeastPowerComparator implements Comparator<Beast> {

    @Override
    public int compare(Beast o1, Beast o2) {
        return (int) (o1.getPowerLevel() - o2.getPowerLevel());
    }
}
