package pl.derezinski.card_game.game_elements;

public class ResourcesCounters {

    private Player player;
    private int brownResources;
    private int orangeResources;
    private int yellowResources;
    private int greenResources;
    private int totalResources;

    public ResourcesCounters(Player player) {
        this.player = player;
        this.brownResources = player.getBrownResources();
        this.orangeResources = player.getOrangeResources();
        this.yellowResources = player.getYellowResources();
        this.greenResources = player.getGreenResources();
        this.totalResources = player.getTotalResources();
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getBrownResources() {
        return brownResources;
    }

    public void setBrownResources(int brownResources) {
        this.brownResources = brownResources;
    }

    public int getOrangeResources() {
        return orangeResources;
    }

    public void setOrangeResources(int orangeResources) {
        this.orangeResources = orangeResources;
    }

    public int getYellowResources() {
        return yellowResources;
    }

    public void setYellowResources(int yellowResources) {
        this.yellowResources = yellowResources;
    }

    public int getGreenResources() {
        return greenResources;
    }

    public void setGreenResources(int greenResources) {
        this.greenResources = greenResources;
    }

    public int getTotalResources() {
        return totalResources;
    }

    public void setTotalResources(int totalResources) {
        this.totalResources = totalResources;
    }
}
