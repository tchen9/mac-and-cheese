public class HighLow{
    public static boolean play(){
	    if (Math.random() > 0.5) {
            System.out.println("Congradulations! You won!!");
            return true;
            
        }
        else{
            System.out.println("Sorry! You lost!!");
            return false;
        }
    }
}