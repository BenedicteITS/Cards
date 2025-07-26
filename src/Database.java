import com.mysql.cj.jdbc.Driver;
import model.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Database {

    //# Static
    static {
        try {
            DriverManager.registerDriver(new Driver());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    //# Fields
    private final Properties properties = new Properties();

    {
        // Standard-verdier
        this.properties.put("host", "localhost");
        this.properties.put("port", "3306");
    }


    //# Constructors
    public Database(String filePath) {
        // Laster inn informasjon fra .properties-fil oppgitt
        try {
            this.properties.load(new FileInputStream(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Nøkkeldata som trengs for å kunne koble seg til en database
        List<String> keysNeeded = List.of(
                "host", "port", "database", "username", "password"
        );

        // Sjekker at vi har all nødvendig informasjon
        if (!this.properties.keySet().containsAll(keysNeeded)) {
            System.out.print("Keys that exist: ");
            System.out.println(this.properties.keySet());

            throw new RuntimeException("Missing information to connect to database!");
        }
    }


    //# Methods
    private Connection getConnection() throws SQLException {
        // URI: jdbc:mysql://host:port/database
        return DriverManager.getConnection(
                "jdbc:mysql://" + this.properties.getProperty("host")
                        + ":" + this.properties.getProperty("port")
                        + "/" + this.properties.getProperty("database")
                        + "?allowPublicKeyRetrieval=true&useSSL=false",
                this.properties.getProperty("username"),
                this.properties.getProperty("password")
        );
    }

    public void insertCardSeries(CardSeries cardSeries) {
        try (Connection connection = getConnection()) {
            String query = "INSERT INTO samlerkortserie (id, utgiver, utgitt, sport, antall) VALUES (?, ?, ?, ?, ?) ";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, cardSeries.getId());
            statement.setString(2, cardSeries.getPublisher());
            statement.setInt(3, cardSeries.getReleaseYear());
            statement.setString(4, cardSeries.getSport());
            statement.setInt(5, cardSeries.getAmountOfCardsInSeries());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertBaseballCard(BaseballCard baseballCard) {
        try (Connection connection = getConnection()) {
            String query = "INSERT INTO baseballkort (id, Serie, Tilstand, Spillernavn, Klubb, Sesonger, Kamper, Homeruns) VALUES (?, ?, ?, ?, ?, ?, ?, ?) ";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, baseballCard.getId());
            statement.setInt(2, baseballCard.getCardSeriesId());
            statement.setString(3, baseballCard.getCondition());
            statement.setString(4, baseballCard.getPlayerName());
            statement.setString(5, baseballCard.getClub());
            statement.setInt(6, baseballCard.getSeasonsPlayed());
            statement.setInt(7, baseballCard.getGamesPlayed());
            statement.setInt(8, baseballCard.getHomeruns());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void insertBasketballCard(BasketballCard basketballCard) {
        try (Connection connection = getConnection()) {
            String query = "INSERT INTO basketballkort (id, Serie, Tilstand, Spillernavn, Klubb, Sesonger, Kamper, FGPercent, FTPercent, Poengsnitt) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, basketballCard.getId());
            statement.setInt(2, basketballCard.getCardSeriesId());
            statement.setString(3, basketballCard.getCondition());
            statement.setString(4, basketballCard.getPlayerName());
            statement.setString(5, basketballCard.getClub());
            statement.setInt(6, basketballCard.getSeasonsPlayed());
            statement.setInt(7, basketballCard.getGamesPlayed());
            statement.setInt(8, basketballCard.getFgPercent());
            statement.setInt(9, basketballCard.getFtPercent());
            statement.setDouble(10, basketballCard.getAveragePoints());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void insertFootballCard(FootballCard footballCard) {
        try (Connection connection = getConnection()) {
            String query = "INSERT INTO fotballkort (id, Serie, Tilstand, Spillernavn, Klubb, Sesonger, Kamper, Seriescoringer, Cupscoringer) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) ";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, footballCard.getId());
            statement.setInt(2, footballCard.getCardSeriesId());
            statement.setString(3, footballCard.getCondition());
            statement.setString(4, footballCard.getPlayerName());
            statement.setString(5, footballCard.getClub());
            statement.setInt(6, footballCard.getSeasonsPlayed());
            statement.setInt(7, footballCard.getGamesPlayed());
            statement.setInt(8, footballCard.getLeagueGoals());
            statement.setInt(9, footballCard.getCupGoals());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<FootballCard> getFootballCards() {
        List<FootballCard> footballCards = new ArrayList<>();

        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM fotballkort");
            while (resultSet.next()) {
                FootballCard footballCard = new FootballCard(
                        resultSet.getInt("id"),
                        resultSet.getInt("serie"),
                        resultSet.getString("tilstand"),
                        resultSet.getString("spillernavn"),
                        resultSet.getString("klubb"),
                        resultSet.getInt("sesonger"),
                        resultSet.getInt("kamper"),
                        "football",
                        resultSet.getInt("seriescoringer"),
                        resultSet.getInt("cupscoringer")
                );
                footballCards.add(footballCard);

            }
            return footballCards;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<BasketballCard> getBasketballCards() {
        List<BasketballCard> basketballCards = new ArrayList<>();

        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM basketballkort");
            while (resultSet.next()) {
                BasketballCard basketballCard = new BasketballCard(
                        resultSet.getInt("id"),
                        resultSet.getInt("serie"),
                        resultSet.getString("tilstand"),
                        resultSet.getString("spillernavn"),
                        resultSet.getString("klubb"),
                        resultSet.getInt("kamper"),
                        resultSet.getInt("sesonger"),
                        "Basketball",
                        resultSet.getInt("fgpercent"),
                        resultSet.getInt("ftpercent"),
                        resultSet.getDouble("poengsnitt")

                );
                basketballCards.add(basketballCard);
            }
            return basketballCards;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<BaseballCard> getBaseballCards() {
        List<BaseballCard> baseballCards = new ArrayList<>();

        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM baseballkort");
            while (resultSet.next()) {
                BaseballCard baseballCard = new BaseballCard(
                        resultSet.getInt("id"),
                        resultSet.getInt("serie"),
                        resultSet.getString("tilstand"),
                        resultSet.getString("spillernavn"),
                        resultSet.getString("klubb"),
                        resultSet.getInt("kamper"),
                        resultSet.getInt("sesonger"),
                        "Baseball",
                        resultSet.getInt("homeruns")
                );
                baseballCards.add(baseballCard);
            }
            return baseballCards;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    // TODO: Skrive ut antall samlerkort registrert
    public int getCardsAmount() {
        int cardsAmount = 0;
        try (Connection connection = getConnection()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT (select count(*) from baseballkort) + (select count(*) from basketballkort)+ (select count(*) from fotballkort) as total_rows");
            while (resultSet.next()) {
                cardsAmount = resultSet.getInt("total_rows");
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return cardsAmount;
    }
    // TODO: Skrive ut informasjon om alle samlerkort i "mint condition"


}
