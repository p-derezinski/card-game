package pl.derezinski.card_game.game_elements;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String playerName;
    private int lifeCount = 20;
    private int brownResources = 0;
    private int orangeResources = 0;
    private int yellowResources = 0;
    private int greenResources = 0;
    private int totalResources = brownResources + orangeResources + yellowResources + greenResources;
    private List<Card> deck = new ArrayList<>(60);
    private List<Card> hand = new ArrayList<>();
    private List<Card> table = new ArrayList<>();
    private List<Card> graveyard = new ArrayList<>();

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getLifeCount() {
        return lifeCount;
    }

    public void setLifeCount(int lifeCount) {
        this.lifeCount = lifeCount;
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

    public List<Card> getDeck() {
        return deck;
    }

    public void setDeck(List<Card> deck) {
        this.deck = deck;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void setHand(List<Card> hand) {
        this.hand = hand;
    }

    public List<Card> getTable() {
        return table;
    }

    public void setTable(List<Card> table) {
        this.table = table;
    }

    public List<Card> getGraveyard() {
        return graveyard;
    }

    public void setGraveyard(List<Card> graveyard) {
        this.graveyard = graveyard;
    }
}
