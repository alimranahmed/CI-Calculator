import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

class ActionServer extends ElementContainer implements ActionListener {

    ActionServer(int width, int height) {
        super(width, height);
        //common keys
        for (String key : this.buttonHolderMap.keySet()) {
            this.buttonHolderMap.get(key).addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ButtonHolder pressedButton = (ButtonHolder) e.getSource();
        System.out.println(new Date()+"[ActionServer][actionPerformed] Button clicked :" + e.getActionCommand()+" "+e.getSource());

        if(pressedButton.pureName.equalsIgnoreCase("exit")){
            System.exit(0);
        }else if(pressedButton.pureName.equalsIgnoreCase("clear")){
            this.clearScreen();
        }else{
            this.inputDisplay.setText(this.inputDisplay.getText() + e.getActionCommand());
        }
    }

    private void clearScreen(){
        this.inputDisplay.setText("0");
        this.outputDisplay.setText("0");
    }
}
