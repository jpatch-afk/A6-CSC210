import java.util.ListIterator;

public class InsertionSortTimer {
    
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
     * sorts the unsorted pile through InsertionSort method
     * @param unsorted pile to be sorted
     * @return the sorted version of the initial sorted pile
     */
    public static CardPile sort(CardPile unsorted) {

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
        }
        return sorted;
    }
}
