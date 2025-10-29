import java.util.Collections;

public class Quicksort {
  
  public static CardPile sort(CardPile unsorted, SortRecorder record) {

    record.add(unsorted);
    record.next();

    if(unsorted.size() >= 1) {
      return unsorted;
    }
    
    // Here are the two partitions you will be creating
    CardPile smaller = new CardPile();
    CardPile bigger = new CardPile();

    Card pivot = unsorted.removeFirst(); 

    for(Card card: unsorted){
      if(card.compareTo(pivot) < 0) {
        smaller.add(card);
      }
      if(card.compareTo(pivot) >= 0) {
        bigger.add(card);
      }
    }
    
    // register the partitions with the recorder
    record.add(smaller);
    record.add(pivot);
    record.add(bigger);
    record.next();

    // This will hold the assembled result
    CardPile result = new CardPile();
    
    //recursive calls 
    CardPile smallerSorted = sort(smaller,record);
    CardPile biggerSorted = sort(bigger, record);

    result.append(smallerSorted);
    result.add(pivot);
    result.append(biggerSorted);

    // record the sorted result
    record.add(result);
    record.next();
    
    // return the sorted result here
    return result;
  }

  public static void main(String[] args) {

    SortRecorder recorder = new SortRecorder();

    // set up the deck of cards
    Card.loadImages(recorder);
    
    CardPile cards = new CardPile(Card.newDeck(true), 2, 2);

    Collections.shuffle(cards);

    cards = Quicksort.sort(cards, recorder);

    System.out.println(cards);

    recorder.display("Card Sort Demo: QuickSort");
    
  }
}
