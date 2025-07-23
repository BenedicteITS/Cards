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
        return "model.BasketballCard{" + "id=" + getId() +
                ", cardSeriesId=" + getCardSeriesId() +
                ", condition='" + getCondition() + '\'' +
                ", playerName='" + getPlayerName() + '\'' +
                ", club='" + getClub() + '\'' +
                ", seasonsPlayed=" + getSeasonsPlayed() +
                ", gamesPlayed=" + getGamesPlayed() +
                ", sport='" + getSport() + '\'' +
                "fgPercent=" + fgPercent +
                ", ftPercent=" + ftPercent +
                ", averagePoints=" + averagePoints +
                '}';
    }
}
