import cs1.Keyboard;

public class HighLow extends Cards{

    Object dealerCard = 0;
    Object playerCard = 0;
    
    public static boolean play(){
	HighLow bob = new HighLow();
	return bob.playHelp();
    }

    public boolean playHelp(){

	createDeck();
	
	dealerCard = deck.get((int) (Math.random() * 52));
        playerCard = deck.get((int) (Math.random() * 52));

	int bet = 0;
	
	System.out.println("Your card is " + playerCard + ".");
	System.out.println("Choose the number of who you think has the higher card.");
	System.out.println("1. Tie");
	System.out.println("2. Dealer.");
	System.out.println("3. You.");
	bet = Keyboard.readInt();

	System.out.println("The dealer's card is " + dealerCard + ".");
	countCards();
	
	//System.out.println(dealerCard);
	//System.out.println(playerCard);

	int maxCard = Math.max((int)dealerCard, (int)playerCard);

	if (bet == 1){
	    if ((int)dealerCard == (int)playerCard){
		System.out.println("It was a tie!!!"); 
		return true;
	    }
	}
	if (bet == 2){
	    if ( maxCard == (int)dealerCard){
		System.out.println("You won!!");
		return true;
	    }
	    else {
		System.out.println("You lost :(");
		return false;
	    }
	}
	else {
	    if (maxCard == (int)playerCard){
		System.out.println ("You won!!");
		return true;
	    }
	    else{
		System.out.println("You lost :(");
		return false;
	    }
	}	    
    }

    public void countCards(){

        //changes the cards that are words to numbers
	
	if (dealerCard.equals("King")){
	    dealerCard = 13;
	}
        if (dealerCard.equals("Queen")){
	    dealerCard = 12;
	}
        if (dealerCard.equals("Jack")){
	    dealerCard = 11;
	}
        if (dealerCard.equals("Ace")){
	    dealerCard = 14;
	}

	
	if (playerCard.equals("King")){
	    playerCard = 13;
	}
	if (playerCard.equals("Queen")){
	    playerCard = 12;
	}
        if (playerCard.equals("Jack")){
	    playerCard = 11;
	}
        if (playerCard.equals("Ace")){
	    playerCard = 14;
	}
	//System.out.println(playerCard);
	//System.out.println(dealerCard);
	
    }
}
