
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;

public class ScoreView extends View {

    private JLabel red = new JLabel("Red: " + 0);
    private JLabel green = new JLabel("Green: " + 0);
    private JLabel blue = new JLabel("Blue: " + 0);
    private JLabel turn = new JLabel("Turn: " + model.getTurn());

    private JLabel[][] labels;
    private JButton[][] btns;

    public ScoreView(Model model, Controller ctrl) {
        super("Score", model);

        final int nmbrOffeatures = 5;
        setSize(600, 100);
        setLayout(new GridLayout(1, nmbrOffeatures));
        labels = new JLabel[1][nmbrOffeatures];
        btns = new JButton[1][2];

        labels[0][0] = red;
        add(red);  //red score
        labels[0][1] = green;
        add(green);  //green score
        labels[0][2] = blue;
        add(blue); //blue score
        labels[0][3] = turn;
        add(turn);  //turn (just for convenience)

        JButton skip = new JButton("Skip Turn");

        skip.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                model.takeTurn();
            }
        });

        btns[0][0] = skip;
        add(skip);
        
        JButton reset= new JButton("Reset");
        
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                model.takeTurn();
                model.reset();
            }
        });
        btns[0][1]= reset;
        add(reset);

        setVisible(true);

    }

    @Override
    public void updateView() {
        red.setText("Red: " + model.getCount(Model.RED));  //updating
        green.setText("Green: " + model.getCount(Model.GREEN));
        blue.setText("Blue: " + model.getCount(Model.BLUE));
        turn.setText("Turn: " + model.getTurn());

    }

}
