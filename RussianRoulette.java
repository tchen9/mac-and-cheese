public class RussianRoulette{
    public static boolean play(){
	System.out.println("Spinning . . .");
	System.out.println("You pull the trigger and . . . ");
	System.out.println(". . . . .");
        System.out.println(". . . .");
	System.out.println(". . .");
	System.out.println(". .");
	System.out.println(".");
	if ((int) (Math.random() * 6) > 1){
	    System.out.println("Whew! You're safe! Congratulations!");
	    return true;
	}
	else{
	    System.out.println("Sorry, you died. Game Over! Come back another life");
	    return false;
	}
    }
}
