import org.jsoup.Jsoup;
import org.jsoup.Connection;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class NBACrawler {
    public static void main(String[] args) {

        String url= "http://www.espn.com/nba/teams";
        new NBACrawler().crawl(url);

    }

    private boolean crawl(String url) {

        try {
            Connection connection = Jsoup.connect(url);
            Document teamsHtmlDocument = connection.get();
            Elements teamsElementList = teamsHtmlDocument.select(".logo-nba-medium a");

            ArrayList rostersLinks = getRostersLinks(teamsElementList);
            ArrayList scheduleLinks = getScheduleLinks(teamsElementList);


        } catch(IOException ioe) {
            return false;
        }

        return true;
    }

    private ArrayList getRostersLinks(Elements teamsElements) {
        ArrayList<String> rostersLinks = new ArrayList<>();

        for(Element team : teamsElements) {
            if(team.text().equals("Roster")) {
                rostersLinks.add(team.absUrl("href"));
            }
        }

        return rostersLinks;
    }

    private ArrayList getScheduleLinks(Elements teamsElements) {
        ArrayList<String> scheduleLinks = new ArrayList<>();

        for(Element team : teamsElements) {
            if(team.text().equals("Schedule")) {
                scheduleLinks.add(team.absUrl("href"));
            }
        }

        return scheduleLinks;
    }

}
