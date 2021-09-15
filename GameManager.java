import java.util.Scanner;
import java.util.Random;
// Controls the overall flow of the game
// This includes input, checking games states
// and initialization of the board itself. 
public class GameManager{     
    // Shorthand for players
    public static final char playerX = 'X';
    public static final char playerO = 'O';

    // The board object itself. Holds game state. 
    private TicTacToe board = new TicTacToe();
    private char playersTurn = playerX;
                                
    public static void main(String[] args){
        // Create the Game Manager object itself. 
        GameManager man = new GameManager();

        // start up game
        man.initGame();
        
        // Game loop (until game is over). 
        while(!man.isGameOver()){
            man.nextTurn(); 
        }

        // Quit. 
        System.out.println("Thanks for playing");
        System.exit(0);
    }

    // Initialize Game  
    private void initGame(){
        // ... Your Code Here
        // initializing game board and current status
        int move = 0;
        do
        {
            System.out.println("Enter the size: ");
            Scanner scan = new Scanner(System.in);
            move = scan.nextInt();            
        }while(move < 2 && move > 100); 
        
        board = new TicTacToe(move);
        board.initBoard();
        
        // represent that player 'X' goes first 
        playersTurn = 'X';  
        
        // Random object
        //char[] array = new char[]{ 'X' , '0'}; 
        //Random random=new Random();
        //playersTurn = (char)(random.nextInt(array.length));      
    }
    
    // Update playersTurn variable
    private void nextPlayer(){
       if(playersTurn=='X'){
            playersTurn='0';
       }else {
            playersTurn='X';
         }        
    }
    
    private void nextTurn(){
        // ... Your Code Here
        // row, col and size variables
        int row;
        int col;
        int size=board.getSize();
         
        // prints out which player's turn currently is!
        System.out.println("It's "+playersTurn+" turn");
            
        // scanner object for user input
        Scanner scan=new Scanner(System.in);
        
        // get row from the user
        System.out.println("Enter rows: ");
        row=scan.nextInt();
        
        // get col from the user
        System.out.println("Enter col: ");
        col=scan.nextInt();
        
        // checks if the user has entered valid row and col
        if(row<size && col<size && (board.getTile(row , col) != 'X' && board.getTile(row , col) != '0') && row >= 0 && col >= 0){
            board.setTile(row , col , playersTurn);
            
            // prints out the current state of board
            System.out.println(board.toString());
        }else   {
            // if the condition is not true, prints out invalid row and col entered
            System.out.println("Sorry! You enter invalid row and column");
           }   
        
        // checking rows for player to win   
        for(int i=0; i<size; i++)
            if(board.getTile(i,0)==board.getTile(i,1) && board.getTile(i,1)==board.getTile(i,2) && board.getTile(i,0)!='.'){
                playerWon(playersTurn);
            }
        
        // checking columns for player to win
        for(int j=0; j<size; j++)
            if(board.getTile(0,j)==board.getTile(1,j) && board.getTile(1,j)==board.getTile(2,j) && board.getTile(0,j)!='.'){
                playerWon(playersTurn);
            }
          
        // checking diagonals for player to win
        if(board.getTile(0,0)==board.getTile(1,1) && board.getTile(1,1)==board.getTile(2,2) && board.getTile(0,0)!='.'){
            playerWon(playersTurn);
        }
        if(board.getTile(2,0)==board.getTile(1,1) && board.getTile(1,1)==board.getTile(0,2) && board.getTile(2,0)!='.'){
            playerWon(playersTurn);
        }       
        
        // if current player has not won go to the next player
        nextPlayer();
    }

    // Is the game over? 
    private boolean isGameOver(){
        return board.gameOver();
    }

    // A player has won, output a message and quit the game. 
    private void playerWon(char playerThatWon){
        System.out.println("Player " + playerThatWon + " won the game!");
        System.exit(0);
    }

}