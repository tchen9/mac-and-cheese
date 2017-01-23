import cs1.Keyboard;
import java.util.ArrayList;

public class Woo{

    private double balance;
    private int gameType;
    private double bet;
    
    public void play(){

	//description
	String s = "";
	s += "Hello, Welcome to the Mac and Cheese Casino.\n";
	s += "How much money do you want to start with? Enter initial amount. (Ex: 30.00)\n";
	System.out.println(s);

	//user input
	balance = Keyboard.readDouble();
	s = "You will an option of 3 games to play: Connect 4, BlackJack, HighLow, and Hangman.\n";
	s += "Desciption:\n";
	s += "1. Connect 4: Play against the computer and try to get four in a row.Your pieces will be 1's and the computer's pieces will be 8's.\n";
	s += "2. Black Jack: You will get 2 cards and an option to get another card. The computer will also get 2 cards and if there cards are below 16 they have to draw another one. Whoever has cards closest to 21 will win.\n";
	s += "3. HighLow: You each get a card, but you don't see the dealer's card. You can only see your card. You bet how ever much money you want for who has the higher card.\n";
	s += "4. Russian Roulette: Spin a 6 cartridge revolver and place it against your head and press the trigger.  If you fire with a blank, you're safe, and win three times your bet.  But if you die, you lose everything and the game ends\n";
	s += "5. Hangman: You have 6 tries to guess the letters of a word";
    s += "Press 9 to check your balance";
	System.out.println(s);

	//user chooses game
	s = "Pick the number of the game you want to play. \n";
	System.out.println(s);
	gameType = Keyboard.readInt();

	//user chooses how much to bet
	s = "\nHow much do you want to bet? (ex: 3.00)";
	System.out.println(s);
	bet = Keyboard.readDouble();

	//case for when amount entered is greater than the balance
	while (bet > balance){
	    System.out.println("You don't have enough money. Enter another number.");
	    bet = Keyboard.readDouble();
	}
	s = "You will now start the game.";
	System.out.println(s);
	if (gameType == 1){
       	    if (ConnectFour.play()){
		winMoney();	
	    }
	    else {
		loseMoney();
	    }
	}
	else if (gameType == 2){
	    String thing;
	    thing = blackjack.play();
	    if (thing == "Win"){
		winMoney();
	    }
	    else if (thing == "Draw"){
		System.out.println("Since it's a draw, you don't get any money.");
	    }
	    else if (thing == "Blackjack"){
		winMoney();
		winMoney();
		}
	    else {
		loseMoney();
	    }
	}
	else if (gameType == 3){
	    if (HighLow.play()){
		winMoney();
	    }
	    else{
		loseMoney();
	    }
        }

	else if (gameType == 4){
	    System.out.println("Warning, if you lose you lose everything.");
	    if (RussianRoulette.play()){
		winMoney();
		winMoney();
		winMoney();
	    }
	    else{
		loseMoney();
		System.exit(0);
	    }
        }
	else if (gameType == 5){
	    if (Hangman.play()){
		winMoney();
	    }
	    else{
		loseMoney();
	    }
	}
        else if (gameType == 9){
            System.out.println("Your current balance is $" + balance + ".");
        }
        if (balance > 0.0){
	    System.out.println("Your current balance is $" + balance + ".");
	    replay();
	}
	else{
	    System.out.println("You've gone bankrupt!!!");
	}
    }

    //continues the game after one game is done
    public void replay(){
	String s;
	s = "Pick the number of the game you want to play. (Or press 0 to leave the Casino)\n";
	System.out.println(s);
	gameType = Keyboard.readInt();
	if (gameType == 0){
	    System.out.println("Your current balance is $" + balance + ".");
	    System.out.println("Thanks for playing! Come back soon!");
	    System.exit(0);
	}
	s = "How much do you want to bet? (ex: 3.00) (enter 0 if checking balance)";
	System.out.println(s);
	bet = Keyboard.readDouble();
	if (bet > balance){
	    System.out.println("You don't have enough money. Enter another number.");
	    bet = Keyboard.readDouble();
	}
	s = "You will now start the game.";
	System.out.println(s);
	if (gameType == 1){
	    if (ConnectFour.play()){
		winMoney();	
	    }
	    else {
		loseMoney();
	    }
	}
	else if (gameType == 2){
	    if (blackjack.play() == "Win"){
		winMoney();
	    }
	    else if (blackjack.play() == "Draw"){
		System.out.println("Since it's a draw, you don't get any money.");
	    }
	    else if (blackjack.play() == "Blackjack"){
		winMoney();
		winMoney();
		}
	    else {
		loseMoney();
	    }
	}
	else if (gameType == 3){
	    if (HighLow.play()){
		winMoney();
	    }
	    else{
		loseMoney();
	    }
	}
	else if (gameType == 4){
	    if (RussianRoulette.play()){
		winMoney();
		winMoney();
		winMoney();
	    }
	    else{
		loseMoney();
		System.exit(0);
	    }
        }
	else if (gameType == 5){
	    if (Hangman.play()){
		winMoney();
	    }
	    else{
		loseMoney();
	    }
	}
        else if (gameType == 9){
            System.out.println("Your current balance is $" + balance + ".");
        }
        if (balance > 0.0){
	    replay();
	}
	else{
	    System.out.println("You've gone bankrupt!!!");
	}
    }

    // subtracts bet from balance
    public void loseMoney(){
	balance -= bet;
    }
    
    //adds bet to balance
    public void winMoney(){
	balance += bet;
    }

    public static void main(String[] args){
	Woo bob = new Woo();
	bob.play();
	
    }
}
