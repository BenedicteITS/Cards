package model;

public class CardSeries {
    private int id;
    private String Publisher;
    private int releaseYear;
    private String sport;
    private int amountOfCardsInSeries;

    public CardSeries(int id, String publisher, int releaseYear, String sport, int amountOfCards) {
        this.id = id;
        Publisher = publisher;
        this.releaseYear = releaseYear;
        this.sport = sport;
        this.amountOfCardsInSeries = amountOfCards;
    }

    public int getId() {
        return id;
    }

    public String getPublisher() {
        return Publisher;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getSport() {
        return sport;
    }

    public int getAmountOfCardsInSeries() {
        return amountOfCardsInSeries;
    }

    @Override
    public String toString() {
        return "model.CardSeries{" +
                "id=" + id +
                ", Publisher='" + Publisher + '\'' +
                ", releaseYear=" + releaseYear +
                ", sport='" + sport + '\'' +
                ", amountOfCardsInSeries=" + amountOfCardsInSeries +
                '}';
    }
}
