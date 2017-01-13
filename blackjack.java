import java.util.ArrayList;

public class blackjack{
    private int dealerCount;
    private String dealerHand;
    private int playCount;
    private String playerHand;
    //private static ArrayList<Object> deck;

    
    ArrayList<Object> deck = new ArrayList();
    
    public static boolean play(){
        blackjack bob = new blackjack();
        bob.playHelp();
        return true;
    }
    
    public boolean playHelp(){
        //ArrayList<Object> deck = new ArrayList();
        createDeck();
        String s;
        s = "Your Hand: ";
        s += pickcard();
        s += ", ";
        s += pickcard();
        System.out.println(s);
        s = "\nDealer's Hand: ";
        s += pickcard();
        s += ", ";
        s += "UNKNOWN";
        System.out.println(s);
	    System.out.println("Congradulations! You won!!");
	    return true;
    }

    public Object pickcard(){
        int index = (int) (Math.random() * deck.size());
        Object thing;
        thing = deck.get(index);
        deck.remove(index);
        return thing;
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
	
    public static void deal(){}
    public static void hit(){}
    public static boolean stay(){
	return true;
    }
    public static void dealerMove(){}
    
    /*public static void main(String[] args){
        blackjack Frank = new blackjack();
        Frank.play();
    }*/

}
