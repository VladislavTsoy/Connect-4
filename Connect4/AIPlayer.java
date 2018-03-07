public class AIPlayer implements Player{
//do not change the line above	
	
	//Define your fields here
	public int ID;
	public char[][] place;
	public int Row;
	public int Col;
	public boolean firstMove;
	
	
	//constructor takes the player id for this player, and the number of 
	// rows and columns of the board we're playing on
	public AIPlayer(int playerID, int row, int col){
		ID = playerID;
		Row = row;
		Col = col;
		place = new char[row][col];
		for (int i=0; i<row; i++){
			for(int j=0; j<col; j++){
				place[i][j] = ' ';
			}
		}
		firstMove = true;
	}
	
	//used to notify your AI player of the other players last move
	public void lastMove(int c) {
		if(c==-1){}
		else{
			for(int i=Row-1; i>=0; --i){
				if(place[i][c] == ' ') {
					place[i][c] = '1';
					break;
				}
			}
		}
		
		if(firstMove == true) firstMove = false;
	}
	
	//returns column of where to play a token
	public int playToken(){
		int position = 0;
		if(firstMove == true){
			place[Row-1][0] = '2';
			position = 0;
			firstMove = false;
		}
		else{
			for(int j=0; j<Col; j++){
				boolean flag = false;
				if(place[0][j] == ' '){
					position = j;
					flag = true;
					for(int i=Row-1; i>=0; i--){
						if(place[i][j] == ' ') {
							place[i][j] = '2';
							break;
						}
					}
				}
				if(flag == true) break;

			}
		}
		return position;
	}
	
	//get this player's id
	public int getPlayerID(){
		return ID;
	}
	
	//resets the state of the player in preparation for a new game
	public void reset(){
		for (int i=0; i<Row; i++){
			for(int j=0; j<Col; j++){
				place[i][j] = ' ';
			}
		}
	}
}