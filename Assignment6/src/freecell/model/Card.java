package freecell.model;


// Do I need to check negatives?

public class Card {

  private final int cardNumber;

  private final Suit cardSuit;
  enum Suit {SPADE, DIAMOND, CLUB, HEART};

  private int priority;

  protected Card(int number, Suit cardSuitType) {
    cardNumber = number;
    cardSuit = cardSuitType;
  }

  protected boolean checkCascade(Card input) {
    if (this.getNumber() - input.getNumber() == 1) {
      if (this.getSuit() == Suit.SPADE || this.getSuit() == Suit.CLUB) {
        return (input.getSuit() == Suit.DIAMOND || input.getSuit() == Suit.HEART);

      } else {
        return this.getSuit() == Suit.SPADE || this.getSuit() == Suit.CLUB;
      }
    }
    return false;
  }

  protected boolean checkFoundation(Card input) {
    return (input.getNumber() - this.getNumber() == 1 && input.getSuit() == this.getSuit());
  }

  protected void setPriority(int assignedPriority) {
    priority = assignedPriority;
  }

  protected int getNumber() {
    return cardNumber;
  }

  protected Suit getSuit() {
    return cardSuit;
  }


}
