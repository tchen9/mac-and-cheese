public class ConnectFour{

    private int[][] Playboard = new int[7][6];
    private boolean Victory;
    private int[] Available = new int[6];

    public connectFour(){
	for(int[] q: Playboard){
	    for(int r: q){
		r = 0;
	    }
	}
    }

    private String toString(){
	String answer = "";
	for(int[] q: Playboard){
	    for(int r: q){
		answer += "|" + r + "|";
	    }
	    answer += "\n";
	}
    }

    private int[] place(int column){
	int r = 0;
	
    }

}
