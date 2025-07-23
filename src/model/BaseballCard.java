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
        return "model.BaseballCard{" +
                "id=" + getId() +
                ", cardSeriesId=" + getCardSeriesId() +
                ", condition='" + getCondition() + '\'' +
                ", playerName='" + getPlayerName() + '\'' +
                ", club='" + getClub() + '\'' +
                ", seasonsPlayed=" + getSeasonsPlayed() +
                ", gamesPlayed=" + getGamesPlayed() +
                ", sport='" + getSport() + '\'' +
                "homeruns=" + homeruns +
                '}';
    }
}
