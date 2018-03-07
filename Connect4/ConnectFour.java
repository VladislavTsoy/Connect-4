public class ConnectFour{
	
	
	public static void main(String[] args){
		
		int c1,c2;
		ChipColor color1,color2;
		int playwith;
		int winner;
		boolean turn = true;
		
		color1 = ChipColor.RED;
		color2 = ChipColor.BLUE;
		
		GIO.displayMessage("Welcome to my connect 4 game!");
		do{
			c1 = GIO.readInt("Choose color for the first player\n0-4 respresents RED, BLACK, BLUE, GREEN, PURPLE respectively: ");
		}while(c1<0||c1>4);
		do{
			c2 = GIO.readInt("Choose color for the second player\n0-4 respresents RED, BLACK, BLUE, GREEN, PURPLE respectively: ");
			if(c2 == c1){
				GIO.displayMessage("You can set same color to both use.\nPlease enter a new one.");
				c2 = -1;
			}
		}while(c2<0||c2>4);
		
		do{
			playwith = GIO.readInt("Do you want to play an with AI or a human?\nEnter 0 if you want to play with AI\nEnter 1 if you want to play with human");
			if(playwith<0||playwith>1){
				GIO.displayMessage("You can only enter 0 or 1.");
				playwith = -1;
			}
		}while(playwith<0);
		
				
		switch(c1){
		case 0: color1 = ChipColor.RED;break;
		case 1: color1 = ChipColor.BLACK;break;
		case 2: color1 = ChipColor.BLUE;break;
		case 3: color1 = ChipColor.GREEN;break;
		case 4: color1 = ChipColor.PURPLE;break;
		}
		
		switch(c2){
		case 0: color2 = ChipColor.RED;break;
		case 1: color2 = ChipColor.BLACK;break;
		case 2: color2 = ChipColor.BLUE;break;
		case 3: color2 = ChipColor.GREEN;break;
		case 4: color2 = ChipColor.PURPLE;break;
		}
		
		Board myBoard = new Board();
		
		CFGUI myGUI = new CFGUI(myBoard,color1,color2 );
		
		myBoard.setPlayerOne('a');
		myBoard.setPlayerTwo('b');
		
		Player p1 = new HumanPlayer(1,6,7);
		Player p2 = new AIPlayer(2,6,7);
		if(playwith == 0){
			p2 = new AIPlayer(2,6,7);
		}
		else{
			p2 = new HumanPlayer(2,6,7);
		}
		
		int lastmove = -1;
		while(myBoard.isFinished() == -1){
			if(turn == true){
				p1.lastMove(lastmove);
				lastmove = p1.playToken();
				//System.out.println(lastmove);
				myBoard.play(p1.getPlayerID(), lastmove);
				myGUI.redraw();
				turn = false;
			}
			else{
				p2.lastMove(lastmove);
				lastmove = p2.playToken();
				//System.out.println(lastmove);
				myBoard.play(p2.getPlayerID(), lastmove);
				myGUI.redraw();
				turn = true;
			}
		}
		
		winner = myBoard.isFinished();
		
		myGUI.gameOver(winner);
		
		myGUI.close();
		
		/*
		//Set player tokens for player 1 and player 2
		myBoard.setPlayerOne('a');
		myBoard.setPlayerTwo('b');
		
		//Create Player objects
		//Note, the code below works because of the interface Player. All classes that "implement" Player can be
		// typed as Player. Makes switching from Human to AI Players really easy. For a challenge, you might
		// consider:
		//		1. asking the user whether he/she wants to play against a human or a computer
		//		2. implementing multiple AI players (easy, med, hard) that the user can choose to play against
		
		Player p1 = new HumanPlayer(1,6,7);
		Player p2 = new AIPlayer(2,6,7); //comment this line when testing AIPlayer
		
		

		myBoard.play(p1.getPlayerID(), p1.playToken());
		myBoard.play(p2.getPlayerID(), p2.playToken());
		myBoard.play(p1.getPlayerID(), p1.playToken());
		myBoard.play(p2.getPlayerID(), p2.playToken());
		myBoard.play(p1.getPlayerID(), p1.playToken());
		myBoard.play(p2.getPlayerID(), p2.playToken());
		
		
		
		//Print your empty board
		myBoard.showBoard();
		
		//WHILE the board is still playable
		//	get a column to play from player 1
		//	play that token on the board
		//  print the board
		//		has anyone won yet?
		// do the above for player 2
		
		// Get the status code from the board (isFinished())
		
		// Print out the results of the game
		*/
		
	}
	
}