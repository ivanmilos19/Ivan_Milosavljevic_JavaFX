package application;

/* Automatically add a noop "Never mind" choice that allows
   the user to take no action and return to previous step
 */
public class InputReaderWithNoop extends InputReader {

    int lastUserChoice = 0;

    public boolean noopChosen()
    {
        // last choice is always "Never mind" - was this what user selected in the last input ?
        return lastUserChoice == getNumberOfValidChoices();
    }

    private static String[] extendedChoices(String[] validChoices) {
        // append the "Never mind" action to the choices - it is always the last valid choice
        String[] validChoicesExtended = new String[validChoices.length + 1];
        for (int i = 0; i < validChoices.length; i++) {
            validChoicesExtended[i] = validChoices[i];
        }
        validChoicesExtended[validChoicesExtended.length - 1] = "Never mind";
        return validChoicesExtended;
    }

    public InputReaderWithNoop(String instructions, String[] validChoices) {
        super(instructions, extendedChoices(validChoices));
    }

    public int readInputByNumber() {
        lastUserChoice = super.readInputByNumber();
        return lastUserChoice;
    }
}
