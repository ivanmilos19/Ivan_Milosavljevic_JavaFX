package application;

import application.Characters.Wizard;

public class Rewards {
    String newLine = System.getProperty("line.separator");
    public void getRewards(Wizard wizard) {


        wizard.setBaseHP(wizard.getBaseHP() + 150);
        wizard.setGold(wizard.getGold() + 40);
        wizard.setManaPool(wizard.getManaPool() + 25);
        wizard.setLevel(wizard.getLevel() + 1);
        wizard.setAttack_strength((wizard.getAttack_strength()) + 20);

        wizard.setCurrentHP(wizard.getBaseHP());
        wizard.setCurrentmanaPool(wizard.getManaPool());

        System.out.println("You won 40 Gold! " + newLine);
        System.out.println("Your wizard has leveled up ! The followings stats have been augmented: ");
        System.out.println("+100 health" + "  |  " + "+25 mana" + "  |  " + "+20 attack" );

        wizard.addSpell(new Spell());
        wizard.addSpell(new Spell());

    }
}
