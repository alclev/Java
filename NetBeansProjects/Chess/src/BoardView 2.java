
import java.awt.GridLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;

public class BoardView extends View{
private JButton[][] btns;
    public BoardView(String title, Model model) {
        super("Chess", model);
        setSize(400,400);
        setLayout(new GridLayout(8,8));
        btns= new JButton[8][8];
        
        for (int row = 0; row < btns.length; row++) {
            for (int col = 0; col < btns.length; col++) {
                Icon bKing= new ImageIcon("kgB.png");

                JButton btn = new JButton(bKing);
                btn.setBorder(new EtchedBorder(EtchedBorder.RAISED));
                //btn.addActionListener(cntrl);
                add(btn);
                btns[row][col] = btn;

            }
        }
        updateView();
        setVisible(true);
    }

    
    @Override
    public void updateView() {
        
    }
    public static void main(String[] args) {
        Model m = new Model();
        Controller ctrl = new Controller();
        new BoardView("",m);

    }
}
