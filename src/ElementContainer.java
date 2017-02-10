import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Map;

class ElementContainer extends JFrame{
    public Map<String, ButtonHolder> buttonHolderMap;
    public JPanel screens[] = new JPanel[2];
    public JPanel keyPad = new JPanel();

    public JTextField outputDisplay = new JTextField();
    public JTextField inputDisplay = new JTextField();

     ElementContainer(int width, int height) {
        this.setSize(width, height);
        this.buttonHolderMap = ButtonHolder.getAll();
        
        this.setBackground(Helper.darkGrey);
        this.setLayout(null);

        this.screens[0] = new JPanel();
        this.screens[1] = new JPanel();
        this.setupDisplay("input");
        this.setupDisplay("output");

        this.setupAllButtons();

        //----------------------copyright tag-------------------------------------------------------
        JLabel copyRight = new JLabel("\u00A9 2013  CI- Technology");
        copyRight.setForeground(Helper.blue);
        this.keyPad.add(copyRight).setBounds(205, 130, 150, 15);
    }

    private void setupDisplay(String type){
        System.out.println("[ElementContainer][setupDisplay] screen width: "+this.getWidth());
        if(type.equalsIgnoreCase("output")){
            this.screens[1].setLayout(null);
            this.add(this.screens[1]).setBounds(0, (int)(this.getHeight() * 0.06)+5, this.getWidth(), (int)(this.getHeight() * 0.1));
            this.screens[1].add(this.outputDisplay);
            this.outputDisplay.setBounds(0, 0, this.getWidth(), this.screens[1].getHeight());
            this.outputDisplay.setHorizontalAlignment(JTextField.RIGHT);
            this.outputDisplay.setFont(Helper.screenFont);
            this.outputDisplay.setText("0");
            this.outputDisplay.setEditable(false);
            this.outputDisplay.setBackground(Helper.green);
            this.outputDisplay.setForeground(Color.BLACK);
        }else{
            this.screens[0].setLayout(null);
            this.add(this.screens[0]).setBounds(0, 0, this.getWidth(), (int)(this.getHeight() * 0.06));
            this.screens[0].add(inputDisplay);
            this.inputDisplay.setBounds(0, 0, this.getWidth(), this.screens[0].getHeight());
            this.inputDisplay.setHorizontalAlignment(JTextField.LEFT);
            this.inputDisplay.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            this.inputDisplay.setText("0");
            this.inputDisplay.setEditable(false);
            this.inputDisplay.setBackground(Helper.green);
            this.inputDisplay.setForeground(Color.BLACK);
        }
    }

    private void setupAllButtons(){
        //------------setting font, color and style of the common keys-------
        ArrayList<String> mapKeys = ButtonHolder.getMapKeysByType(this.buttonHolderMap, "numeric");
        this.setupButtons(mapKeys, Helper.keyFontMD, Helper.grey);

        mapKeys = ButtonHolder.getMapKeysByType(this.buttonHolderMap, "operator");
        this.setupButtons(mapKeys, Helper.keyFontMD, Helper.white);

        mapKeys = ButtonHolder.getMapKeysByType(this.buttonHolderMap, "number_modifier");
        this.setupButtons(mapKeys, Helper.keyFontMD, Helper.grey);

        mapKeys = ButtonHolder.getMapKeysByType(this.buttonHolderMap, "answer");
        this.setupButtons(mapKeys, Helper.keyFontMD, Helper.lightBlue);

        mapKeys = ButtonHolder.getMapKeysByType(this.buttonHolderMap, "command");
        this.setupButtons(mapKeys, Helper.keyFontMD, Helper.red);

        mapKeys = ButtonHolder.getMapKeysByType(this.buttonHolderMap, "single_operator");
        this.setupButtons(mapKeys, Helper.keyFontMD, Helper.white);

        this.setupButtonByKey("percent", Helper.keyFontMD, Helper.white);

        this.keyPad = new JPanel(); // The keypad that contain the common keys
        //==========================Setup the keypads=====================
        this.add(this.keyPad).setBounds(0, 100, this.getWidth(), (int)(this.getHeight() * 1));
        this.keyPad.setLayout(null);
        this.keyPad.setBackground(Helper.darkGrey);

        this.fixButtonsPlacement();
    }

    private void setupButtons(ArrayList<String> buttonHolderMapKeys, Font font, Color bgColor){
        for(String key : buttonHolderMapKeys){
            this.setupButtonByKey(key, font, bgColor);
        }
    }

    private void setupButtonByKey(String key, Font font, Color bgColor){
        this.buttonHolderMap.get(key).button.setFont(font);
        this.buttonHolderMap.get(key).button.setBackground(bgColor);
        this.buttonHolderMap.get(key).button.setFocusable(false);
    }

    private void fixButtonsPlacement(){
        int rowCounter = 0, colCounter = 0, counter = 0;
        for(String key : this.buttonHolderMap.keySet()){
            int x = colCounter*(this.getWidth() / 6);
            int y = 40 * rowCounter;
            int w = this.getWidth() / 6;
            int h = 40;
            this.keyPad.add(this.buttonHolderMap.get(key).button).setBounds(x, y, w, h);
            System.out.println("at position ("+x+","+y+") h: "+h+" w:"+w+" --> "+this.buttonHolderMap.get(key).pureName);
            counter++;
            rowCounter = counter % 6 == 0 ? rowCounter + 1 : rowCounter;
            colCounter = counter % 6 == 0 ? 0 : colCounter+1;
        }
    }
}
