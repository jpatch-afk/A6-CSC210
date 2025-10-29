import java.util.ListIterator;
import java.util.Collections;

public class InsertionSort {
  
  public static CardPile sort(CardPile unsorted, SortRecorder record) {
    
    // register the starting configuration with the recorder
    record.add(unsorted);

    CardPile sorted = new CardPile();

    ListIterator<Card> pos = sorted.listIterator();
   
    while(!unsorted.isEmpty()){

      if(sorted.isEmpty()) {
        sorted.add(unsorted.removeFirst());
      }

      Card new_Card = unsorted.getFirst();

      int compare = new_Card.compareTo(sorted.getFirst());

      if(compare == 0){
        sorted.insertAfter(new_Card, sorted.getFirst());
      }
      else if(compare < 0){
        sorted.insertBefore(new_Card, sorted.getFirst());
      }
      else if(compare > 0) {
        Card sorted_card = pos.next();
        while(compare > 0){
          compare = new_Card.compareTo(sorted_card);

          if(compare == 0) {
            sorted.insertAfter(new_Card, sorted_card);
          }
          else if(compare < 0){
            sorted.insertBefore(new_Card, sorted_card);
          }
          else if(compare > 0){
            pos.next();
          }
        }
      }

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
