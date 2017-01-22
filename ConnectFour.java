import cs1.Keyboard;
import java.util.ArrayList;

public class ConnectFour{

    private int[][] Playboard = new int[6][7];
//	private int[][] Playboard = { {0, 0, 0, 0, 0, 0, 2}, {0, 0, 0, 0, 0, 0, 1}, {0, 1, 0, 0, 0, 0, 5}, {1, 0, 0, 0, 0, 0, 3}, {1, 0, 0, 0, 0, 0, 3}, {0, 0, 0, 0, 0, 0, 6} };
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
	int y = this.findThree();
	int x = this.findTwo();
	int u = 0;
	for(int f = 0; f < 6; f++){
		if(Playboard[f][0]==0){
			u =f; 
		}
	}
	if(y!= -1){
		u = y;
	}
	else if(x!= -1){
		u = x;
	}
	this.place(u, 2);
    }
	

	
	public static boolean play(){
		System.out.println("You are 1, the computer is 2");
		ConnectFour pencil = new ConnectFour();
		String turn = "1";
		while(pencil.Victory == false){
		    if(turn == "1"){
			System.out.println("Pick the Column (starting from 0 up until 5)");
			int choice = Keyboard.readInt();
			pencil.place(choice, 1);
			System.out.println(pencil);
			pencil.isGameOver();
			turn = "2";
		    }
		    else{
			pencil.computerMove();
			System.out.println(pencil);
			pencil.isGameOver();
			turn = "1";
		    }
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

	
	
    /*	public int findThree(){//Doesn't work
		int threeInARow = 0;
		for (int x = 0; x < Playboard.length; x++){
			for (int y = 0; y < Playboard[0].length; y++){
				while (threeInARow != 3){
					if (Playboard[x][y] == 1){
					threeInARow++;
					}
				}
				if (threeInARow == 3 && y < 5){
					return y + 1; 
				}
			}
			threeInARow = 0;
		}
		return 10;
		}*/

    public int findThree(){
	int threeInARow = -1;
	for(int x = 0; x < 6; x++){
	    for(int q = 6; q > 2; q--){
		if(Playboard[x][q]!= 0 && Playboard[x][q]==Playboard[x][q-1] && Playboard[x][q]==Playboard[x][q-2]&&Playboard[x][q-3]==0){
		    threeInARow = x;
		}
	    }
	}

	for(int q = 6; q > -1; q--){
	    if(Playboard[0][q]!=0 && Playboard[1][q]==Playboard[0][q] && Playboard[0][q]==Playboard[2][q] && Playboard[3][q]==0){
		if(q==6){
		    threeInARow = 3;
		}
		else{
		    if(Playboard[3][q+1]!=0){
			threeInARow = 3;
		    }
		
	    }
	}

	}

	for(int q = 6; q > -1; q--){
		if(Playboard[5][q]!=0 && Playboard[5][q]==Playboard[4][q] && Playboard[5][q]==Playboard[3][q] && Playboard[2][q]==0){
			if(q==6){
				threeInARow = 2;
			}
			else{
				if(Playboard[2][q+1]!=0){
					threeInARow = 2;
				}
			}
		} 
	}

	
	for(int q = 6; q > -1; q--){
		for(int x = 1; x < 3; x++){
			if(Playboard[x][q]!=0 && Playboard[x][q]==Playboard[x+1][q] && Playboard[x][q]==Playboard[x+2][q]){
				if(Playboard[x-1][q]==0){
					if(q==6){
						threeInARow = x-1;
					}
					else if(Playboard[x-1][q+1]!=0){
						threeInARow = x-1;
					}
				}
				else if(Playboard[x+3][q]==0){
					if(q==6){
						threeInARow = x+3;
					}
					else if(Playboard[x+3][q+1]!=0){
						threeInARow = x+3;
					}
				}
			}
			
		}
	}
	
	//Middle Row
	
	
	return threeInARow;
    }


    public int findTwo(){
		int twoInARow = -1;
		for(int x = 0; x < 6; x++){
			for(int q = 6; q > 2; q--){
				if(Playboard[x][q]!= 0 && Playboard[x][q]==Playboard[x][q-1] && Playboard[x][q-2]==0){
					twoInARow = x;
				}
			}
		}
		
		for(int q = 6; q > -1; q--){
			if(Playboard[0][q]!=0 && Playboard[1][q]==Playboard[0][q] && Playboard[2][q]==0){
				if(q==6){
					twoInARow = 2;
				}
				else{
					if(Playboard[2][q+1]!=0){
						twoInARow = 2;
					}
		
				}
			}

		}

		
		for(int q = 6; q > -1; q--){
			if(Playboard[5][q]!=0 && Playboard[5][q]==Playboard[4][q] && Playboard[3][q]==0){
				if(q==6){
					twoInARow = 3;
				}
				else{
					if(Playboard[3][q+1]!=0){
						twoInARow = 3;
					}
				}
			} 
		}
		
		for(int q = 6; q > -1; q--){
			for(int x = 1; x < 4; x++){
				if(Playboard[x][q]!=0 && Playboard[x][q]==Playboard[x+1][q]){
					if(Playboard[x-1][q]==0){
						if(q==6){
							twoInARow = x-1;
						}
						else if(Playboard[x-1][q+1]!=0){
							twoInARow = x-1;
						}
					}
					else if(Playboard[x+2][q]==0){
						if(q==6){
							twoInARow = x+2;
						}
						else if(Playboard[x+2][q+1]!=0){
							twoInARow = x+2;
						}
					}
				}
			
			}
		}

	return twoInARow;

    }
	

	
    public static void main(String[] args){
		ConnectFour stuff = new ConnectFour();
		System.out.println(stuff);
		System.out.println(stuff.findTwo());
    
    }



}
