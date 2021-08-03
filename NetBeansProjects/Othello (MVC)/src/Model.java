
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class Model implements Serializable {

    public static final char RED = 'R';
    public static final char GREEN = 'G';
    public static final char BLUE = 'B';

    private Collection<ChangeListener> views;
    private char[][] board;
    private char turn;

    public Model(int size) {
        if (size % 2 != 0 && size > 3) {  //makes sure board size is odd and is not too small
            board = new char[size][size]; //creates matrix with given dimensions
            views = new ArrayList();
            reset();  //resets to given configuration
        } else {
            throw new IllegalArgumentException();  //size is even or too small
        }
    }

    public void reset() {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                board[row][col] = '.';  //loop that iterates through each postion of the matrix and marks "blank" with '.'            
            }

            occupy(board.length / 2 - 1, board.length / 2 - 1, RED);
            occupy(board.length / 2 - 1, board.length / 2, GREEN);
            occupy(board.length / 2 - 1, board.length / 2 + 1, BLUE);

            occupy(board.length / 2, board.length / 2 - 1, GREEN);
            occupy(board.length / 2, board.length / 2, BLUE);
            occupy(board.length / 2, board.length / 2 + 1, RED);

            occupy(board.length / 2 + 1, board.length / 2 - 1, BLUE);
            occupy(board.length / 2 + 1, board.length / 2, RED);
            occupy(board.length / 2 + 1, board.length / 2 + 1, GREEN);

            turn = RED; //sets board to original configuration and makes it the correct turn
        }
    }

    @Override
    public String toString() {
        String matrix = new String();
        for (int row = 0; row < board.length; row++) {  //loop that iterates through each position on the board
            for (int col = 0; col < board.length; col++) {
                matrix += board[row][col] + " ";  //copies the content of each position on the board and adds it to the string
            }
            matrix += "\n";
        }
        return matrix;   //board represented as a string
    }

    /**
     *
     */
    public void addChangeListener(ChangeListener cl) {
        views.add(cl);  //adds a changelistener to the collection 
    }

    public void removeChangeListener(ChangeListener cl) {
        views.remove(cl);  //removes a changelistener from the collection 
    }

    /**
     *
     *
     */
    public int getSize() {
        return board.length;  //returns int that was inputted by the user in the constructer
        //length of the length or width of board
    }

    public int getCount(char player) {
        int count = 0;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {  //loop that iterates through each position on the board
                if (board[row][col] == player) {  //if the inputted player mathces what is at that index 
                    count++;  //count is updated
                }
            }
        }
        return count;
    }

    public char getTurn() {
        return turn; //returns whose turn it currently is
    }

    public void takeTurn() {
        if (turn == RED) {
            turn = GREEN;
        } 
        else 
            if (turn == GREEN){
            turn = BLUE;
        }
        else 
                
        if (turn == BLUE){
            turn = RED;
        }
        
        for (ChangeListener view : views) {
            view.stateChanged(null);
        }
    }

    /**
     *
     *
     */
    public boolean isOccupied(int row, int col) {
        if (board[row][col] == '.') {  //if the inputted postion is blank
            return false;
        } else {
            return true;  //the inputted position is occupied
        }
    }

    public boolean isOccupiedBy(int row, int col, char player) {
        if (board[row][col] == player) {  //if the inputted position is occupied by the inputted player
            return true;
        } else {
            return false;  //inputted position is not occupied by the inputted player
        }
    }

    public void occupy(int row, int col, char player) {
        board[row][col] = player;  //changes the state as the given position is occupied by the inputted player

    }
    
}
