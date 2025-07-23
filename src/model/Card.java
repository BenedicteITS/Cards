package model;

public abstract class Card {
    private int id;
    private int cardSeriesId;
    private String condition;
    private String playerName;
    private String club;
    private int seasonsPlayed;
    private int gamesPlayed;
    private String sport;

    //Constructor
    public Card(int id, int cardSeriesId, String condition, String playerName, String club, int seasonsPlayed, int gamesPlayed, String sport) {
        this.id = id;
        this.cardSeriesId = cardSeriesId;
        this.condition = condition;
        this.playerName = playerName;
        this.club = club;
        this.seasonsPlayed = seasonsPlayed;
        this.gamesPlayed = gamesPlayed;
        this.sport = sport;
    }

    public int getId() {
        return id;
    }

    public int getCardSeriesId() {
        return cardSeriesId;
    }

    public String getCondition() {
        return condition;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getClub() {
        return club;
    }

    public int getSeasonsPlayed() {
        return seasonsPlayed;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public String getSport() {
        return sport;
    }

    @Override
    public String toString() {
        return "AbstractCard{" +
                "id=" + id +
                ", cardSeriesId=" + cardSeriesId +
                ", condition='" + condition + '\'' +
                ", playerName='" + playerName + '\'' +
                ", club='" + club + '\'' +
                ", seasonsPlayed=" + seasonsPlayed +
                ", gamesPlayed=" + gamesPlayed +
                ", sport='" + sport + '\'' +
                '}';
    }
}
