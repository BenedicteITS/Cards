public class BaseballCard extends Card {

        private int homeruns;

        BaseballCard(int id, int cardSeriesId, String condition, String playerName, String club, int seasonsPlayed, int gamesPlayed, String sport,int homeruns) {

            super(id, cardSeriesId, condition, playerName, club, seasonsPlayed, gamesPlayed, sport);

            this.homeruns = homeruns;
        }

        //Getter
        public int getHomeruns() {
            return this.homeruns;
        }

    @Override
    public String toString() {
        return "BaseballCard{" +
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
