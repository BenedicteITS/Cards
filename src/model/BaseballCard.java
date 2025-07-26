package model;

public class BaseballCard extends Card {

    private int homeruns;

    public BaseballCard(int id, int cardSeriesId, String condition, String playerName, String club, int seasonsPlayed, int gamesPlayed, String sport, int homeruns) {
        super(id, cardSeriesId, condition, playerName, club, seasonsPlayed, gamesPlayed, sport);
        this.homeruns = homeruns;
    }

    public int getHomeruns() {

        return this.homeruns;
    }

    @Override
    public String toString() {
        return "-------------------------------------------------------- \n" +
                "Basketball card: \n"
                + "Id: " + getId() + "\n" +
                "CardSeries Id: " + getCardSeriesId() + "\n" +
                "Condition: " + getCondition() + "\n"+
                "PlayerName: " + getPlayerName() + "\n"+
                "Club: " + getClub() + "\n"+
                "SeasonsPlayed: " + getSeasonsPlayed() + "\n"+
                "GamesPlayed: " + getGamesPlayed() + "\n"+
                "Sport: " + getSport() + "\n"+
                "Homeruns: " + homeruns + "\n" +
                "-------------------------------------------------------- \n";
    }
}
