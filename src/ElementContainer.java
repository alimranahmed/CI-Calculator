import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;

class ElementContainer extends JFrame{
    public Map<String, ButtonHolder> buttonHolderMap;
    public JPanel screens[] = new JPanel[2];
    public JPanel keyPads[] = new JPanel[2];

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
    public ElementContainer() {
        this.buttonHolderMap = ButtonHolder.getAll();
        
        setBackground(windowColor);
        setLayout(null);

        this.screens[0] = new JPanel();
        this.screens[1] = new JPanel();
        this.keyPads[0] = new JPanel(); // The keypad that contain the common keys
        this.keyPads[1] = new JPanel(); // The keypad that contains the scientific keys.

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
        this.setupButtons(mapKeys, fontKeypad, exitColor);

        this.setupButtonByKey("percent", fontKeypad, otherColor);

        /*//-----------------------------placing the common keys-------------------------------------
        // 1st row
        this.keyPads[0].add(bDel).setBounds(226, 0, 54, 38);
        this.keyPads[0].add(bClear).setBounds(280, 0, 54, 38);
        // 2nd row
        this.keyPads[0].add(bSeven).setBounds(10, 38, 54, 38);
        this.keyPads[0].add(bEight).setBounds(64, 38, 54, 38);
        this.keyPads[0].add(bNine).setBounds(118, 38, 54, 38);
        this.keyPads[0].add(bMul).setBounds(172, 38, 54, 38);
        this.keyPads[0].add(bDiv).setBounds(226, 38, 54, 38);
        this.keyPads[0].add(bSquare).setBounds(280, 38, 54, 38);
        // 3rd row
        this.keyPads[0].add(bFour).setBounds(10, 76, 54, 38);
        this.keyPads[0].add(bFive).setBounds(64, 76, 54, 38);
        this.keyPads[0].add(bSix).setBounds(118, 76, 54, 38);
        this.keyPads[0].add(bAdd).setBounds(172, 76, 54, 38);
        this.keyPads[0].add(bSub).setBounds(226, 76, 54, 38);
        this.keyPads[0].add(bCube).setBounds(280, 76, 54, 38);
        // 4th row
        this.keyPads[0].add(bOne).setBounds(10, 114, 54, 38);
        this.keyPads[0].add(bTwo).setBounds(64, 114, 54, 38);
        this.keyPads[0].add(bThree).setBounds(118, 114, 54, 38);
        this.keyPads[0].add(bEqual).setBounds(172, 114, 108, 38);
        this.keyPads[0].add(bMod).setBounds(280, 114, 54, 38);
        // 5th row
        this.keyPads[0].add(bZero).setBounds(10, 152, 54, 38);
        this.keyPads[0].add(bPoint).setBounds(64, 152, 54, 38);
        //this.keyPads[0].add(bPlusMinus).setBounds(118, 152, 54, 38);
        this.keyPads[0].add(bOneByN).setBounds(172, 152, 54, 38);
        this.keyPads[0].add(bPercent).setBounds(226, 152, 54, 38);
        this.keyPads[0].add(bSqrt).setBounds(280, 152, 54, 38);*/


        //==========================Setup the keypads=====================
        this.add(this.keyPads[0]).setBounds(0, 100, 343, 190);
        this.keyPads[0].setLayout(null);
        this.keyPads[0].setBackground(windowColor);

        this.add(this.keyPads[1]).setBounds(0, 310, 343, 145);
        this.keyPads[1].setLayout(null);
        this.keyPads[1].setBackground(windowColor);

        for(String key : this.buttonHolderMap.keySet()){
            this.keyPads[0].add(this.buttonHolderMap.get(key).button).setBounds(0, 0, 50, 50);
        }

        //----------------------copyright tag-------------------------------------------------------
        JLabel copyRight = new JLabel("\u00A9 2013  CI- Technology");
        copyRight.setForeground(copyRightColor);
        this.keyPads[1].add(copyRight).setBounds(205, 130, 150, 15);

        /*//-----------------------------placing the Scientific keys-------------------------------------
        //	1st row
        this.keyPads[1].add(bSin).setBounds(10, 0, 65, 38);
        this.keyPads[1].add(bCos).setBounds(75, 0, 65, 38);
        this.keyPads[1].add(bTan).setBounds(140, 0, 65, 38);
        this.keyPads[1].add(bLog).setBounds(205, 0, 65, 38);
        this.keyPads[1].add(bLn).setBounds(270, 0, 64, 38);
        //	2nd row
        this.keyPads[1].add(bAsin).setBounds(10, 38, 65, 38);
        this.keyPads[1].add(bAcos).setBounds(75, 38, 65, 38);
        this.keyPads[1].add(bAtan).setBounds(140, 38, 65, 38);
        this.keyPads[1].add(bPowerOfTen).setBounds(205, 38, 65, 38);
        this.keyPads[1].add(bAbs).setBounds(270, 38, 64, 38);
        //	3rd row
        this.keyPads[1].add(bSinH).setBounds(10, 76, 65, 38);
        this.keyPads[1].add(bCosH).setBounds(75, 76, 65, 38);
        this.keyPads[1].add(bTanH).setBounds(140, 76, 65, 38);
        this.keyPads[1].add(bExit).setBounds(205, 76, 130, 38);*/
    }

    public void setupDisplay(String type){
        if(type.equalsIgnoreCase("input")){
            this.screens[1].setLayout(null);
            this.add(this.screens[1]).setBounds(0, 30, 343, 50);
            this.screens[1].add(this.outputDisplay);
            this.outputDisplay.setBounds(0, 0, 343, 50);
            this.outputDisplay.setHorizontalAlignment(JTextField.RIGHT);
            this.outputDisplay.setFont(this.fontResDisplay);
            this.outputDisplay.setText("0");
            this.outputDisplay.setEditable(false);
            this.outputDisplay.setBackground(this.screenColor);
            this.outputDisplay.setForeground(Color.BLACK);
        }else{
            this.screens[0].setLayout(null);
            this.add(this.screens[0]).setBounds(0, 0, 343, 30);
            this.screens[0].add(inputDisplay);
            this.inputDisplay.setBounds(0, 0, 343, 30);
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
