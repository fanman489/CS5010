package freecell.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class OPile {

  List<Stack<Card>> oPileImpl = new ArrayList<>();

  protected OPile(int numberOfPiles) {
    for (int i = 0; i < numberOfPiles; i++) {
      oPileImpl.add(new Stack<>());
    }
  }

  //Check if stack is empty, if empty then add card
  protected void addCard(Card inputCard, int index) {
    if (oPileImpl.get(index).isEmpty()) {
      oPileImpl.get(index).push(inputCard);
    } else {
      throw new IllegalArgumentException("Cannot make this move.");
    }
  }

  //Check if not empty, then pop
  protected void removeCard(Card inputCard, int index) {
    if (!oPileImpl.get(index).isEmpty()) {
      oPileImpl.get(index).push(inputCard);
    } else {
      throw new IllegalArgumentException("Cannot make this move.");
    }
  }


  protected String print() {
     oPileArray = oPileImpl.toArray();
  }

}
