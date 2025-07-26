package model;

public class BasketballCard extends Card {
    private int fgPercent;
    private int ftPercent;
    private double averagePoints;

    public BasketballCard(int id, int cardSeriesId, String condition, String playerName, String club, int seasonsPlayed, int gamesPlayed, String sport, int fgPercent, int ftPercent, double averagePoints) {
        super(id, cardSeriesId, condition, playerName, club, seasonsPlayed, gamesPlayed, sport);
        this.fgPercent = fgPercent;
        this.ftPercent = ftPercent;
        this.averagePoints = averagePoints;
    }

    public int getFgPercent() {

        return this.fgPercent;
    }

    public int getFtPercent() {

        return this.ftPercent;
    }

    public double getAveragePoints() {
        return this.averagePoints;}

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
                "Fg Percent: " + getFgPercent() + "\n"+
                "Ft Percent: " + getFtPercent() + "\n"+
                "Average Points: " + getAveragePoints() + "\n" +
                "-------------------------------------------------------- \n";
    }
}
