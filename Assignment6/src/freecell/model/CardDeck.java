package freecell.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class CardDeck {

  List<Card> deck = new ArrayList<>();
  List<Card> dealingDeck = new PriorityQueue<>();

  //Returns the same order
  CardDeck() {

  }

  //iterate through deck, set priorities, put into priority queue. Poll all out.
  protected Card deal() {

  }

  protected String print() {

  }

}
