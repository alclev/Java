/* 
Rules:
-spot must be unoccupied isOccupied(r, c)
-adjacent to opposite isOccupiedBy(r,c,p)
-getTurn()
getSize()
-same is downstream (end-piece)


 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Controller implements ActionListener {

    private Model model;

    public Controller(Model model) {
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        String coords = btn.getText();

        int row = Integer.parseInt(coords.substring(0, coords.indexOf(",")));
        int col = Integer.parseInt(coords.substring(coords.indexOf(",") + 2));
        System.out.format("%d, %d\n", row, col);

        if (!model.isOccupied(row, col)) {
            if (validate(row, col, -1, 0)
                    | //N
                    validate(row, col, -1, 1)
                    | //NE
                    validate(row, col, 0, 1)
                    | //E
                    validate(row, col, 1, 1)
                    | //SE
                    validate(row, col, 1, 0)
                    | //S
                    validate(row, col, 1, -1)
                    | //SW
                    validate(row, col, 0, -1)
                    | //W
                    validate(row, col, -1, -1) //NW
                    ) {
                model.occupy(row, col, model.getTurn()); //a single bar 'or' tests everything
                model.takeTurn();
            }
        }

    }

    private boolean validate(int upStreamRow, int upStreamCol, int dRow, int dCol) {
        int row = upStreamRow + dRow;
        int col = upStreamCol + dCol;

        // on the board?
        if (row < 0 || row == model.getSize() || col < 0 || col == model.getSize()) {
            //off the board...
            return false;
        }
        // occupied?
        if (!model.isOccupied(row, col)) {
            //nope...
            return false;
        }
        if (model.isOccupiedBy(row, col, model.getTurn())) {
            return model.isOccupied(upStreamRow, upStreamCol);
        }

        //onboard, occupied, opposite color...
        if (validate(row, col, dRow, dCol)) {
            model.occupy(row, col, model.getTurn());
            return true;
        }
        return false;
    }

    /*
    Here I have created another version of validate that only returns a boolean
     */
    public boolean check(int rw, int cl) {

        int row = rw;
        int col = cl;

        if (!model.isOccupied(row, col)) {
            return (vldt(row, col, -1, 0)
                    | //N
                    vldt(row, col, -1, 1)
                    | //NE
                    vldt(row, col, 0, 1)
                    | //E
                    vldt(row, col, 1, 1)
                    | //SE
                    vldt(row, col, 1, 0)
                    | //S
                    vldt(row, col, 1, -1)
                    | //SW
                    vldt(row, col, 0, -1)
                    | //W
                    vldt(row, col, -1, -1) //NW
                    );
        }
        return false;
    }

    /* 
    Here I did the same thing so a version of validate could be used that only returns a boolean
     */

    private boolean vldt(int upStreamRow, int upStreamCol, int dRow, int dCol) {
        int row = upStreamRow + dRow;
        int col = upStreamCol + dCol;

        // on the board?
        if (row < 0 || row == model.getSize() || col < 0 || col == model.getSize()) {
            //off the board...
            return false;
        }
        // occupied?
        if (!model.isOccupied(row, col)) {
            //nope...
            return false;
        }
        if (model.isOccupiedBy(row, col, model.getTurn())) {
            return model.isOccupied(upStreamRow, upStreamCol);
        }

        //onboard, occupied, opposite color...
        if (vldt(row, col, dRow, dCol)) {
            return true;
        }
        return false;
    }
    public void reset(){
        model.reset();
    }
}
