import model.BaseballCard;
import model.BasketballCard;
import model.CardSeries;
import model.FootballCard;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

    Database database = new Database("sql/database.properties");

    public void readFileAndInsertIntoDb() {

        try (Scanner scanner = new Scanner(new File("resources/samlerkort.txt"))) {
            // Oppretter en variabel som leser neste linje
            String line = scanner.nextLine();

            // Hvis neste linje er "Samlerkort serier ..."
            if (line.equals("Samlerkortserier:")) {
                // Leser neste linje som tekst og gjør om til en int som lagres i variabelen
                int amoutOfCardSeries = Integer.parseInt(scanner.nextLine());

                // En for-løkke med en teller som utfører koden inni så lenge i er lavere enn tallet som er lagret i amoutOfCardSeries
                for (int i = 0; i < amoutOfCardSeries; i++) {
                    int id = Integer.parseInt(scanner.nextLine());
                    String publisher = scanner.nextLine();
                    int year = Integer.parseInt(scanner.nextLine());
                    String sport = scanner.nextLine();
                    int amountOfCardsInSeries = Integer.parseInt(scanner.nextLine());

                    // Oppretter et objekt med informasjonen over
                    CardSeries cardSeries = new CardSeries(id, publisher, year, sport, amountOfCardsInSeries);
                    database.insertCardSeries(cardSeries);
                }
            }
            scanner.nextLine();
            line = scanner.nextLine();

            if (line.equals("Kort:")) {

                int amountOfCards = Integer.parseInt(scanner.nextLine());

                for (int i = 0; i < amountOfCards; i++) {
                    int id = Integer.parseInt(scanner.nextLine());
                    int cardSeriesId = Integer.parseInt(scanner.nextLine());
                    String condition = scanner.nextLine();
                    String playerName = scanner.nextLine();
                    String club = scanner.nextLine();
                    int seasonsPlayed = Integer.parseInt(scanner.nextLine());
                    int gamesPlayed = Integer.parseInt(scanner.nextLine());
                    String sport = scanner.nextLine();
                    switch (sport) {
                        case "Fotball" -> {
                            int leagueGoals = Integer.parseInt(scanner.nextLine());
                            int cupGoals = Integer.parseInt(scanner.nextLine());
                            FootballCard card = new FootballCard(id, cardSeriesId, condition, playerName, club, seasonsPlayed, gamesPlayed, sport, leagueGoals, cupGoals);
                            database.insertFootballCard(card);
                        }
                        case "Baseball" -> {
                            int homeruns = Integer.parseInt(scanner.nextLine());
                            BaseballCard card = new BaseballCard(id, cardSeriesId, condition, playerName, club, seasonsPlayed, gamesPlayed, sport, homeruns);
                            database.insertBaseballCard(card);
                        }
                        case "Basketball" -> {
                            int fgPercent = Integer.parseInt(scanner.nextLine());
                            int ftPercent = Integer.parseInt(scanner.nextLine());
                            double averagePoints = Double.parseDouble(scanner.nextLine());
                            BasketballCard card = new BasketballCard(id, cardSeriesId, condition, playerName, club, seasonsPlayed, gamesPlayed, sport, fgPercent, ftPercent, averagePoints);
                            database.insertBasketballCard(card);
                        }
                        default -> {
                            System.out.println("ingenting funker");
                        }
                    }
                    // Hopper over "-----" i tekstfilen
                    scanner.nextLine();

                }
            } else {
                System.out.println("Fant ikke kort:");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            throw new RuntimeException(e);

        }
    }
}

