package application.Houses;

public abstract class House {

    public abstract String getName();

    public double defenseMultiplier() { return 1; }

    public double attackMultiplier() { return 1; }

    public double precision() { return 0; }

    public double potionImprovement() { return 1; }

    public boolean canUseSword() { return false; }

    public boolean canJoinEnemy() { return false; }
}
