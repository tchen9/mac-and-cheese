import cs1.Keyboard;
import java.util.ArrayList;

public class Woo{

    private double balance;
    private int gameType;
    
    public void play(){
	String s = "";
	s += "Hello, Welcome to the Mac and Cheese Casino.\n";
	s += "How much money do you want to start with? Enter initial amount. (Ex: 30.00)\n";
	System.out.println(s);
	balance = Keyboard.readDouble();
	s = "You will an option of 3 games to play: Connect 4, BlackJack, and HighLow.\n";
	s += "Desciption:\n";
	s += "1. Connect 4: Play against the computer and try to get four in a row.Your pieces will be 1's and the computer's pieces will be 8's.\n";
	s += "2. Black Jack: You will get 2 cards and an option to get another card. The computer will also get 2 cards and if there cards are below 16 they have to draw another one. Whoever has cards closest to 21 will win.\n";
	s += "3. HighLow: You each get two cards, but you don't see your card. You can only see the computer card. You bet how ever much money you want for who has the higher card.\n";
	s += "Pick the number of the game you want to play. \n";
	System.out.println(s);
	gameType = Keyboard.readInt();
	if (gameType == 1){
	    ConnectFour.play();
	}
	else if (gameType == 2){
	    blackjack.play();
	}
	else if (gameType == 3){
	    HighLow.play();
	}
    }

    public static void main(String[] args){
	Woo bob = new Woo();
	bob.play();
	
    }
}
