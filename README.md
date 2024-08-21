# Java óra

## Témák
+ Láthatóság, csomagok
+ Típusok, modosítóik (pl static, final)
+ Objektumok, leszármazás
+ Összehasonlítás, rendezés (equals, compareto)
+ Polimorfizmusok
+ Kivételek
+ try-catch-finally, try-with-resources

### Csomagok

Ha nem adunk meg csomagot, akkor  is létrejön egy "default" csomag. Ha sajátot akarunk megadni, azt így tehetjük meg :

```java
//Main.java
package main;

class Main { 
    //ez egy tag, specifikusan egy mező
    int a;
    //ez is egy tag, specifikusan egy metódus
    int addOne(int x) { return x+1; };
}
```
A fájlrendszerben is megjelennek a csomagok mappákként.

### Láthatóság

A Javában 4 féle láthatóság van:
+ `public`
  + a tagot bármely másik osztály láthatja
+ `private`
  + a tagot csak a saját osztályán belül láthatják
+ `package-private`
  + a tagot csak a vele egy packageben lévő osztályok láthatják
  + általában ritkán használt, mert disambigous
+ `protected`
  + a tagot csak a leszármazott osztályok láthatják

### Típusok
+ Primitívek (mindig másolódnak):
  + szám típusok (byte, int, float, double, long)
  + char
  + bool
+ Reference típusok
  + Csomagolók (Integer, Boolean, etc.)
  + Class, Interface

### Módosítók

Kulcsszavak, amelyek egy tagra hatnak.

+ `static`
  + osztályszintű mező/metódus
  + szerepe hogy egy tagot el lehessen érni az osztály példányosítása nélkül
  + (példányosítás: osztályból objektum létrehozása általában new keyworddel)
+ `final`
  + módosíthatatlanná teszi a mezőt
  + metódus esetében ez azt jelenti hogy subclass nem tudja felülírni
  + osztály esetében nem lehet belőle leszármazni
+ `abstract`
  + mezőn nem használható
  + metódus esetén egy felülírandó metódust hozunk létre, törzs nélkül
  + osztály esetén egy olyan osztályt amit nem lehet példányosítani

### Osztályok, objektumok
+ Az osztályok az objektumok sablonjai
+ Ha megkonstruálunk egy osztályt, azzal létrehozunk egy objektumot.
+ [Így](https://imgur.com/a/1cADykT) néz ki a memóriában
```java
//ez egy osztály
class Dog() {
  private double height;
  //ez a konstruktor
  public Dog(double height) {
      //a this kulcsszóval  a jelenlegi OBJEKTUMra tudunk referálni (amit létrehozott az osztályunk)
      this.height = height;
  }
}

class Main{
  public static void main(String[] args) {
    //ez egy objektumreferencia változó 
    Dog gugya = new Dog(6.2);
    //ez meg egy primitív
    int a = 0;
    
  }
}
```

### Leszármazás, interfacek

+ Minden osztály amit létrehozunk legalább egy szülővel rendelkezik (java.Object)
+ Vannak interfacek, amelyeknek nincs adattagjuk csak metódusaik
+ Egy osztály csak egy szülővel rendelkezhet, de több interfacet is implementálhat
```java
interface IMeows {
    void Meow();
}

interface IRoars {
    void Roar();
}

class Animal {
    protected double height;

    protected Animal(double height) {
        this.height = height;
    }
}

class Lion extends Animal implements IMeows, IRoars {
   @Override
   public void Meow() {
       System.out.println("Meow");
   } 

   @Override
   public void Roar() {
       System.out.println("Roar");
   } 

   public Lion(double height) {
       super(height);
   }

}
```

### Összehasonlítás

Ennek a módját a java.Object osztály equals metódusának felülírásával tudjuk megadni

```java
//final miatt nem lehet szülőosztály
final class Square {
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
            return this.a == that.aé
        } else return false;
    }

    //néha ezt is felül kell írni
    //technikailag egy becslés az equalsra, gyorsan számolható (worst case O(n)).
    //Adatszerkezetek használják (HashMap, ArrayList etc)
    @Override
    public int hashCode() {
        return (int) a;
    }
```

### Rendezés
Ha beépített függvénnyel rendeznél, ahhoz először definiálnunk kell mitől lesz nagyobb az egyik objektumunk a másiknál.
Ehhez két ezközünk van, a Comparable és a Comparator interfacek.

```java
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

class Main {
    public static void main(String[] args) {
        ArrayList<Square> list = new ArrayList<Square>();
        list.add(new Square(1.2));
        list.add(new Square(3.41));
        list.add(new Square(0.2));
        //Comparable interfaceszel
        Collections.sort(list);
        //Comparatorral
        SquareComparator sc = new SquareComparator();
        Collections.sort(list, sc);
        //olyan paramétert, ami egy olyan interface-t kér, aminek csak egy metódusa van helyettesíthetünk lambda functionnel
        Collections.sort(list, (s1,s2) -> {
            if (s1.getA() < s2.getA()) return -1;
            else if (s1.getA() > s2.getA()) return 1;
            else return 0;
        })
        System.out.println(list);
        //[S(0.2), S(1.2), S(3.41)]
    }
}
```

### Polimorfizmusok
#### Altípusos polimorfizmus
Ezt már láttuk, ez az öröklődés. Fontos megjegyezni, hogy vannak az altípusosságnak szabályai, legfontosabb a Liskov-féle helyettesítési elv:
> Egy A típus altípusa a B típusnak, ha az A egyedeit használhatjuk B egyedei helyett, anélkül, hogy ebből baj lenne.

#### Parametrikus polimorfizmus
##### Metódusokra (Túlterhelés)
Ez arra való, hogy több ugyanolyan műveletet, ugyanazon a néven hívhassunk, még akkor is ha más típusokkal dolgoznak.
```java
class Calculator {
    //Mindhárom helyes
    public static double add(double a, double b) {
        return a+b;
    }
    public static int add(int a, int b) {
        return a+b;
    }
    public static int add(int a, int b, int c) {
        return a+b+c;
    }

    //FONTOS! Ez nem helyes, duplicate metódusként híbát jelez a fordító
    //Tehát csak akkor túlterhelés, ha a paraméterek típusa/száma eltér, a visszatérési érték típusa nem mérvadó!!
    public static float add(int a, int b) {
        return a+b;
    }
}
```

##### Genericek
Láttunk és használtunk már korábban is genericet (ld. ArrayList). Adatszerkezetek esetén egyszerű belátni hasznosságukat, de sok más helyen is használhatóak.
Fontos megjegyezni, hogy csak referenciatípusokkal paraméterezhetők. 
```java
class MyArrayList<T> {
    //you should never speak of this to anyone, it is quite bad
    private T[] arr;
    private int cap = 0;
    
    public MyArrayList() {
        arr = new T[10];
    }

    public void add(T item) {
        arr[searchNull()] = item;
        cap++
        if (cap >= arr.length) {
            T[] newArr = new T[arr.length * 2];
            System.arraycopy(arr, 0, newArr, 0, arr.length)
            arr = newArr;
        }
    }

    public T get(int ind) {
        return arr[ind];
    }

    public void set(T item, int ind ) {
        arr[ind] = item;
    }

    public int search(T item) {
        for (int i = 0; i < arr.length; i++) {
            if (el.equals(item)) return i;
        }
    }

    public int searchNull() {
        for (int i = 0; i < arr.length; i++) {
            if (el == null) return i;
        }
    }

    public void remove(int ind) {
        arr[ind] = null;
        cap--;
    }
    
    public void remove(T item) {
        this.remove(this.search(item));
    }
}

//Vannak generic metódusok is, illetve a típusparaméter szűkíthető
class Main {
    public static <T extends MyDummyClass> void printItem(T item) {
        System.out.println("Your item: " + item);
    }
}
```

### Hibakezelés, kivételek

Két helyen léphet fel hiba a programunknál: fordítási vagy futási időben.
A fordítási időben fellépett hibát a fordító jelzi nekünk, így azzal nem kell külön foglalkoznunk.
A futási időben kétféle kivétel léphet fel: checked és unchecked.
#### Checked Exception
Általában olyan operáció dobja, amely a programunkon kívüli adatot dolgoz fel (IO, hálózati operáció).
Kétféleképp kezelhetjük:

```java
import java.io.*;
import java.util.Scanner;

class Main {
    void printFile() throws FileNotFoundException {
        Scanner sc = new Scanner("file.txt");
        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
        sc.close();
    }
}
```
vagy
```java
import java.io.*;
import java.util.Scanner;

class Main {
    void printFile() {
        try {
            Scanner sc = new Scanner(new File("file.txt"));
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        }
        //lehet több catch ág is, de mindig legkonkrétabb exception -> legáltalánosabb
        catch (FileNotFoundException e) {
            System.err.println("File not found");
            //elhajítja az errort egy szinttel feljebb és megszakítja a futást
            throw e;
        }
        catch (Exception e) {
            throw e;
        } 
        //a finallyban lévő utasítás mindenképp lefut
        finally {
            sc.close();
        }
    }
}
```
Saját checked exceptiont az Exception osztályból leszármaztatva tudunk létrehozni:
```java
//amúgy ez is egy rendes class, lehet ennél fancybb (bár afaik nem szokott)
class MyCheckedException extends Exception {
    public MyCheckedException(String errorMessage) {
        super(errorMessage);
    }
}
```

#### Unchecked Exception
Ezek váratlan hibák, amiket nem kötelességünk jelezni/kezelni, ettől függetlenül lehet. Ilyen az ArithmeticException)(pl 0-val való osztásnál) vagy az IndexOutOfBoundsException (kiindexelésnél).
Kezelni ugyanúgy try-catch kombóval tudjuk.
Sajátot a RuntimeException osztályból leszármazva tudunk csinálni.
```java

class MyUncheckedException extends RuntimeException {
    public MyUncheckedException(String errorMessage) {
        super(errorMessage);
    }
}
```

### Addendum
#### try-with-resources
Különböző resource-okat tudunk így automatikusan zárni.
```java
class Main {
    void readIt() throws FileNotFoundException {
        //automatikusan meghívja az sc.close()-t, akkor mikor a finally hívná meg a fenti példában
        try (Scanner sc = new Scanner(new File("alma.txt"))) {
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        }
    }
}
```

#### Enumok
Vannak enumok, így vannak:
```java
enum Size {
    S,
    M,
    L
}
```

# Vége
