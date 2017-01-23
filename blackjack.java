import java.util.ArrayList;
import cs1.Keyboard;

public class blackjack extends Cards{
    private int dealerCount; //counts sum of dealer's cards
    private ArrayList dealerHand = new ArrayList(); //representation of dealer's hand
    private int playerCount; //counts sum of ;layer's cards
    private ArrayList playerHand = new ArrayList(); //representstaion of player's hand
    //private static ArrayList<Object> deck;

    
    ArrayList<Object> deck = new ArrayList(); //deck is the playing deck from which cards are drawn
    
    //called by driver when game is run
    public static String play(){
        blackjack bob = new blackjack();
        return bob.playHelp();
    }
    
    
    //wrapper function for play(), which is called by driver
    public String playHelp(){
        createDeck(); //makes a new deck
        String s;
        s = "Your Hand: ";
        playerHand.add(pickcard());
        playerHand.add(pickcard());
        playerCount = countCards(playerHand); //counts cards
        System.out.print(s);
        System.out.println(playerHand);
        if (blackjack(playerHand)){//blackjack ends game, player gets twice money
            System.out.println("Congratulations!! You got a blackjack!");
            return "Blackjack";
        }
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
        while (Keyboard.readString().equals("h")){ //h means hit, player has asked for another card
            playerHit();
            if (playerCount > 21){ //busted, game over 
                System.out.println("Sorry, you lose! Game Over…");
                return "Lose";
            }
            if (playerHand.size() > 4){ //you can win blackjack by having 5 or more cards on hand without busting
                System.out.println("Congratulations!! You win!");
                return "Win";
            }
            else{ //ask player what they want to do
                s = "Do you want to hit again? (Enter h for hit, s for stay)";
                System.out.println(s);
            }
            
            
        }
        
        //player ends turn
        s = "Your Hand: ";
        System.out.print(s);
        System.out.println(playerHand);
        s = "Your cards add up to ";
        System.out.print(s);
        System.out.println(playerCount);
        
        System.out.println("\nDealer's turn . . .");
        
        while (dealerCount <= 16){ //dealer has to keep taking cards until his hand is greater than 16
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

    public Object pickcard(){ //method to draw a random card from the deck
        int index = (int) (Math.random() * deck.size());
        Object thing;
        thing = deck.get(index);
        deck.remove(index);
        return thing;
    }
    
    public boolean blackjack(ArrayList thing){ //checks if a hand is a blackjack
        return (thing.get(0) == "Ace" || thing.get(1) == "Ace") && (thing.get(0) == "King" || thing.get(0) == "Queen" || thing.get(0) == "Jack" || thing.get(0).equals(10) || thing.get(1) == "King" || thing.get(1) == "Queen" || thing.get(1) == "Jack" || thing.get(1).equals(10));
    }
    
    public void createDeck(){
        //creates a Object arraylist of cards
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
        //adds up the cards, returns int value
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

    public Object playerHit(){
        //simulates player taking a card, shows card, current hand.
        Object card = pickcard();
        System.out.println("Your new card is: " + card);
        playerHand.add(card);
        System.out.print("Your hand is now: ");
        System.out.println(playerHand);
        playerCount = countCards(playerHand);
        return card;
    }
    
    public Object dealerHit(){
        //same as playerHit, but for dealer
        Object card = pickcard();
        System.out.println("Dealer's new card is: " + card);
        dealerHand.add(card);
        System.out.print("Dealer's hand is now: ");
        System.out.println(dealerHand);
        dealerCount = countCards(dealerHand);
        return card;
    }
    

    /*public static void main(String[] args){
    //to test w/o going through Woo
        blackjack Frank = new blackjack();
        Frank.playHelp();
	}*/

}
