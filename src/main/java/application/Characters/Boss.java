package application.Characters;

import application.Characters.AbstractEnemy;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.Random;

@Data
@SuperBuilder
public class  Boss extends AbstractEnemy {

    public static final String RED_BOLD_BRIGHT = "\033[1;91m";   // RED
    public static final String PURPLE_BOLD_BRIGHT = "\033[1;95m";// PURPLE
    @Override
    public int damageInflicted() {
        int attack_strength = getAttack_strength();
        if (canBite()) {
            attack_strength *= attackStrengthMultiplier;
        }

        if (canUseAvada()) {
            attack_strength *= attackStrengthMultiplier;
        }
        return attack_strength;
    }


    private int new_HP;
    private boolean castAvada;
    private boolean basilicBite;
    private int attackStrengthMultiplier;


    public boolean RandomUseAvada() {
        castAvada = false;
        Random rand = new Random();
        double probability = 0.1; // hitting accuracy

        if (rand.nextDouble() < probability) {
            System.out.println(PURPLE_BOLD_BRIGHT + "Voldemort is preparing to use Avada Kedavra!");
            castAvada = true;
        }
        return castAvada;
    }
    public boolean canUseAvada() {
        return castAvada;
    }


    public void resetUseAvada() {
        castAvada = false;

    }
    //BIG ATTACK BASILIC/
    public boolean RandomBite() {
        basilicBite = false;
        Random rand = new Random();
        double probability = 0.2; // hitting accuracy

        if (rand.nextDouble() < probability) {
            System.out.println( PURPLE_BOLD_BRIGHT + "The basilic is about to bite you!");
            basilicBite = true;
        }
        return basilicBite;
    }
    public boolean canBite() {
        return basilicBite;
    }


    public void resetBite() {
        basilicBite = false;

    }
}
