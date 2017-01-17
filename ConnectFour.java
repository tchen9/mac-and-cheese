import cs1.Keyboard;

public class ConnectFour{

    private int[][] Playboard = new int[6][7];
//	private int[][] Playboard = { {1, 0, 0, 0, 0, 0, 6}, {0, 1, 0, 0, 0, 2, 9}, {0, 0, 1, 0, 6, 5, 6}, {0, 0, 0, 1, 4, 5, 6}, {2, 0, 0, 0, 0, 0, 0}, {0, 4, 8, 3, 4, 5, 6} };
    private boolean Victory = false;
    private int[] Available = new int[6];
    private int winner = 0;

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
    
    public String toString(int[][] board){
	String s = "";
	for (int x = 0; x < board.length; x ++){
	    for (int y = 0; y < board[0].length; y ++){
		s += board[x][y];
		s += "  ";
	    }
	    s += "\n";
	}
	return s;
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
	
/*	public static boolean play(){
	    System.out.println("0 0 0 0 0 0 0\n0 0 0 0 0 0 0 \n0 0 0 0 0 0 0 \n0 0 0 0 0 0 0 \n0 0 0 0 0 0 0\n0 0 0 0 0 0 0");
	     if (Math.random() > 0.5) {
            System.out.println("Congradulations! You won!!");
            return true;
            
        }
        else{
            System.out.println("Sorry! You lost!!");
            return false;
        }
	}*/
	
	public static boolean play(){
		System.out.println("You are 1, the computer is 2");
		ConnectFour pencil = new ConnectFour();
		while(pencil.Victory == false){
			System.out.println("Pick the Column (starting from 0)");
			int choice = Keyboard.readInt();
			pencil.place(choice, 1);
			pencil.computerMove();
			System.out.println(pencil);
			pencil.isGameOver();
		}
		System.out.println("The winner is " );
		System.out.println(pencil.winner);
		if(pencil.winner == 1){
			pencil.wipe();
			return true;
		}
		else{
			pencil.wipe();
			return false;
		}
	}
	
	public void wipe(){
		for(int[] q: Playboard){
			for(int r: q){
			r = 0;
	    }
		}
		Victory = false;
		Available = new int[6];
		winner = 0;
	}
	
	public boolean isGameOver(){
		boolean answer = false;
		for(int[] q: Playboard){ //Tests columns
			for(int x = 0; x < 4; x++){
				if(q[x] != 0 && q[x]==q[x+1] && q[x]==q[x+2] && q[x]==q[x+3]){
					answer = true;
					Victory = true;
					winner = q[x];
				}
			}
		}
		
		
		for(int q = 0; q < 3; q++){//Row win
			for(int x = 0; x<7; x++){
				if(Playboard[q][x] != 0 && Playboard[q][x]==Playboard[q+1][x] && Playboard[q][x]==Playboard[q+2][x] && Playboard[q][x]==Playboard[q+3][x]){
					answer = true;
					Victory = true;
					winner = Playboard[q][x];
				}
			}
			
		}
		
		for(int q = 0; q < 3; q++){//Diagonal up
			for(int x = 6; x > 2; x-- ){
				if(Playboard[q][x] != 0 && Playboard[q][x]==Playboard[q+1][x-1] && Playboard[q][x]==Playboard[q+2][x-2] && Playboard[q][x]==Playboard[q+3][x-3]){
					answer = true;
					Victory = true;
					winner = Playboard[q][x];
				}
			}
		}
		
		for(int q = 0; q < 3; q++){//Diagonal down
			for(int x = 0; x < 4; x++){
				if(Playboard[q][x] != 0 && Playboard[q][x]==Playboard[q+1][x+1] &&Playboard[q][x]==Playboard[q+2][x+2] && Playboard[q][x]==Playboard[q+3][x+3]){
					answer = true;
					Victory = true;
					winner = Playboard[q][x];
				}
			}
		}
		
		
		
		return answer;
	}

    public static void main(String[] args){
		//System.out.println(play(5));
    }



}
