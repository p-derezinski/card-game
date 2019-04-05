package pl.derezinski.card_game.game_elements;

public class Counters {

    private int numberOfResourcesPerTurn = 1;
    private boolean isEndOfTurn = false;
    private boolean hasCardWithResourcesCostBeenPlayed = false;

    public int getNumberOfResourcesPerTurn() {
        return numberOfResourcesPerTurn;
    }

    public void setNumberOfResourcesPerTurn(int numberOfResourcesPerTurn) {
        this.numberOfResourcesPerTurn = numberOfResourcesPerTurn;
    }

    public boolean isEndOfTurn() {
        return isEndOfTurn;
    }

    public void setEndOfTurn(boolean endOfTurn) {
        isEndOfTurn = endOfTurn;
    }

    public boolean isHasCardWithResourcesCostBeenPlayed() {
        return hasCardWithResourcesCostBeenPlayed;
    }

    public void setHasCardWithResourcesCostBeenPlayed(boolean hasCardWithResourcesCostBeenPlayed) {
        this.hasCardWithResourcesCostBeenPlayed = hasCardWithResourcesCostBeenPlayed;
    }
}
