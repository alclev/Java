
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.event.ChangeListener;


public class Model {
    //fields
    public static final String black= "B";
    public static final String white= "W";
   
    private Collection<ChangeListener> views;
    private String turn;
    private String [][] board;
    public static String rW, kW, bW, qW, kgW, pW, pB, rB, kB, bB, qB, kgB;
    //constructor
    public Model(){
        board= new String[8][8];
        rW="rW"; kW= "kW"; bW= "bW"; qW="qW"; kgW="kgW"; pW= "pW"; pB= "pB"; rB= "rB"; kB= "kB"; bB= "bB"; qB= "qB"; kgB= "kgB";
        views= new ArrayList();
        reset();
        turn = white;
    }
    
    //methods
    public void reset(){
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                board[row][col] = ".";  //loop that iterates through each postion of the matrix and marks "blank" with '.'            
            }
        }
        //black first row
        occupy(0,0,rB);
        occupy(0,1,kB);
        occupy(0,2,bB);
        occupy(0,3,qB);
        occupy(0,4,kgB);
        board[0][5]=board[0][2];
        board[0][6]=board[0][1];
        board[0][7]=board[0][0];
        //black second row
        for (int i= 0; i< board.length; i++){
            board[1][i]= pB;
        }
        //white first row
        occupy(7,0,rW);
        occupy(7,1,kW);
        occupy(7,2,bW);
        occupy(7,3,kgW);
        occupy(7,4,qW);
        board[7][5]=board[7][2];
        board[7][6]=board[7][1];
        board[7][7]=board[7][0];
        //white second row
        for (int i= 0; i< board.length; i++){
            board[6][i]= pW;
        }
    }
    public void addChangeListener(ChangeListener l){
        views.add(l);
    }
    public void removeChangeListener(ChangeListener l){
        views.remove(l);
    }
    public String getTurn(){
        return turn;
    }
    public void takeTurn(){
        if (turn.equals(white)){
            turn= black;
        }
        else 
            turn= white;
            
        for (ChangeListener view : views) {
            view.stateChanged(null);
        }
    }
    public void occupy(int row, int col, String piece){
        board[row][col]= piece;
    }
    public boolean isOccupied(int row, int col){
        return board[row][col] != null;
    }
    public boolean isOccupiedBy(int row, int col, String piece){
        return board[row][col] == piece; 
    }
    @Override
    public String toString() {
        String matrix = new String();
        for (int row = 0; row < board.length; row++) {  //loop that iterates through each position on the board
            for (int col = 0; col < board.length; col++) {
                matrix += board[row][col] + "\t";  //copies the content of each position on the board and adds it to the string
            }
            matrix += "\n";
        }
        return matrix;   //board represented as a string
    }
      
}
