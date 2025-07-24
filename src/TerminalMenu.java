import java.util.Scanner;

public class TerminalMenu {
    private static final Scanner userInput = new Scanner(System.in);


     void terminalMenu() {


        System.out.println("--------------------------------------------------------");
        System.out.println("Menu:");
        System.out.println("Select one of the alternatives below");
        System.out.println("1: Choose a sport to see all cards from given sport");
        System.out.println("2: See amount of cards registered");
        System.out.println("3: See all cards with mint condition");
        System.out.println("4: End program");
        System.out.println("--------------------------------------------------------");

        int userChoice = getNumberFromTerminalInput();
        switch (userChoice) {
            case 1 -> {
                chooseSportMenu();
            }
            case 2 -> {
                System.out.println("Cards registered: ");
            }
            case 3 -> {
                System.out.println("Cards in mint condition: ");
            }
            case 4 -> {
                System.out.println("Program ended");
            }
        }
    }


    private void chooseSportMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Choose what type of sport you want to see: ");
            System.out.println("1: Football");
            System.out.println("2: Baseball");
            System.out.println("3: Basketball");
            System.out.println("4: Go back to main menu");

            int userChoice = getNumberFromTerminalInput();
            ;

            switch (userChoice) {
                case 1 -> {
                    System.out.println("Metode for å skrive ut fotballkort");

                }
                case 2 -> {
                    System.out.println("Metode for å skrive ut Baseballkort");
                }
                case 3 -> {
                    System.out.println("Metode for å skrive ut Basketballkort");
                }
                case 4 -> {
                    exit = true;
                    terminalMenu();
                }
            }
        }
    }

    //Metoden under er tatt utgangspunkt fra kode vist i forelesning: https://github.com/kristiania/PGR112v24/blob/main/code/solutions/database/terminal/src/Terminal.java#L17
    private int getNumberFromTerminalInput() {
        try {
            return Integer.parseInt(TerminalMenu.userInput.nextLine());
        } catch (NumberFormatException e) {
            System.out.print("You have to choose a number between 1 - 4");
            return getNumberFromTerminalInput();
        }
    }
}
