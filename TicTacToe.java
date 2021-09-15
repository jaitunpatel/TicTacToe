//class contain info. about tictactoe game (classes,methods)
public class TicTacToe
{
   // 2D array of char
   private char[][] setChar;
   
   // board size variable
   private int size;
   
   // constructor
   // creates new 2D aray of char of size 3x3
   public TicTacToe(){
        size = 3;
        setChar=new char[size][size];
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
            setChar[i][j]='.';
            }
        }
   }    
    
   // creates new 2D array and sets all chars to '.'
   public TicTacToe(int size){
       this.size = size;
       setChar=new char[size][size];
       for(int i=0; i<size; i++){
           for(int j=0; j<size; j++){
               setChar[i][j]='.';
           }
       }
   }
    
   // creates new 2D array of char and is same size as startingArray
   // it doesn't assign directly, instead (deep copy)
   public TicTacToe(char[][] startingArray){
       for(int i=0; i<startingArray.length; i++){
           for(int j=0; j<startingArray[i].length; j++){
                   setChar[i][j]=startingArray[i][j];
           }
       }    
   }   
   
   // this method represents empty tile.
   public void initBoard(){
       for(int i=0; i<setChar.length; i++){
           for(int j=0; j<setChar[i].length; j++){
               setChar[i][j]='.';
           } 
       }
   }
   
   // method represents the given tile empty by setting it to '.'
   public boolean isEmpty(int row, int col){
       if(setChar[row][col]=='.'){
           return true;
       }else    {
           return false;
        }
   }
   
   // method finds and return char value at given tile location.
   public char getTile(int row, int col){
       return setChar[row][col];
   }
   
   // set the location in board size for the player.
   public void setTile(int row, int col, char player){
       setChar[row][col]=player;
   }
   
   // set the board size
   public int getSize(){
       return  size;
   }
   
   // method checks if row, col and diagonals are 'X' or '0' and return true, or else false!
   public boolean gameOver(){
       if(checkRows() || checkCols() ||checkDiagonal()){
           return true;
       }else    {
           return false;
        }
   }
   
   // checks rows whether it contains all 'X' or '0'.
   private boolean checkRows(){
       boolean gameOver=false;
       int count = 0;
       for(int i=0; i<size; i++){
           for(int j=0; j<size-1; j++){
               if((setChar[i][j]==setChar[i][j+1]) && (setChar[i][j] =='X' || setChar[i][j] == '0')){
                   count++;
               }
           }
           if(count == size)
                  gameOver = true;
           count = 0;           
       }
        return gameOver;
   }
   
   // checks cols whether it contains all 'X' or '0'.
   private boolean checkCols(){
       boolean gameOver=false;
       int count = 0;
       for(int i=0; i<size-1 ; i++){
           for(int j=0; j<size; j++){
               if(setChar[i][j]==setChar[i+1][j] && (setChar[i][j] =='X' || setChar[i][j] == '0')){
                   count++;
               }
           }
           if(count == size)
                gameOver = true;
           count = 0;
       }
       return gameOver;
   }
   
   // checks diagonals whether it contains all 'X' or '0'.
   private boolean checkDiagonal(){
       boolean gameOver=false;
       int count = 0;
       for(int i=0; i<size-1; i++){
           for(int j=0; j<size-1; j++){
               if(setChar[i][j]==setChar[i+1][j+1] && (setChar[i][j] =='X' || setChar[i][j] == '0')){
                   count++;
               }          
           }
           if(count == size)
                gameOver = true;
           count = 0;
       }
        return gameOver;
   }
   
   // return a String of the current board state
   // "\n" is used to check if multiple rows are returned by calling toString method.   
   public String toString(){
       String toReturn="";
            for(int i=0; i<size; i++){
                for(int j=0; j<size; j++){
                toReturn += setChar[i][j];
                }
                  toReturn += "\n";
            }
            return toReturn;    
   }
}