import org.jsoup.Jsoup;
import org.jsoup.Connection;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.*;

public class NBAScheduleCrawler {

    public static void main(String[] args) {

        String url= "http://www.espn.com/nba/teams/schedule?team=bos";
        new NBAScheduleCrawler().crawl(url);
    }

    private boolean crawl(String url) {
        try {
            Connection connection = Jsoup.connect(url);
            Document scheduleHtmlDocument = connection.get();
            Elements scheduleElements = scheduleHtmlDocument.select("tr");

            HashMap schduleMap = getScheduleSet(scheduleElements);

        } catch (IOException ioe)
        {
            return false;
        }

        return true;
    }

    private HashMap getScheduleSet(Elements scheduleElements) {
        HashMap schedule = new HashMap<String, String>();

        for (Element date : scheduleElements) {
            if(date.childNodeSize() > 1 && date.child(1).select(".team-name").hasText()) {
                String playingDate = date.child(0).text();
                String opponent = date.child(1).select(".team-name").text();
                schedule.put(playingDate, opponent);
            }
        }

        return schedule;
    }
}
