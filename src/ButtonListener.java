import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ButtonListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Button clicked "+e.getActionCommand());
    }
}
