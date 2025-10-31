public class SelectionSortTimer {
    
    public static void main(String[] args) {
        if (args.length<1) {
            System.err.println("Please specify how many cards to sort!");
        } else {
            Card[] deck = Card.newDeck(true);
            CardPile cards = new CardPile();
            
            for (int i = 0; i<Integer.parseInt(args[0]); i++ ) {
              cards.add(deck[(int)(52*Math.random())]);
            }
      
            //Sort the cards
            sort(cards);
            
        }
    }

    /**
     * sorts the given unsorted CardPile using the SelectionSort Method
     * @param unsorted CardPile to be sorted
     * @return sorted version of the initial CardPile
     */
    public static CardPile sort(CardPile unsorted){

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
        
        }
        // return the sorted result here
        return sorted;
    }
}
