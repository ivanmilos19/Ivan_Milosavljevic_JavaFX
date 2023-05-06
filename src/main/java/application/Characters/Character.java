package application.Characters;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
public abstract class Character {


    private int currentHP;
    private int previousHP;
    private int baseHP;
    private int attack_strength;
    private String name;

    /** the character attacks the given target */
    public void attack(Character target)
    {
        int damage = damageInflicted();

        if (target.isDefending) {
            damage /= target.defenseFactor();
        }

        if (damage > target.currentHP)
            damage = target.currentHP;

        target.previousHP = target.currentHP;
        target.currentHP -= damage;
    }

    int getLastDamageTaken() {
        return previousHP - currentHP;
    }

    private boolean isDefending;
    public void defend() {
        isDefending = true;
    }
    public void stopDefending() {
        isDefending = false;
    }
    /** how much damage can the character inflict when attacking a target */
    public abstract int damageInflicted();

    /* value by which we divide the inflicted damage by */
    public int defenseFactor() { return 2; }

    public boolean isAlive() { return currentHP > 0; }
    public boolean isDead() { return !isAlive(); }
}
