
public class QuicksortTimer {   
  public static void main(String[] args) {
    if (args.length<1) {
      System.err.println("Please specify how many cards to sort!");
    } else {
      Card[] deck = Card.newDeck(true);
      CardPile cards = new CardPile();
            
      for (int i = 0; i<Integer.parseInt(args[0]); i++ ) {
        cards.add(deck[(int)(52*Math.random())]);
      }
      
    sort(cards);
            
    }
  }

  /**
   * sorts the given CardPile using the QuickSort method
   * @param unsorted initial CardPle to sort
   * @return sorted CardPile
   */
  public static CardPile sort(CardPile unsorted) {

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
    
    // This will hold the assembled result
    CardPile result = new CardPile();
        
    //recursive calls 
    CardPile smallerSorted = sort(smaller);
    CardPile biggerSorted = sort(bigger);
    
    result.append(smallerSorted);
    result.add(pivot);
    result.append(biggerSorted);
        
    // return the sorted result here
    return result;
  }
}
