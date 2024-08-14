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

### Osztályok

### Leszármazás

+ Minden osztály amit létrehozunk legalább egy szülővel rendelkezik (java.Object)
+ 