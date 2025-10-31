public class InsertionSortTimer {
    
    public static void main(String[] args) {
          
        if (args.length < 1) {
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
     * sorts the unsorted pile through InsertionSort method
     * @param unsorted pile to be sorted
     * @return the sorted version of the initial sorted pile
     */
    public static CardPile sort(CardPile unsorted) {

        CardPile sorted = new CardPile();
   
        while(!unsorted.isEmpty()) {
            Card new_card = unsorted.removeFirst();
            int i = 0;
            while(i < sorted.size() && new_card.compareTo(sorted.get(i)) > 0) {
              i++;
            }
            sorted.add(i, new_card);
        }
        return sorted;
    }
}
