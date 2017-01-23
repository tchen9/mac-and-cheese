import java.util.ArrayList;
import cs1.Keyboard;

public abstract class Cards{
    
    protected ArrayList<Object> deck = new ArrayList();

    //creates a deck a cards from ace to king with 4 of each
    public void createDeck(){
        for (int x = 2; x < 11; x++){
            for (int y = 0; y < 4; y++){
            deck.add(x);
            //System.out.println(deck);
            }
        }
        for (int z = 0; z < 4; z++){
            deck.add("King");
            deck.add("Queen");
            deck.add("Jack");
            deck.add("Ace");
        }
    }


}
