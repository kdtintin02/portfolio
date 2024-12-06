import java.util.Scanner;

class TicTacToe{
    private char[][] board;
    private char currentPlayer;
    
    public TicTacToe(){
        board = new char[3][3];
        currentPlayer = 'X';
        initializeBoard();
    }
    
    public void initializeBoard(){
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                board[i][j] = '#';
            }
        }
    }
    
    public void printBoard(){
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
    
    public boolean fullBoard(){
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                if (board[i][j] == '#'){
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean checkWin(){
        for (int i=0; i<3; i++){
            if ((board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer)||(board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer)){
                return true;
            }
        }
        if ((board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer)||(board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer)){
            return true;
        }
        return false;
    }
    
    public void changePlayer(){
        if (currentPlayer=='X'){
            currentPlayer='O';
        }else{
            currentPlayer='X';
        }
    }
    
    public char getCurrentPlayer(){
        return currentPlayer;
    }
    
    public boolean markBoard(int row, int col){
        if ((row>=0 && row<=3) && (col>=0 && col<=3)){
            if (board[row][col]=='#'){
                board[row][col]=currentPlayer;
                return true;
            }
        }
        return false;
    }
}

public class TicTacToeGame
{
	public static void main(String[] args) {
	    System.out.println("================");
	    System.out.println("TIC TAC TOE GAME");
	    System.out.println("================");
		Scanner input = new Scanner(System.in);
		TicTacToe newGame = new TicTacToe();
		int row, col;
		while (true){
		    newGame.printBoard();
		    System.out.print(newGame.getCurrentPlayer()+" enter position (x y): ");
		    row = input.nextInt();
		    col = input.nextInt();
		    
		    if (newGame.markBoard(row,col)){
		        if (newGame.checkWin()){
		            System.out.println("Player "+newGame.getCurrentPlayer()+" wins!");
		            break;
		        }
		        if (newGame.fullBoard()){
		            System.out.println("Draw...");
		            break;
		        }
		        newGame.changePlayer();
		    }else{
		        System.out.println("not valid");
		    }
		}
		newGame.printBoard();
		input.close();
	}
}