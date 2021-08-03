import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


abstract public class View extends JFrame implements ChangeListener{
    protected Model model;
    public View (String title, Model model){
        super (title);
        this.model=model;
        model.addChangeListener(this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    abstract public void updateView(); 
    

    @Override
    public void stateChanged(ChangeEvent e) {
        updateView();
    }
}