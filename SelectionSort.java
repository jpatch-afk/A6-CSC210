import java.util.Collections;

public class SelectionSort {
  
  /**
   * Sorts a CardPile using the Selection sort method
   * @param unsorted CardPile to be sorted
   * @param record SortRecorder that sorts the cards visually
   * @return a sorted version of 
   */
  public static CardPile sort(CardPile unsorted, SortRecorder record) {
    
    // register the starting configuration with the recorder
    record.add(unsorted);

    //new sorted pile
    CardPile sorted = new CardPile();

    while(!unsorted.isEmpty()){
      Card min = unsorted.getFirst();
      for(Card card: unsorted){
        if(card.compareTo(min) >= 0) {
          min = card;   
        }
      }
      sorted.add(min);
      unsorted.remove(min);


      record.next();
      record.add(sorted);   
      record.add(unsorted); 
    }
    // return the sorted result here
    return sorted;
  }

public static void main(String[] args) {
  SortRecorder recorder = new SortRecorder();

  // set up the deck of cards
  Card.loadImages(recorder);
  
  CardPile cards = new CardPile(Card.newDeck(true), 2, 2);

  //mixing up cards
  Collections.shuffle(cards);

  cards = SelectionSort.sort(cards, recorder);

  System.out.println(cards);

  recorder.display("Card Sort Demo: SelectionSort");
  }
}


