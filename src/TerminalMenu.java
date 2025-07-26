import model.BaseballCard;
import model.BasketballCard;
import model.Card;
import model.FootballCard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TerminalMenu {
    private static final Scanner userInput = new Scanner(System.in);
    private final Database database = new Database("sql/database.properties");

    public void terminalMenu() {
        boolean running = true;
        while (running) {
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
                    printCardsAmount();
                }
                case 3 -> {
                    System.out.println("Cards in mint condition: ");
                }
                case 4 -> {
                    running = false;
                    System.out.println("Program ended");

                }
            }
        }
    }


    private void chooseSportMenu() {
        boolean running = true;

        while (running) {
            System.out.println("Choose what type of sport you want to see: ");
            System.out.println("1: Football");
            System.out.println("2: Baseball");
            System.out.println("3: Basketball");
            System.out.println("4: Go back to main menu");

            int userChoice = getNumberFromTerminalInput();

            switch (userChoice) {
                case 1 -> {
                    printFootballCards();
                }
                case 2 -> {
                    printBaseballCards();
                }
                case 3 -> {
                    printBasketballCards();
                }
                case 4 -> {
                    running = false;
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

    private void printFootballCards() {

        List<FootballCard> footballCards = database.getFootballCards();
        int amountOfCards = footballCards.size();
        for (int i = 0; i < amountOfCards; i++) {
            System.out.print(footballCards.get(i));
        }
    }

    private void printBasketballCards() {

        List<BasketballCard> basketballCards = database.getBasketballCards();
        int amountOfCards = basketballCards.size();
        for (int i = 0; i < amountOfCards; i++) {
            System.out.print(basketballCards.get(i));
        }
    }

    private void printBaseballCards() {

        List<BaseballCard> baseballCards = database.getBaseballCards();
        int amountOfCards = baseballCards.size();
        for (int i = 0; i < amountOfCards; i++) {
            System.out.print(baseballCards.get(i));
        }
    }

    private void printCardsAmount() {
        int cardsAmount = database.getCardsAmount();
        System.out.println("Cards amount: " + cardsAmount);
    }
}
