import java.util.ArrayDeque;

public class MergeSortTimer {
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
     * sorts the unsorted pile using the MergeSort method
     * @param unsorted CardPile to be sorted
     * @return sorted version of initial CardPile
     */
    public static CardPile sort(CardPile unsorted) {
    
        ArrayDeque<CardPile> queue = new ArrayDeque<CardPile>();
  
        //making each card in unsorted its own pile and adding it to the queue
        for(Card card: unsorted){
            CardPile new_pile = new CardPile();
            new_pile.add(card);
            queue.add(new_pile);
        }

        while(queue.size() > 1){
            CardPile first = queue.removeFirst();
            CardPile second = queue.removeFirst();

            CardPile merge = mergeLists(first, second);

            queue.add(merge);
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
}