public class Main {

    int a;
    public static void main(String[] args) {
        System.out.printf("Hello and welcome!");


    }
}

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
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public void Roar() {
        System.out.println("Roar");
    }

    public Lion(double height) {
        super(height);
    }

}
