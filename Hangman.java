import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Hangman{

    public boolean playhelp(){
        ArrayList<String> Words = new ArrayList<String>();
        try{
            Scanner fileScanner = new Scanner(new File("Words.txt"));
        }
        
        catch(FileNotFoundException ex){
            Scanner fileScanner = new Scanner("hi");
        }
        while (fileScanner.hasNext()){
            Words.add(fileScanner.next());
        }
        return true;
    }
}
