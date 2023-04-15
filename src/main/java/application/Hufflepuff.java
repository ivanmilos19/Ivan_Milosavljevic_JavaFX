package application;

public class Hufflepuff extends House {
    public String getName() { return "Hufflepuff"; }

    @Override
    public double potionImprovement() {
        return 2;
    }
}
