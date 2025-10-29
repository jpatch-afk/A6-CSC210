import java.util.ArrayDeque;
import java.util.Collections;

public class MergeSort {
  
  /**
   * Sorts a CardPile using the MergeSort method
   * @param unsorted CardPile to be sorted
   * @param record SortRecorder the sorts the cards visually
   * @return sorted version of initial CardPile
   */
  public static CardPile sort(CardPile unsorted, SortRecorder record) {
    
    ArrayDeque<CardPile> queue = new ArrayDeque<CardPile>();
  
    //making each card in unsorted its own pile and adding it to the queue
    for(Card card: unsorted){
      CardPile new_pile = new CardPile();
      new_pile.add(card);
      queue.add(new_pile);
    }

    record.next();
    for(CardPile pile: queue) {
      record.add(pile);
    }

    while(queue.size() > 1){
      CardPile first = queue.removeFirst();
      CardPile second = queue.removeFirst();

      CardPile merge = mergeLists(first, second);

      queue.add(merge);

      record.next();
      for(CardPile pile: queue) {
        record.add(pile);
      }
    }
    // return the sorted result here
    return queue.remove();
  }

  public static CardPile mergeLists(CardPile first, CardPile second) {

    CardPile tempList = new CardPile();

    while (!first.isEmpty() && !second.isEmpty()) {
      if(first.getFirst().compareTo(second.getFirst()) > 0) {
        tempList.add(second.removeFirst());
      }
      else if(first.getFirst().compareTo(second.getFirst()) <= 0) {
        tempList.add(first.removeFirst());
      }
    }
    //if second list is empty, but first still has elements
    while(!first.isEmpty()) {
      tempList.insertAfter(first, tempList.getLast());
    }
    //if first list is empty, but second still has elements 
    while(!second.isEmpty()) {
      tempList.insertAfter(second, tempList.getLast());
    }

    return tempList;
  }

  public static void main(String[] args) {
    
    SortRecorder recorder = new SortRecorder();

    // set up the deck of cards
    Card.loadImages(recorder);
    
    CardPile cards = new CardPile(Card.newDeck(true), 2, 2);
  
    //mixing up cards
    Collections.shuffle(cards);
  
    cards = MergeSort.sort(cards, recorder);
  
    System.out.println(cards);
  
    recorder.display("Card Sort Demo: MergeSort");
  }
}
