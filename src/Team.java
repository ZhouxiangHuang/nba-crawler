import java.util.List;

public class Team {
    private String name;
    private List roster;
    private int gamesCount = 0;

    public List getRoseter() {
        return roster;
    }

    public void setRoster(List teamRoster) {
        roster = teamRoster;
    }

    public void addPlayer(String playerName) { }

    public String getName() {
        return name;
    }

    public void setName(String teamName) {
        name = teamName;
    }

    public void incrGame() {
        gamesCount++;
    }

    public int getGamesPlaying() {
        return gamesCount;
    }
}
