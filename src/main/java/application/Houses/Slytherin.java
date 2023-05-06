package application.Houses;

public class Slytherin extends House {
    public String getName() { return "Hufflepuff"; }

    @Override
    public double attackMultiplier() {
        return 1.5;
    }

    @Override
    public boolean canJoinEnemy() { return true; }
}

