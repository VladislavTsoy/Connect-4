public class Board {
	
	public int row;
	public int col;
	public char nameOne;
	public char nameTwo;
	public char[][] place;
	
	//calculate steps so as to know whether there are still empty space on board
	public int step = 0; 
	
	public Board(){
		row = 6;
		col = 7;
		place = new char[row][col];
		for(int i=0; i<row ;i++){
			for (int j =0; j<col; j++)
				place[i][j] = ' ';
		}
	}
	
	public Board(int rowNum, int colNum){
		row = rowNum;
		col = colNum;
		place = new char[row][col];
		for(int i=0; i<row ;i++){
			for (int j =0; j<col; j++)
				place[i][j] = ' ';
		}
	}
	
	public int getNumRows(){
		return row;
	}
	public int getNumCols(){
		return col;
	}
	
	public void setPlayerOne(char o){
		nameOne = o;
	}
	
	public void setPlayerTwo(char t){
		nameTwo = t;
	}
	
	public char getPlayerOne(){
		return nameOne;
	}
	
	public char getPlayerTwo(){
		return nameTwo;
	}
	
	public char getToken(int row, int col){
		if(row>=0 && row <=6 && col >=0 && col <=7){
			return place[row][col];
		}
		else{
			return '\0';
		}
	}
	
	public boolean canPlay(){
		boolean flag = false;
		for(int i=0; i<row ;i++){
			for (int j =0; j<col; j++){
				if(place[i][j] == ' '){
					flag = true;
					break;
				}
			}
		}
		return flag;
	}
	
	public boolean play(int p, int c){
		char symbol;
		if(p == 1) symbol = nameOne;
		else if(p == 2) symbol = nameTwo;
		else return false;
		//if(c<1 || c>col){
		if(c<0||c>col-1){
			return false;
		}
		else{
			boolean flag = false;
			for(int i = row-1; i>=0; i--){
				if(place[i][c] == ' '){
					flag = true;
					place[i][c] = symbol;
					step++;
					break;
				}
			}
			if(flag == true) return true;
			else return false;
		}
	}
	
	
	public int isFinished(){
		int win = 0;
		int count;
		char last = 0;
		//vertical
		for(int i=0; i<row; i++){
			count = 0;
			last = 0;
			for(int j=0; j<col; j++){
				if(place[i][j] == last) count++;
				else {
					last = place[i][j];
					count = 1;
				}
				if(count >= 4 && last!=' ') {
					win = 1;
					break;
				}
			}
		}
		
		//horizontal
		for(int j=0; j<col; j++){
			count = 0;
			last = 0;
			for(int i=0; i<row; i++){
				if(place[i][j] == last) count++;
				else{
					last = place[i][j];
					count = 1;
				}
				if(count >= 4 && last != ' ') {
					win = 1;
					break;
				}
			}
		}
		
		//diagonal
		for( int i = 0; i <= row - 4; i++){
		    count = 0;
		    last = 0;
		    int thisRow, thisCol;
		    for( thisRow = i, thisCol = 0; thisRow < row && thisCol < col; thisRow++, thisCol++ ){
		        if(place[thisRow][thisCol] == last){
		            count++;
		        }
		        else {
		        	last = place[thisRow][thisCol];
		            count = 1;
		        }
		        if(count >= 4 && last != ' ') {
		        	win = 1;
		        	break;
		        }
		    }
		}
		
		for( int i = 0; i < row; i++){
		    count = 0;
		    last = 0;
		    int thisRow, thisCol;
		    for( thisRow = i, thisCol = col-1; thisRow < row && thisCol >= 0; thisRow++, thisCol-- ){
		        if(place[thisRow][thisCol] == last){
		            count++;
		        }
		        else {
		        	last = place[thisRow][thisCol];
		            count = 1;
		        }
		        if(count >= 4 && last != ' ') {
		        	win = 1;
		        	break;
		        }
		    }
		}
		
		for( int j = 0; j <= col - 4; j++){
		    count = 0;
		    last = 0;
		    int thisRow, thisCol;
		    for( thisRow = 0, thisCol = j; thisRow < row && thisCol < col; thisRow++, thisCol++ ){
		        if(place[thisRow][thisCol] == last){
		            count++;
		        }
		        else {
		        	last = place[thisRow][thisCol];
		            count = 1;
		        }
		        if(count >= 4 && last != ' ') {
		        	win = 1;
		        	break;
		        }
		    }
		}
		
		for( int j = col-1; j >= 3; j--){
		    count = 0;
		    last = 0;
		    int thisRow, thisCol;
		    for( thisRow = 0, thisCol = j; thisRow < row && thisCol >= 0; thisRow++, thisCol--){
		        if(place[thisRow][thisCol] == last){
		            count++;
		        }
		        else {
		        	last = place[thisRow][thisCol];
		            count = 1;
		        }
		        if(count >= 4 && last != ' ') {
		        	win = 1;
		        	break;
		        }
		    }
		}
		if(win == 0) {
			if(step == row*col)
				win = 0;
			else
				win = -1;
		}
		else if (win == 1){
			if(last == nameOne)
				win = 1;
			if(last == nameTwo)
				win = 2;
		}
		
		return win;
	}
	
	
	public void showBoard(){
		for(int i=0; i<row; i++){
			for (int j = 0; j<col; j++){
				if(place[i][j] == ' ') System.out.print(0+" ");
				else System.out.print(place[i][j]+ " ");
			}
			System.out.println("");
		}
	}
	
}
