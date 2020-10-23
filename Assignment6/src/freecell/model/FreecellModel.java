package freecell.model;

import java.util.List;

public class FreecellModel implements FreecellOperations<K> {

  OPile oPileArray = new OPile();
  FPile fPileArray = new FPile();
  CPile cPileArray = new CPile();

  int oPileNumber = 4;
  int cPileNumber = 8;



  List<K> getDeck();

  void startGame(List<K> deck, boolean shuffle) throws IllegalArgumentException;


  void move(PileType source,
            int pileNumber,
            int cardIndex,
            PileType destination,
            int destPileNumber) throws IllegalArgumentException,
          IllegalStateException;


  boolean isGameOver();

  String getGameState();




  public void setOPileNumber() {

  }

  public void setCPileNumber() {

  }

}
