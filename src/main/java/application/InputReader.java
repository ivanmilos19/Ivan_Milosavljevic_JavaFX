package application;

import lombok.Data;
import java.util.Scanner;
import java.util.Arrays;
@Data
public class InputReader {
    String instructions;
    private String validChoices[];
    public InputReader(String instructions, String[] validChoices){
        this.instructions = instructions;
        this.validChoices = validChoices;
    }

    public int getNumberOfValidChoices()
    {
        return validChoices.length;
    }
    private boolean isPlayerChoiceValid(String playerChoice)
    {
        return Arrays.asList(validChoices).contains(playerChoice);
    }

    public void showValidOptions()
    {
        for (int i = 0; i < validChoices.length; i++) {
            System.out.println((i+1) + ": " + validChoices[i]);
        }
    }

    public String readInput() {
        String newLine = System.getProperty("line.separator");
        String playerChoice;
        Scanner scanner = new Scanner(System.in);
        System.out.println(instructions);
        showValidOptions();
        do {
            playerChoice = scanner.nextLine();
            if (isPlayerChoiceValid(playerChoice))
                break;
            System.out.println(playerChoice + " is not a valid choice");
            System.out.println(newLine + "⚠️ Please write only one of the available options");
            showValidOptions();
        } while (true);
        return  playerChoice;

    }

    public int readInputByNumber() {
        String newLine = System.getProperty("line.separator");
        int playerChoice;
        Scanner scanner = new Scanner(System.in);
        System.out.println(instructions);
        showValidOptions();
        do {
            String input = scanner.nextLine();
            try {
                playerChoice = Integer.valueOf(input.trim());
            } catch (NumberFormatException e) {
                System.out.println("⚠️ invalid input format: '" + input + "'");
                continue;
            }
            if (playerChoice >= 1 && playerChoice <= validChoices.length)
                break;
            System.out.println(playerChoice + " is not a valid choice");
            System.out.println(newLine + "⚠️ Please write only one of the available options");
            showValidOptions();
        } while (true);
        return  playerChoice;

    }
}
