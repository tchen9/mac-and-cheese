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
	
    private int[] place(int column){
		int[] answer = new int[2];
		int r = 0;
		while(Playboard[r][column] == 0){
			r++;
		}
		if(Playboard[0][column] != 0){
			answer[0] = -1;
			answer[1] = -1;
		}
		else{
			Playboard[r - 1][column] = 1;
			answer[0] = r - 1;
			answer[1] = column;
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

    public static void main(String[] args){
	ConnectFour game = new ConnectFour();
	System.out.println(game);
	game.place(1);
	System.out.println(game.Playboard);
    }

}
