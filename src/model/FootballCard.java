package model;

public class FootballCard extends Card {
    private int leagueGoals;
    private int cupGoals;

    public FootballCard(int id, int cardSeriesId, String condition, String playerName, String club, int seasonsPlayed, int gamesPlayed, String sport, int leagueGoals, int cupGoals) {
        super(id, cardSeriesId, condition, playerName, club, seasonsPlayed, gamesPlayed, sport);
        this.leagueGoals = leagueGoals;
        this.cupGoals = cupGoals;
    }

    public int getLeagueGoals() {

        return this.leagueGoals;
    }

    public int getCupGoals() {

        return this.cupGoals;
    }

    @Override
    public String toString() {
        return "model.FootballCard{"
                + "id=" + getId() +
                ", cardSeriesId=" + getCardSeriesId() +
                ", condition='" + getCondition() + '\'' +
                ", playerName='" + getPlayerName() + '\'' +
                ", club='" + getClub() + '\'' +
                ", seasonsPlayed=" + getSeasonsPlayed() +
                ", gamesPlayed=" + getGamesPlayed() +
                ", sport='" + getSport() + '\'' +
                "leagueGoals=" + leagueGoals +
                ", cupGoals=" + cupGoals +
                '}';
    }
}
