public class HumanPlayer implements Player{
//do not change the line above	
	
	//Define your fields here
	public int ID;
	public char[][] place;
	public int Row;
	public int Col;
	public boolean firstMove;
	
	
	//constructor takes the player id for this player, and the number of 
	// rows and columns of the board we're playing on
	public HumanPlayer(int playerID, int row, int col){

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
		int number;
		/*
		do{
			System.out.println("Enter the column number: ");
			number = IO.readInt();
			if(number < 0 || number > Col-1) {
				number = -1;
				//System.out.println("Invalid input");
			}
			else if(place[0][number] != ' '){
				number = -1;
				System.out.println("Column is ful, please choose another one: ");
			}
		}while(number < 0);
		*/
		do{
			number = GIO.readInt("Please enter the column you want to put the token(0-6):");
			if(number<0||number>6){
				GIO.displayMessage("You must enter number between 0 and 6");
				number = -1;
			}
			else if(place[0][number] != ' '){
				GIO.displayMessage("This column is already full, please enter a new one: ");
				number = -1;
			}
		}while(number<0);
		
		
		for(int i=Row-1; i>=0; i--){
			if(place[i][number] == ' '){
				place[i][number] = '2';
				break;
			}
		}
		
		return number;
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