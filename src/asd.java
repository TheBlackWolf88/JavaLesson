import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;


//final miatt nem lehet szülőosztály
final class Square implements Comparable<Square> {
    // egy kis encapsulation example
    //elrejtjük az a-t, hogy azt ne lehessen kívülről módosítani
    private double a;

    //ezzel a metódussal lekérhetjük az a-t
    //mivel primitív típus ezért alapból másolódik, ezzel nem kerül ki belső állapot
    public double getA() {
        return a;
    }

    public Square(double a) {
        this.a = a;
    }

    //két négyzetet egyenlőnek tekintünk, ha oldalai egyformák
    @Override
    public boolean equals(Object obj) {
        //ha a két pointer egyezik
        if (this == obj) return true;
        //ha az obj Square osztálybeli (vagy Square leszármazottjának osztályába való (ami most nem lehetséges))
        if (obj instanceof Square) {
            //Squarré castoljuk
            Square that = (Square) obj;
            return this.a == that.getA();
        } else return false;
    }

    //néha ezt is felül kell írni
    //technikailag egy becslés az equalsra, gyorsan számolható (worst case O(n), de ha rosszabb mint O(1) cachelik).
    //Adatszerkezetek használják (HashMap, ArrayList etc)
    @Override
    public int hashCode() {
        return (int) a;
    }

    //negatív, ha kisebb; pozitív ha nagyobb
    @Override
    public int compareTo(Square s) {
        return (int) (this.a - s.getA());
    }

    @Override
    public String toString() {
        return "S(" + a + ")";
    }
}

class SquareComparator implements Comparator<Square> {
    public int compare(Square s1, Square s2) {
        if (s1.getA() < s2.getA()) return -1;
        else if (s1.getA() > s2.getA()) return 1;
        else return 0;
    }
}

class alma{
    void printFile() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("file.txt"));
        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        sc.close();
        }
    }
    void readIt() throws FileNotFoundException {
        //automatikusan meghívja az sc.close()-t, akkor mikor a finally hívná meg a fenti példában
        try (Scanner sc = new Scanner(new File("alma.txt"))) {
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        }
    }

}
