package application;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.Random;

@Data
@SuperBuilder



public class Enemy extends AbstractEnemy {

    public static final String RED_BOLD_BRIGHT = "\033[1;91m";   // RED
    public static final String PURPLE_BOLD_BRIGHT = "\033[1;95m";// PURPLE
    @Override
    public int damageInflicted() {
        int attack_strength = getAttack_strength();
        if (canUseMace()) {
            attack_strength *= attackStrengthMultiplier;
        }

        if (canThrowBook()) {
            attack_strength *= attackStrengthMultiplier;
        }

        return attack_strength;
    }
    private int new_HP;

    // Troll big attack //
    private boolean castMace;
    private int attackStrengthMultiplier;

    private boolean throwBook;


    // Troll big attack
    public boolean randomUseMace() {
        castMace = false;
        Random rand = new Random();
        double probability = 0.3; // hitting accuracy

        if (rand.nextDouble() < probability) {
            System.out.println(PURPLE_BOLD_BRIGHT +"The troll is about to smash you with his mace and is about to do big damage !");
            castMace = true;
        }
        return castMace;
    }

    public boolean canUseMace() {
        return castMace;
    }

    public void resetMace() {
        castMace = false;
    }


    // Dolores big attack ///

    public boolean randomThrowBook() {
        throwBook = false;
        Random rand = new Random();
        double probability = 0.6; // hitting accuracy

        if (rand.nextDouble() < probability) {
            System.out.println(PURPLE_BOLD_BRIGHT +"Dolores is about to throw the Wizard encyclopedia at you ! Big damage incoming !");
            throwBook = true;
        }
        return throwBook;
    }

    public boolean canThrowBook() {
        return throwBook;
    }

    public void resetBook() {
        throwBook = false;
    }


}
