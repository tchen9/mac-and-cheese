import java.util.ArrayList;
import cs1.Keyboard;

public class blackjack extends Cards{
    private int dealerCount;
    private ArrayList dealerHand = new ArrayList();
    private int playerCount;
    private ArrayList playerHand = new ArrayList();
    //private static ArrayList<Object> deck;

    
    ArrayList<Object> deck = new ArrayList();
    
    public static String play(){
        blackjack bob = new blackjack();
        return bob.playHelp();
    }
    
    public String playHelp(){
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
            playerHit();
            if (playerCount > 21){
                System.out.println("Sorry, you lose! Game Over…");
                return "Lose";
            }
            if (playerHand.size() > 4){
                System.out.println("Congratulations!! You win!");
                return "Win";
            }
            else{
                s = "Do you want to hit again? (Enter h for hit, s for stay)";
                System.out.println(s);
            }
            
            
        }
        
        s = "Your Hand: ";
        System.out.print(s);
        System.out.println(playerHand);
        s = "Your cards add up to ";
        System.out.print(s);
        System.out.println(playerCount);
        if (blackjack(playerHand)){
            System.out.println("Congratulations!! You got a blackjack!");
            return "Blackjack";
        }
        
        System.out.println("\nDealer's turn . . .");
        
        while (dealerCount <= 16){
            s = "\nDealer's hand is " + dealerHand;
            System.out.println(s);
            dealerHit();
        }
        
        
        s = "==========================================================\nReults:\n\n";
        s += "Your Hand: ";
        System.out.print(s);
        System.out.println(playerHand);
        s = "Your cards add up to ";
        System.out.print(s);
        System.out.println(playerCount);
        
        s = "Dealer's Hand: ";
        System.out.print(s);
        System.out.println(dealerHand);
        s = "Dealer's cards add up to ";
        System.out.print(s);
        System.out.println(dealerCount);
        
        if (dealerCount > 21){
            System.out.println("Congratulations!! You win!");
            return "Win";
        }
        
        if (dealerCount > playerCount){
            System.out.println("Sorry, you lost! Come back again");
            return "Lose";
        }
        
        if (dealerCount == playerCount){
            System.out.println("Draw! You and the dealer have the same card value");
            return "Draw";
        }
        
        else{
            System.out.println("Congratulations!! You win!");
            return "Win";
        }
            
        
    }

    public Object pickcard(){
        int index = (int) (Math.random() * deck.size());
        Object thing;
        thing = deck.get(index);
        deck.remove(index);
        return thing;
    }
    
    public boolean blackjack(ArrayList thing){
        return (thing.get(0) == "Ace" || thing.get(1) == "Ace") && (thing.get(0) == "King" || thing.get(0) == "Queen" || thing.get(0) == "Jack" || thing.get(0).equals(10) || thing.get(1) == "King" || thing.get(1) == "Queen" || thing.get(1) == "Jack" || thing.get(1).equals(10));
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
                    System.out.println("Do you want your Ace to be 11 or 1?");
                    counter += Keyboard.readInt();
                }
                else{
                    counter += 10;
                }
            }
        }
        return counter;
    }
	
    public static void deal(){}
    public Object playerHit(){
        Object card = pickcard();
        System.out.println("Your new card is: " + card);
        playerHand.add(card);
        System.out.print("Your hand is now: ");
        System.out.println(playerHand);
        playerCount = countCards(playerHand);
        return card;
    }
    
    public Object dealerHit(){
        Object card = pickcard();
        System.out.println("Dealer's new card is: " + card);
        dealerHand.add(card);
        System.out.print("Dealer's hand is now: ");
        System.out.println(dealerHand);
        dealerCount = countCards(dealerHand);
        return card;
    }
    
    public static void dealerMove(){}
    
    public static void main(String[] args){
        blackjack Frank = new blackjack();
        Frank.playHelp();
    }

}
