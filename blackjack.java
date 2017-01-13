import java.util.ArrayList;

public class blackjack{
    private int dealerCount;
    private String dealerHand;
    private int playCount;
    private String playerHand;

    ArrayList<Object> deck = new ArrayList();
    
    public static boolean play(){
	System.out.println("Congradulations! You won!!");
	return true;
    }

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
	
    public static  void deal(){}
    public static void hit(){}
    public static boolean stay(){
	return true;
    }
    public static void dealerMove(){}
   
    public static void main(String[] args){
	String s = "BLACKJACK";
	System.out.println(s);
	blackjack Frank = new blackjack();
	System.out.println(Frank.deck);
    }
}
