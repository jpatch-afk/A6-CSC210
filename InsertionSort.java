import java.util.Collections;

public class InsertionSort {
  
  /**
   * Sorts a CardPile using the InsertionSort method
   * @param unsorted CardPile to be sorted
   * @param record SortRecorder that sorts the cards visually
   * @return sorted version of the initial CardPile
   */
  public static CardPile sort(CardPile unsorted, SortRecorder record) {
    
    // register the starting configuration with the recorder
    record.add(unsorted);

    CardPile sorted = new CardPile();

    //Adding first element of sorted cards
    sorted.add(unsorted.remove());

    while(!unsorted.isEmpty()) {
      Card new_card = unsorted.removeFirst();
      int i = 0;
      while(i < sorted.size() && new_card.compareTo(sorted.get(i))>0) {
        i++;
      }
      sorted.add(i, new_card);


    record.next();
    record.add(sorted);
    record.add(unsorted);
    }
   
    return sorted;
  }

  public static void main(String[] args) {
    
    SortRecorder recorder = new SortRecorder();

    // set up the deck of cards
    Card.loadImages(recorder);
    
    CardPile cards = new CardPile(Card.newDeck(true), 2, 2);

    Collections.shuffle(cards);

    cards = InsertionSort.sort(cards, recorder);

    System.out.println(cards);

    recorder.display("Card Sort Demo: InsertionSort");
  }
}