import java.util.ArrayList;

public class blackjack{
    private int dealerCount;
    private String dealerHand;
    private int playCount;
    private String playerHand;
    public static ArrayList deck;

    public blackjack(){
	for (int x = 2; x < 11; x++){
	    for (int y = 0; y < 4; x++){
		deck.add(x);
		//System.out.println(deck);
		    }
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
	System.out.println(deck);
    }
}
