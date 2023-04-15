package application;

import lombok.Data;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

@Data
public class Wand {

    public static final String CYAN_BOLD_BRIGHT = "\033[1;96m";  // CYAN
    public static final String RESET = "\033[0m";  // Text Reset


    private int height;
    private int size;

    Core core;


    private static String qualities[] = {"Power", "Consistency", "Broadness" };
    private static  Core cores[] = { Core.DRAGON_HEARTSTRING, Core.UNICORN_HAIR, Core.PHOENIX_FEATHER };
    private void determineWandSize() {
        if (height <= 165) {
            this.size = 8 ;
        }
        else if (height > 165 && height < 185) {
            this.size = 11;
        }
        else if (height >= 185) {
            this.size = 14;
        }

    }



    public Wand() {
        Scanner scanner = new Scanner(System.in);
        String newLine = System.getProperty("line.separator");
        System.out.println(newLine + CYAN_BOLD_BRIGHT +"Time for you to get your wand. How tall are you ? (Write your height in centimeters)" +RESET);
        do {
            try {
                height = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                break;
            } catch(InputMismatchException e) {
                scanner.nextLine();
                System.out.println("⚠️ Please write a valid height.");
            }
        }while(true);

        determineWandSize();


        String instructions = newLine + CYAN_BOLD_BRIGHT+ "Choose the property of your core:" +RESET;
        InputReader qualityReader = new InputReader(instructions, qualities);
        int playerChoice = qualityReader.readInputByNumber();
        int index = playerChoice - 1;
        core = cores[index];

        System.out.println("You have a: " + size + " inch wand with a " + core.name().toLowerCase().replace("_", " ") + " core");


    }
}


