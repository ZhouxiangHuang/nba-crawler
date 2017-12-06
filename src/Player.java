import com.sun.org.apache.xpath.internal.operations.Bool;

public class Player {
    private String name;
    private String pos;
    private boolean injured;

    public String getName(){
        return name;
    }

    public void setName(String playerName){
        name = playerName;
    }

    public String getPos(){
        return pos;
    }

    public void setPos(String playerPos){
        pos = playerPos;
    }

    public void setInjured(boolean isInjured){
        injured = isInjured;
    }

    public boolean isInjured() {
        return injured;
    }

}
