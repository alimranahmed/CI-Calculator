import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

class Calculator extends ElementContainer implements ActionListener {
    private Engine engine = new Engine();

    Calculator(int width, int height) {
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

        System.out.println(new Date()+"[Calculator][actionPerformed] Button clicked :" + e.getActionCommand()+" "+e.getSource());

        if(pureName.equalsIgnoreCase("exit")){
            System.exit(0);
        }else if(pureName.equalsIgnoreCase("clear")){
            this.clearScreen();
        }else if(pureName.equalsIgnoreCase("delete")){
            String input = this.inputDisplay.getText();
            ArrayList<String> operators = ButtonHolder.getScreenTextListByType(this.buttonHolderMap, "operator");
            ArrayList<String> numbers = ButtonHolder.getScreenTextListByType(this.buttonHolderMap, "numeric");
            if(input.length() == 1){
                this.inputDisplay.setText("0");
            }else if(Helper.isLastChar(input, operators) || Helper.isLastChar(input, numbers)){
                this.inputDisplay.setText(input.substring(0, input.length()-1));
            }
        }else if(buttonType.equalsIgnoreCase("single_operator")){
            this.singleOperation(pressedButton);
        }else if(buttonType.equalsIgnoreCase("numeric")){
            this.displayNumber(pressedButton);
        }else if(buttonType.equalsIgnoreCase("number_modifier")){
            this.displayNumberModifier(pressedButton);
        }else if(buttonType.equalsIgnoreCase("operator")){
            this.displayOperator(pressedButton);
        }else if(buttonType.equalsIgnoreCase("answer")){
            this.getAnswer(this.inputDisplay.getText());
        }
    }

    private void clearScreen(){
        this.inputDisplay.setText("0");
        this.outputDisplay.setText("0");
    }

    private void displayNumber(ButtonHolder numericButton){
        if(this.isInputClear()){
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

    private void displayOperator(ButtonHolder operatorButton){

        if(this.hasInputOperator()){
            this.getAnswer(this.inputDisplay.getText());
        }
        if(this.isOutputClear()){
            this.inputDisplay.setText(this.inputDisplay.getText()+operatorButton.screenText);
        }else{
            this.inputDisplay.setText(this.outputDisplay.getText()+operatorButton.screenText);
        }
    }

    private void singleOperation(ButtonHolder operatorButton){
        String input = "";
        if(!this.isOutputClear()){
            input = this.outputDisplay.getText();
        }else{
            if(this.hasInputOperator()){
                this.getAnswer(this.inputDisplay.getText());
                input = this.outputDisplay.getText();
            }else{
                input = this.inputDisplay.getText();
            }
        }

        this.inputDisplay.setText(operatorButton.screenText+"("+input+")");

        String result = this.engine.computeSciFun(operatorButton.pureName, input);
        this.outputDisplay.setText(result);
    }

    private void getAnswer(String input){
        String operator = this.getInputFirstOperator();
        if(operator.equals("")){
            this.outputDisplay.setText(this.inputDisplay.getText());
        }else{
            int operatorPosition = input.indexOf(operator);
            String operand1 = input.substring(0, operatorPosition);
            String operand2 = input.substring(operatorPosition+operator.length(), input.length());
            String result = this.engine.compute(operand1, operand2, operator);
            this.outputDisplay.setText(result);
        }
    }

    private boolean isInputClear(){
        return this.inputDisplay.getText().equals("0");
    }

    private boolean isOutputClear(){
        return this.outputDisplay.getText().equals("0");
    }

    private boolean isBothDisplayClear(){
        return this.isInputClear() && this.isOutputClear();
    }

    private String getInputFirstOperator(){
        String input = this.inputDisplay.getText();
        ArrayList<String> operatorList = ButtonHolder.getScreenTextListByType(this.buttonHolderMap, "operator");
        return Helper.getFoundOperator(input, operatorList);
    }

    private boolean hasInputOperator(){
        return !this.getInputFirstOperator().equals("");
    }

    void setIcon(String iconPath){
        ImageIcon img = new ImageIcon(iconPath);
        this.setIconImage(img.getImage());
    }
}
