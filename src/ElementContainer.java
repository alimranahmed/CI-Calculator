import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;

class ElementContainer extends JFrame{
    public Map<String, ButtonHolder> buttonHolderMap;
    public JPanel screens[] = new JPanel[2];
    public JPanel keyPad = new JPanel();

    //------------container variables---------------
    public JTextField outputDisplay = new JTextField();//result displaying screen
    public JTextField inputDisplay = new JTextField();
    public String sRawInput = "";
    public String sDisplay = "";//Input string
    public boolean isPlus = true;//Is the sign of the operand is plus
    public boolean isPoint = false;//is there is decimal point in the operands
    public boolean isOperation = false;
    public double number1 = 0;// 1st operand
    public double number2 = 0;// 2nd operand
    public double result = 0;// Result
    public char operation = ' ';// Operation
    static Color windowColor = new Color(110, 119, 129);//Color of container window
    //---------------------Fonts & Colors------------------------
    Font fontResDisplay = new Font("Times New Roman", Font.BOLD, 35);//Font for displaying result
    Font fontKeypad = new Font("Times New Roman", Font.PLAIN, 20);//Font for key character
    Font fontKeypad1 = new Font("Times New Roman", Font.PLAIN, 15);//Font for key character

    Color screenColor = new Color(91, 178, 91);
    Color numberKeyColor = new Color(212, 212, 212);
    Color equalColor = new Color(63, 132, 243);
    Color exitColor = new Color(224, 67, 67);
    Color otherColor = new Color(247, 247, 247);
    Color copyRightColor = new Color(0, 0, 255);
    //==================Default Constructor to Design the layout of the calculator===========================
    public ElementContainer(int width, int height) {
        this.setSize(width, height);
        this.buttonHolderMap = ButtonHolder.getAll();
        
        setBackground(windowColor);
        setLayout(null);

        this.screens[0] = new JPanel();
        this.screens[1] = new JPanel();
        this.setupDisplay("input");
        this.setupDisplay("output");

        //---------------------Fonts & Colors------------------------
        Font fontResDisplay = new Font("Times New Roman", Font.BOLD, 35);//Font for displaying result
        Font fontKeypad = new Font("Times New Roman", Font.PLAIN, 20);//Font for key character
        Font fontKeypad1 = new Font("Times New Roman", Font.PLAIN, 15);//Font for key character

        Color screenColor = new Color(91, 178, 91);
        Color numberKeyColor = new Color(212, 212, 212);
        Color equalColor = new Color(63, 132, 243);
        Color exitColor = new Color(224, 67, 67);
        Color otherColor = new Color(247, 247, 247);
        Color copyRightColor = new Color(0, 0, 255);

        //------------setting font, color and style of the common keys-------
        ArrayList<String> mapKeys = ButtonHolder.getMapKeysByType(this.buttonHolderMap, "numeric");
        this.setupButtons(mapKeys, fontKeypad, numberKeyColor);

        mapKeys = ButtonHolder.getMapKeysByType(this.buttonHolderMap, "operator");
        this.setupButtons(mapKeys, fontKeypad, otherColor);

        mapKeys = ButtonHolder.getMapKeysByType(this.buttonHolderMap, "number_modifier");
        this.setupButtons(mapKeys, fontKeypad, numberKeyColor);

        mapKeys = ButtonHolder.getMapKeysByType(this.buttonHolderMap, "answer");
        this.setupButtons(mapKeys, new Font("Times New Roman", Font.PLAIN, 40), equalColor);

        mapKeys = ButtonHolder.getMapKeysByType(this.buttonHolderMap, "command");
        this.setupButtons(mapKeys, fontKeypad1, exitColor);

        mapKeys = ButtonHolder.getMapKeysByType(this.buttonHolderMap, "single_operator");
        this.setupButtons(mapKeys, fontKeypad, otherColor);

        this.setupButtonByKey("percent", fontKeypad, otherColor);

        this.keyPad = new JPanel(); // The keypad that contain the common keys
        //==========================Setup the keypads=====================
        this.add(this.keyPad).setBounds(0, 100, this.getWidth(), (int)(this.getHeight() * 1));
        this.keyPad.setLayout(null);
        this.keyPad.setBackground(windowColor);

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

        //----------------------copyright tag-------------------------------------------------------
        JLabel copyRight = new JLabel("\u00A9 2013  CI- Technology");
        copyRight.setForeground(copyRightColor);
        this.keyPad.add(copyRight).setBounds(205, 130, 150, 15);
    }

    public void setupDisplay(String type){
        System.out.println("[ElementContainer][setupDisplay] screen width: "+this.getWidth());
        if(type.equalsIgnoreCase("output")){
            this.screens[1].setLayout(null);
            this.add(this.screens[1]).setBounds(0, (int)(this.getHeight() * 0.06)+5, this.getWidth(), (int)(this.getHeight() * 0.1));
            this.screens[1].add(this.outputDisplay);
            this.outputDisplay.setBounds(0, 0, this.getWidth(), this.screens[1].getHeight());
            this.outputDisplay.setHorizontalAlignment(JTextField.RIGHT);
            this.outputDisplay.setFont(this.fontResDisplay);
            this.outputDisplay.setText("0");
            this.outputDisplay.setEditable(false);
            this.outputDisplay.setBackground(this.screenColor);
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
            this.inputDisplay.setBackground(this.screenColor);
            this.inputDisplay.setForeground(Color.BLACK);
        }
    }

    public void setupButtons(ArrayList<String> buttonHolderMapKeys, Font font, Color bgColor){
        for(String key : buttonHolderMapKeys){
            this.setupButtonByKey(key, font, bgColor);
        }
    }

    public void setupButtonByKey(String key, Font font, Color bgColor){
        this.buttonHolderMap.get(key).button.setFont(font);
        this.buttonHolderMap.get(key).button.setBackground(bgColor);
        this.buttonHolderMap.get(key).button.setFocusable(false);
    }
}
