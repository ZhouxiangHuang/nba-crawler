import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class NBARosterCrawler {
    public static void main(String[] args) {

        String url= "http://www.espn.com/nba/teams/roster?team=bos";
        new NBARosterCrawler().crawl(url);
    }

    public boolean crawl(String url) {

        try {
            Connection connection = Jsoup.connect(url);
            Document rosterHtmlDocument = connection.get();
            Elements rosterElementList = rosterHtmlDocument.select(".sortcell a");

            ArrayList players = getPlayerList(rosterElementList);

        } catch (IOException ioe)
        {
            return false;
        }

        return true;
    }

    public ArrayList getPlayerList(Elements rosterList){
        ArrayList playerList = new ArrayList();

        for (Element player : rosterList) {
            playerList.add(player.text());
        }

        return playerList;
    }
}
