package edu.sjsu.assignment1;

/**
 * Represents a card.
 */
public class Card {

    private final String shortHand;
    private final String description;
    private final String UNKNOWN = "Unknown";

    /**
     * Construct a card based on the shorthand.
     *
     * @param shortHand the shorthand of the card
     */
    public Card(String shortHand) {
        this.shortHand = shortHand;
        this.description = setDescription();
    }

    /**
     * Get full rank based on the shorthand of rank.
     *
     * @return full rank of card. A -> Ace, 1 -> One, etc.
     */
    private String getRank() {
        String rankShort = shortHand.substring(0, shortHand.length() - 1);
        // get full rank based on the shorthand of rank
        return switch (rankShort) {
            case "A" -> "Ace";
            case "1" -> "One";
            case "2" -> "Two";
            case "3" -> "Three";
            case "4" -> "Four";
            case "5" -> "Five";
            case "6" -> "Six";
            case "7" -> "Seven";
            case "8" -> "Eight";
            case "9" -> "Nine";
            case "10" -> "Ten";
            default -> UNKNOWN;
        };
    }

    private String getSuit() {
        char suitShort = shortHand.charAt(shortHand.length() - 1);
        return switch (suitShort) {
            case 'H' -> "Hearts";
            case 'D' -> "Diamonds";
            case 'S' -> "Spades";
            case 'C' -> "Clubs";
            default -> UNKNOWN;
        };
    }

    private String setDescription() {
        // set description based on the shorthand
        String rank = getRank();
        if (rank.equals(UNKNOWN))
            return UNKNOWN;
        String suit = getSuit();
        if (suit.equals(UNKNOWN))
            return UNKNOWN;
        return rank + " of " + suit;
    }

    /**
     * Get the full description of the card.
     *
     * @return full description of the card, like Ace of Hearts, etc.
     */
    public String getDescription() {
        return description;
    }
}
