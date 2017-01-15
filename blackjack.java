import java.util.ArrayList;
import cs1.Keyboard;

public class blackjack{
    private int dealerCount;
    private ArrayList dealerHand = new ArrayList();
    private int playerCount;
    private ArrayList playerHand = new ArrayList();
    //private static ArrayList<Object> deck;

    
    ArrayList<Object> deck = new ArrayList();
    
    public static boolean play(){
        blackjack bob = new blackjack();
        bob.playHelp();
        return true;
    }
    
    public boolean playHelp(){
        createDeck();
        String s;
        s = "Your Hand: ";
        playerHand.add(pickcard());
        playerHand.add(pickcard());
        playerCount = countCards(playerHand);
        System.out.print(s);
        System.out.println(playerHand);
        //System.out.println(playerCount);
        s = "\nDealer's Hand: ";
        System.out.print(s);
        dealerHand.add(pickcard());
        System.out.print(dealerHand);
        dealerHand.add(pickcard());
        dealerCount = countCards(dealerHand);
        //System.out.println(dealerCount);
        //System.out.println(dealerHand);
        s = "(Other card unknown)";
        System.out.println(s);
        s = "Would you like to hit, or stay? (Enter h for hit, s for stay)";
        System.out.println(s);
        while (Keyboard.readString().equals("h")){
            hit();
            if (playerCount > 21){
                System.out.println("Sorry, you lose! Game Over…");
                return false;
            }
            else{
                s = "Do you want to hit again? (Enter h for hit, s for stay)";
                System.out.println(s);
            }
            
            
        }
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
    
    public int countCards(ArrayList thing){
        int counter = 0;
        for (Object x: thing){
            if (x instanceof Integer){
                counter += (int) x;
            }
            else{
                if (x.equals("Ace")){
                    counter += 1;
                }
                else{
                    counter += 10;
                }
            }
        }
        return counter;
    }
	
    public static void deal(){}
    public void hit(){
        Object card = pickcard();
        System.out.println("Your new card is: " + card);
        playerHand.add(card);
        System.out.print("Your hand is now: ");
        System.out.println(playerHand);
        playerCount = countCards(playerHand);
    }
    public static void dealerMove(){}
    
    public static void main(String[] args){
        blackjack Frank = new blackjack();
        Frank.playHelp();
    }

}
