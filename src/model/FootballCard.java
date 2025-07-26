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
        return "-------------------------------------------------------- \n" +
                "Football card: \n"
                + "Id: " + getId() + "\n" +
                "CardSeries Id: " + getCardSeriesId() + "\n" +
                "Condition: " + getCondition() + "\n"+
                "PlayerName: " + getPlayerName() + "\n"+
                "Club: " + getClub() + "\n"+
                "SeasonsPlayed: " + getSeasonsPlayed() + "\n"+
                "GamesPlayed: " + getGamesPlayed() + "\n"+
                "Sport: " + getSport() + "\n"+
                "LeagueGoals: " + leagueGoals + "\n"+
                "CupGoals: " + cupGoals + "\n"+
                "-------------------------------------------------------- \n";
    }
}
