public class ConnectFour{

    private int[][] Playboard = new int[7][6];
    private boolean Victory;
    private int[] Available = new int[6];

    public void  connectFour(){
	for(int[] q: Playboard){
	    for(int r: q){
		r = 0;
	    }
	}
    }

    public String toString(){
	String answer = "";
	for(int[] q: Playboard){
	    for(int r: q){
		answer += "|" + r + "|";
	    }
	    answer += "\n";
	}
	return answer;
    }

    private int[] place(int column){
	int[] answer = new int[2];
	int r = 0;
	while(Playboard[column][r] != 0 && r<6){
	    r++;
	}
	if(r == 6){
	    answer[0] = column;
	    answer[1] = -1;
	}
	else{
	    Playboard[column][r] = 1;
	}
	return answer;
    }

    public static void main(String[] args){
	ConnectFour game = new ConnectFour();
	System.out.println(game);
	game.place(5);
	System.out.println(game);

    }

}
