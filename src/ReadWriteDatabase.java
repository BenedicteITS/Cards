import javax.xml.crypto.Data;

public class ReadWriteDatabase {

Database database = new Database("sql/database.properties");

    public static void insertCardSeries(CardSeries cardSeries){

        System.out.println(cardSeries);
    }

    public void insertBaseballCard(BaseballCard baseballCard){

        System.out.println(baseballCard);
    }
    public void insertBasketballCard(BasketballCard basketballCard){

        System.out.println(basketballCard);
    }
    public void insertFootballCard(FootballCard footballCard){

        System.out.println(footballCard);
    }
}
