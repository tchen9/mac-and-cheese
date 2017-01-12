public class ConnectFour{

    private int[][] Playboard = new int[6][7];
	private boolean Victory;
    private int[] Available = new int[6];

    public void  connectFour(){
	for(int[] q: Playboard){
	    for(int r: q){
		r = 0;
	    }
	}
    }
	
	public void populate(){
		for(int r = 0; r < 6; r++){
			for(int q = 0; q < 7; q++){
				Playboard[r][q] = q;
			}
		}
	}

    public String toString(){
	String answer = "";
	for(int r = 0; r < 7; r++){
		for(int[] q: Playboard){
			answer += "|" + q[r] + "|";
		}
		answer += "\n";
	}
	return answer;
    }
	
    private int[] place(int column, int player){
        int[] answer = new int[2];
	int r = 0;
	while(r < 7 && Playboard[column][r] == 0){
	    r++;
	}
	if(Playboard[column][0] != 0  ){
	    answer[0] = -1;
	    answer[1] = -1;
	}
	else{
	    Playboard[column][r-1] = player;
	    answer[0] = column;
	    answer[1] = r;
	}
	return answer;
    }
	
    public static String toString(int[] intArray){
		String answer = "[";
		for( int r: intArray){
			answer += r + ", ";
		}
		answer += "]";
		return answer;
	}

    public void computerMove(){
	int y = (int) (Math.random() * 6);
	this.place(y, 2);
    }

    public static void main(String[] args){
	ConnectFour game = new ConnectFour();
	System.out.println(game);
	game.computerMove();
	System.out.println(game);
	for(int x = 0; x < 10; x++){
	    game.computerMove();
	    System.out.println(game);
	}

    }



}
