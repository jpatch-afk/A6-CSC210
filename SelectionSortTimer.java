import java.util.ListIterator;

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

    public static CardPile sort(CardPile unsorted){

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
            else if(compare > 0){
                min = new_card;
                pos.next();
            }
        }
        unsorted.remove(min);
        sorted.add(min);
        }
        // return the sorted result here
        return sorted;
    }
}
