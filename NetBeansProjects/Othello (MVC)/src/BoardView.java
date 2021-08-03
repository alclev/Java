
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;

public class BoardView extends View {

    private JButton[][] btns;
    private Model m;

    public BoardView(Model model, Controller cntrl) {

        super("Othello", model);

        m = model;  //makes reference to inputted model for the controller reference later

        int size = model.getSize();
        setSize(size * 50, size * 50);
        setLayout(new GridLayout(size, size));

        btns = new JButton[size][size];

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                JButton btn = new JButton(String.format("%d, %d", row, col));
                btn.setBorder(new EtchedBorder(EtchedBorder.RAISED));
                btn.addActionListener(cntrl);
                add(btn);
                btns[row][col] = btn;

            }
        }

        updateView();
        setVisible(true);
    }

    @Override
    public void updateView() {
        Color red = new Color(255, 0, 0);
        Color green = new Color(0, 255, 0);
        Color blue = new Color(0, 0, 255);

        int size = model.getSize();

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (model.isOccupied(row, col)) {
                    btns[row][col].setOpaque(true);

                    if (model.isOccupiedBy(row, col, Model.RED)) {
                        btns[row][col].setBackground(red); //I researched the color object in Java
                    }
                    if (model.isOccupiedBy(row, col, Model.GREEN)) {
                        btns[row][col].setBackground(green);
                    }
                    if (model.isOccupiedBy(row, col, Model.BLUE)) {
                        btns[row][col].setBackground(blue);
                    }
                } else {
                    btns[row][col].setOpaque(true);
                    btns[row][col].setBackground(null); //refresh tutorial
                }

                Controller ctl = new Controller(m);  //needs reference to controller

                /*the controller does not store any information, so a new,local contoller object can
                be be created everytime UpdateView is called.  Model m; however, does store information and 
                needs to be a field with global scope.  
                
                 */
                if (ctl.check(row, col)) {
                    btns[row][col].setOpaque(false);  //border
                    if (model.getTurn() == 'R') {
                        btns[row][col].setBackground(red); //highlights according to turn
                    }
                    if (model.getTurn() == 'G') {
                        btns[row][col].setBackground(green);
                    }
                    if (model.getTurn() == 'B') {
                        btns[row][col].setBackground(blue);
                    }
                }

            }
        }
    }

    public static void main(String[] args) {
        Model m = new Model(9);
        Controller ctrl = new Controller(m);
        new BoardView(m, ctrl);
        new ScoreView(m, ctrl);

    }
}
