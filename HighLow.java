public class HighLow{
    public static boolean play(){
	int dealerCard = Math.random() * 10;
	int playerCard = Math.random() * 10;
	int bet = 0;
	
	System.out.println("Your card is " + playerCard + ".");
	System.out.println("Choose the number of who you think has the higher card.");
	System.out.println("1. Dealer");
	System.out.println("2. You.");
	bet = Keyboard.readInt();

	int maxCard = max(dealerCard, playerCard);

	if (bet == 1){
	    if ( maxCard == dealerCard){
		System.out.println("You won!!");
		return true;
	    }
	    else {
		System.out.println("You lost :(");
		return false;
	}
	else {
	    if (maxCard == playerCard){
		System.out.println ("You won!!");
		return true;
	    }
	    else{
		System.out.println("You lost :(");
		return false;
	    }
	}	    
    }
}
