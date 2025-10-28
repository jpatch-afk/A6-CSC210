import java.util.ListIterator;
import java.util.Collections;

public class SelectionSort {
  
  public static CardPile sort(CardPile unsorted, SortRecorder record) {
    
    // register the starting configuration with the recorder
    record.add(unsorted);

    //new sorted pile
    CardPile sorted = new CardPile();

    //Iterator for the unsorted pile
    ListIterator<Card> pos = unsorted.listIterator();


    while(!unsorted.isEmpty()){
      Card min = unsorted.getFirst();
      Card new_card = pos.next();
      while(pos.hasNext()) {
        int compare = min.compareTo(new_card); 

        if(compare == 0) {
          min = new_card;
          pos.next();
        }
        else if(compare < 0) {
          pos.next();
        }
        else if(compare >= 0){
          min = new_card;
          pos.next();
        }
      }
      unsorted.remove(min);
      sorted.add(min);

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
