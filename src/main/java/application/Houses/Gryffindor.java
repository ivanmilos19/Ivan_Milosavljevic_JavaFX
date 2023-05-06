package application.Houses;

public class Gryffindor extends House {
    public String getName() { return "Gryffindor"; }

    @Override
    public double defenseMultiplier() {
        return 1.5;
    }

    public boolean canUseSword() { return true; };
}
