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
        String buttonType = pressedButton.type;
        String pureName = pressedButton.pureName;

        System.out.println(new Date()+"[ActionServer][actionPerformed] Button clicked :" + e.getActionCommand()+" "+e.getSource());

        if(pureName.equalsIgnoreCase("exit")){
            System.exit(0);
        }else if(pureName.equalsIgnoreCase("clear")){
            this.clearScreen();
        }else if(buttonType.equalsIgnoreCase("single_operator")){
            this.singleOperation(pressedButton);
        }else if(buttonType.equalsIgnoreCase("numeric")){
            this.displayNumber(pressedButton);
        }else if(buttonType.equalsIgnoreCase("number_modifier")){
            this.displayNumberModifier(pressedButton);
        }
    }

    private void clearScreen(){
        this.inputDisplay.setText("0");
        this.outputDisplay.setText("0");
    }

    private void singleOperation(ButtonHolder operatorButton){
        return;
    }

    private void displayNumber(ButtonHolder numericButton){
        if(this.inputDisplay.getText().equals("0")){
            this.inputDisplay.setText(numericButton.screenText);
        }else{
            this.inputDisplay.setText(this.inputDisplay.getText()+numericButton.screenText);
        }
    }

    private void displayNumberModifier(ButtonHolder numberModifierButton){
        String inputText = this.inputDisplay.getText();
        if(!inputText.contains(numberModifierButton.screenText)){
            this.inputDisplay.setText(this.inputDisplay.getText()+numberModifierButton.screenText);
        }
    }
}
