package application;

import java.util.Scanner;

public class Shop {
    public static final String RESET = "\033[0m";  // Text Reset
    public static final String YELLOW_BOLD_BRIGHT = "\033[1;93m";// YELLOW


    String newLine = System.getProperty("line.separator");


    public void enterShop(Wizard wizard) {
        int playerChoice;

        playerChoice = (new InputReader(RESET + "Do you wish to buy something in Brewsings ?" + newLine, new String[]{"Yes", "No"})).readInputByNumber();

        if (playerChoice == 1) {
            System.out.println("Welcome to Brewsings! Which potion may warrant your attention ? " + newLine);
            System.out.println("You have: " + wizard.getGold() + " Gold\uD83D\uDCB0" + newLine);

            while (true) {

                int healthPrice = 15;
                int damagePrice = 30;
                int manaPrice = 15;


                playerChoice = (new InputReader(RESET + "Please enter your choice" + newLine, new String[]{"Health potion: 15 Gold", "Damage boost potion: 30 Gold", "Mana potion: 15 Gold", "Nevermind"})).readInputByNumber();


                if (playerChoice == 1 && wizard.getGold() - healthPrice > 0) {
                    wizard.addHealthPotion(new Potion());
                    wizard.setGold(wizard.getGold() - healthPrice);
                    System.out.println(YELLOW_BOLD_BRIGHT + "Acquired a health potion");
                }

                else if (playerChoice == 2 && wizard.getGold() - damagePrice > 0) {
                    wizard.addDamagePotion(new Potion());
                    wizard.setGold(wizard.getGold() - damagePrice);
                    System.out.println(YELLOW_BOLD_BRIGHT + "Acquired a damage boost potion");
                }

                else if (playerChoice == 3 && wizard.getGold() - manaPrice > 0) {
                    wizard.addManaPotion(new Potion());
                    wizard.setGold(wizard.getGold() - manaPrice);
                    System.out.println(YELLOW_BOLD_BRIGHT + "Acquired a mana potion");
                } else {
                    System.err.println("not enough gold" +newLine);
                }
                System.out.println(newLine + "You have: " + wizard.getGold() + " Gold\uD83D\uDCB0");

                if (playerChoice == 4) {
                    break;
                }
            }
        }
    }
}
