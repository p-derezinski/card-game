package pl.derezinski.card_game.game_elements;

import java.util.Optional;

public class ResourcesBuilder {

    private String cardName;
    private String cardDescription;
    private Color color;

    public ResourcesBuilder cardName(String cardName) {
        this.cardName = cardName;
        return this;
    }

    public ResourcesBuilder cardDescription(String cardDescription) {
        this.cardDescription = cardDescription;
        return this;
    }

    public ResourcesBuilder color(Color color) {
        this.color = color;
        return this;
    }

    public Resources build() {
        Resources resources = new Resources();
        resources.setCardName(cardName);
        resources.setCardDescription(Optional
                .ofNullable(cardDescription)
                .orElse("No decsription provided."));
        resources.setColor(color);
        return resources;
    }

}
