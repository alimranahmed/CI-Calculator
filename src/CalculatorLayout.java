//About the author of this program:
//	Al- Imran Ahmed
//	Daffodil International University
//	Department of CSE(28th batch)

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class CalculatorLayout extends JFrame implements ActionListener {
    // =======================Declaration of variable===============
    //----------Common keys---------------
    private JButton bOne = new JButton("1");
    private JButton bTwo = new JButton("2");
    private JButton bThree = new JButton("3");
    private JButton bFour = new JButton("4");
    private JButton bFive = new JButton("5");
    private JButton bSix = new JButton("6");
    private JButton bSeven = new JButton("7");
    private JButton bEight = new JButton("8");
    private JButton bNine = new JButton("9");
    private JButton bZero = new JButton("0");
    private JButton bMul = new JButton("\u00D7");
    private JButton bDiv = new JButton("\u00F7");
    private JButton bAdd = new JButton("+");
    private JButton bSub = new JButton("\u02D7");
    private JButton bEqual = new JButton("=");
    private JButton bPoint = new JButton(".");
    private JButton bDel = new JButton("DE");
    private JButton bClear = new JButton("C");
    private JButton bSquare = new JButton("x\u00B2");
    private JButton bCube = new JButton("x\u00B3");
    private JButton bSqrt = new JButton("\u221A");
    private JButton bPercent = new JButton("%");
    private JButton bMod = new JButton("Mod");
    private JButton bOneByN = new JButton("1/n");
    private JButton bPlusMinus = new JButton("\u00B1");

    //----------Scientific keys---------------
    private JButton bSin = new JButton("sin");
    private JButton bCos = new JButton("cos");
    private JButton bTan = new JButton("tan");
    private JButton bAsin = new JButton("asin");
    private JButton bAcos = new JButton("acos");
    private JButton bAtan = new JButton("atan");
    private JButton bSinH = new JButton("sinh");
    private JButton bCosH = new JButton("cosh");
    private JButton bTanH = new JButton("tanh");
    private JButton bPowerOfTen = new JButton("10^n");
    private JButton bLog = new JButton("log");
    private JButton bLn = new JButton("ln");
    private JButton bAbs = new JButton("abs");
    private JButton bExit = new JButton("EXIT");

    //------------container variables---------------
    private JTextField tfDisplay = new JTextField();//result displaying screen
    private JTextField tfRawInput = new JTextField();
    private String sRawInput = "";
    private String sDisplay = "";//Input string
    private boolean isPlus = true;//Is the sign of the operand is plus
    private boolean isPoint = false;//is there is decimal point in the operands
    private boolean isOperation = false;
    private double number1 = 0;// 1st operand
    private double number2 = 0;// 2nd operand
    private double result = 0;// Result
    private char operation = ' ';// Operation
    static Color windowColor = new Color(110, 119, 129);//Color of container window


    //==================Default Constructor to Design the layout of the calculator===========================
    public CalculatorLayout() {
        setBackground(windowColor);
        setLayout(null);
        JPanel pScreen1 = new JPanel(); // The screen that display the input
        JPanel pScreen2 = new JPanel(); // The screen that show the result
        JPanel pKeypad1 = new JPanel(); // The keypad that contain the common keys
        JPanel pKeypad2 = new JPanel(); // The keypad that contains the scientific keys.

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

        //===========================Designing the Result screen of the calculator ===========================
        add(pScreen1).setBounds(0, 0, 343, 30);
        pScreen1.add(tfRawInput);
        pScreen1.setLayout(null);
        tfRawInput.setBounds(0, 0, 343, 30);
        tfRawInput.setHorizontalAlignment(JTextField.LEFT);
        tfRawInput.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        tfRawInput.setText("0");
        tfRawInput.setEditable(false);
        tfRawInput.setBackground(screenColor);
        tfRawInput.setForeground(Color.BLACK);
        //===========================Designing the Result screen of the calculator ===========================
        add(pScreen2).setBounds(0, 30, 343, 50);
        pScreen2.add(tfDisplay);
        pScreen2.setLayout(null);
        tfDisplay.setBounds(0, 0, 343, 50);
        tfDisplay.setHorizontalAlignment(JTextField.RIGHT);
        tfDisplay.setFont(fontResDisplay);
        tfDisplay.setText("0");
        tfDisplay.setEditable(false);
        tfDisplay.setBackground(screenColor);
        tfDisplay.setForeground(Color.BLACK);

        //==========================Designing the keypad1(Common Keys) of the calculator =====================
        add(pKeypad1).setBounds(0, 100, 343, 190);
        pKeypad1.setLayout(null);
        pKeypad1.setBackground(windowColor);

        //------------setting font, color and style of the common keys-------
        bOne.setFont(fontKeypad);
        bOne.setBackground(numberKeyColor);
        bOne.setFocusable(false);
        bTwo.setFont(fontKeypad);
        bTwo.setBackground(numberKeyColor);
        bTwo.setFocusable(false);
        bThree.setFont(fontKeypad);
        bThree.setBackground(numberKeyColor);
        bThree.setFocusable(false);
        bFour.setFont(fontKeypad);
        bFour.setBackground(numberKeyColor);
        bFour.setFocusable(false);
        bFive.setFont(fontKeypad);
        bFive.setBackground(numberKeyColor);
        bFive.setFocusable(false);
        bSix.setFont(fontKeypad);
        bSix.setBackground(numberKeyColor);
        bSix.setFocusable(false);
        bSeven.setFont(fontKeypad);
        bSeven.setBackground(numberKeyColor);
        bSeven.setFocusable(false);
        bEight.setFont(fontKeypad);
        bEight.setBackground(numberKeyColor);
        bEight.setFocusable(false);
        bNine.setFont(fontKeypad);
        bNine.setBackground(numberKeyColor);
        bNine.setFocusable(false);
        bZero.setFont(fontKeypad);
        bZero.setBackground(numberKeyColor);
        bZero.setFocusable(false);
        bAdd.setFont(fontKeypad);
        bAdd.setBackground(otherColor);
        bAdd.setFocusable(false);
        bSub.setFont(fontKeypad);
        bSub.setBackground(otherColor);
        bSub.setFocusable(false);
        bMul.setFont(fontKeypad);
        bMul.setBackground(otherColor);
        bMul.setFocusable(false);
        bDiv.setFont(fontKeypad);
        bDiv.setBackground(otherColor);
        bDiv.setFocusable(false);
        bPoint.setFont(fontKeypad);
        bPoint.setBackground(numberKeyColor);
        bPoint.setFocusable(false);
        bEqual.setFont(new Font("Times New Roman", Font.PLAIN, 40));
        bEqual.setBackground(equalColor);
        bEqual.setFocusable(false);
        bDel.setFont(fontKeypad1);
        bDel.setBackground(Color.ORANGE);
        bDel.setFocusable(false);
        bClear.setFont(fontKeypad);
        bClear.setBackground(exitColor);
        bClear.setFocusable(false);
        bSquare.setFont(fontKeypad);
        bSquare.setBackground(otherColor);
        bSquare.setFocusable(false);
        bSqrt.setFont(fontKeypad);
        bSqrt.setBackground(otherColor);
        bSqrt.setFocusable(false);
        bCube.setFont(fontKeypad);
        bCube.setBackground(otherColor);
        bCube.setFocusable(false);
        bPercent.setFont(fontKeypad);
        bPercent.setBackground(otherColor);
        bPercent.setFocusable(false);
        bMod.setFont(new Font("Times New Roman", Font.PLAIN, 10));
        bMod.setBackground(otherColor);
        bMod.setFocusable(false);
        bOneByN.setFont(fontKeypad1);
        bOneByN.setBackground(otherColor);
        bOneByN.setFocusable(false);
        bPlusMinus.setFont(fontKeypad);
        bPlusMinus.setBackground(numberKeyColor);
        bPlusMinus.setFocusable(false);

        //-----------------------------placing the common keys-------------------------------------
        // 1st row
        pKeypad1.add(bDel).setBounds(226, 0, 54, 38);
        pKeypad1.add(bClear).setBounds(280, 0, 54, 38);
        // 2nd row
        pKeypad1.add(bSeven).setBounds(10, 38, 54, 38);
        pKeypad1.add(bEight).setBounds(64, 38, 54, 38);
        pKeypad1.add(bNine).setBounds(118, 38, 54, 38);
        pKeypad1.add(bMul).setBounds(172, 38, 54, 38);
        pKeypad1.add(bDiv).setBounds(226, 38, 54, 38);
        pKeypad1.add(bSquare).setBounds(280, 38, 54, 38);
        // 3rd row
        pKeypad1.add(bFour).setBounds(10, 76, 54, 38);
        pKeypad1.add(bFive).setBounds(64, 76, 54, 38);
        pKeypad1.add(bSix).setBounds(118, 76, 54, 38);
        pKeypad1.add(bAdd).setBounds(172, 76, 54, 38);
        pKeypad1.add(bSub).setBounds(226, 76, 54, 38);
        pKeypad1.add(bCube).setBounds(280, 76, 54, 38);
        // 4th row
        pKeypad1.add(bOne).setBounds(10, 114, 54, 38);
        pKeypad1.add(bTwo).setBounds(64, 114, 54, 38);
        pKeypad1.add(bThree).setBounds(118, 114, 54, 38);
        pKeypad1.add(bEqual).setBounds(172, 114, 108, 38);
        pKeypad1.add(bMod).setBounds(280, 114, 54, 38);
        // 5th row
        pKeypad1.add(bZero).setBounds(10, 152, 54, 38);
        pKeypad1.add(bPoint).setBounds(64, 152, 54, 38);
        pKeypad1.add(bPlusMinus).setBounds(118, 152, 54, 38);
        pKeypad1.add(bOneByN).setBounds(172, 152, 54, 38);
        pKeypad1.add(bPercent).setBounds(226, 152, 54, 38);
        pKeypad1.add(bSqrt).setBounds(280, 152, 54, 38);


        //==========================Designing the keypad2(scientific Keys) of the calculator =====================

        add(pKeypad2).setBounds(0, 310, 343, 145);
        pKeypad2.setLayout(null);
        pKeypad2.setBackground(windowColor);

        //----------------------copyright tag-------------------------------------------------------
        JLabel copyRight = new JLabel("\u00A9 2013  CI- Soft. Tech.");
        copyRight.setForeground(copyRightColor);
        pKeypad2.add(copyRight).setBounds(205, 130, 150, 15);

        //-----------------------------placing the Scientific keys-------------------------------------
        //	1st row
        pKeypad2.add(bSin).setBounds(10, 0, 65, 38);
        pKeypad2.add(bCos).setBounds(75, 0, 65, 38);
        pKeypad2.add(bTan).setBounds(140, 0, 65, 38);
        pKeypad2.add(bLog).setBounds(205, 0, 65, 38);
        pKeypad2.add(bLn).setBounds(270, 0, 64, 38);
        //	2nd row
        pKeypad2.add(bAsin).setBounds(10, 38, 65, 38);
        pKeypad2.add(bAcos).setBounds(75, 38, 65, 38);
        pKeypad2.add(bAtan).setBounds(140, 38, 65, 38);
        pKeypad2.add(bPowerOfTen).setBounds(205, 38, 65, 38);
        pKeypad2.add(bAbs).setBounds(270, 38, 64, 38);
        //	3rd row
        pKeypad2.add(bSinH).setBounds(10, 76, 65, 38);
        pKeypad2.add(bCosH).setBounds(75, 76, 65, 38);
        pKeypad2.add(bTanH).setBounds(140, 76, 65, 38);
        pKeypad2.add(bExit).setBounds(205, 76, 130, 38);

        //------------setting font, color and style of the common keys-------
        bSin.setFont(fontKeypad);
        bSin.setBackground(otherColor);
        bSin.setFocusable(false);
        bCos.setFont(fontKeypad);
        bCos.setBackground(otherColor);
        bCos.setFocusable(false);
        bTan.setFont(fontKeypad);
        bTan.setBackground(otherColor);
        bTan.setFocusable(false);
        bAsin.setFont(fontKeypad1);
        bAsin.setBackground(otherColor);
        bAsin.setFocusable(false);
        bAcos.setFont(fontKeypad1);
        bAcos.setBackground(otherColor);
        bAcos.setFocusable(false);
        bAtan.setFont(fontKeypad1);
        bAtan.setBackground(otherColor);
        bAtan.setFocusable(false);
        bSinH.setFont(fontKeypad1);
        bSinH.setBackground(otherColor);
        bSinH.setFocusable(false);
        bCosH.setFont(fontKeypad1);
        bCosH.setBackground(otherColor);
        bCosH.setFocusable(false);
        bTanH.setFont(fontKeypad1);
        bTanH.setBackground(otherColor);
        bTanH.setFocusable(false);
        bLog.setFont(fontKeypad);
        bLog.setBackground(otherColor);
        bLog.setFocusable(false);
        bLn.setFont(fontKeypad);
        bLn.setBackground(otherColor);
        bLn.setFocusable(false);
        bAbs.setFont(fontKeypad);
        bAbs.setBackground(otherColor);
        bAbs.setFocusable(false);
        bExit.setFont(fontKeypad);
        bExit.setBackground(exitColor);
        bExit.setFocusable(false);
        bPowerOfTen.setFont(fontKeypad1);
        bPowerOfTen.setBackground(otherColor);
        bPowerOfTen.setFocusable(false);

        // ======================================Adding actionListener =======================================
        //common keys
        bOne.addActionListener(this);
        bTwo.addActionListener(this);
        bThree.addActionListener(this);
        bFour.addActionListener(this);
        bFive.addActionListener(this);
        bSix.addActionListener(this);
        bSeven.addActionListener(this);
        bEight.addActionListener(this);
        bNine.addActionListener(this);
        bZero.addActionListener(this);
        bAdd.addActionListener(this);
        bSub.addActionListener(this);
        bMul.addActionListener(this);
        bDiv.addActionListener(this);
        bPoint.addActionListener(this);
        bEqual.addActionListener(this);
        bDel.addActionListener(this);
        bClear.addActionListener(this);
        bSquare.addActionListener(this);
        bSqrt.addActionListener(this);
        bCube.addActionListener(this);
        bPercent.addActionListener(this);
        bMod.addActionListener(this);
        bOneByN.addActionListener(this);
        bPlusMinus.addActionListener(this);
        //scientific keys
        bSin.addActionListener(this);
        bCos.addActionListener(this);
        bTan.addActionListener(this);
        bAsin.addActionListener(this);
        bAcos.addActionListener(this);
        bAtan.addActionListener(this);
        bSinH.addActionListener(this);
        bCosH.addActionListener(this);
        bTanH.addActionListener(this);
        bPowerOfTen.addActionListener(this);
        bLog.addActionListener(this);
        bLn.addActionListener(this);
        bAbs.addActionListener(this);
        bExit.addActionListener(this);

    }

    //=================================Main method=============================
    public static void main(String[] CHAND) {
        CalculatorLayout frame = new CalculatorLayout();
        frame.setTitle("CI- Calculator");
        frame.setSize(350, 500);
        frame.getContentPane().setBackground(windowColor);
        frame.setLocationRelativeTo(null);
        //frame.setMaximizedBounds(new Rectangle(300, 200));
        frame.setResizable(false);
        ImageIcon img = new ImageIcon("screenshot_1_2.png");
        frame.setIconImage(img.getImage());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    //==============================ActionListener of All keys ===========================
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bOne) {
            if (operation == '=') {
                sDisplay = "1";
                sRawInput = "1";
                tfRawInput.setText(sRawInput);
                operation = ' ';
            } else {
                sDisplay = sDisplay + "1";
                sRawInput += "1";
                tfRawInput.setText(sRawInput);
            }
        } else if (e.getSource() == bTwo) {
            if (operation == '=') {
                sDisplay = "2";
                sRawInput = "2";
                tfRawInput.setText(sRawInput);
                operation = ' ';
            } else {
                sDisplay = sDisplay + "2";
                sRawInput += "2";
                tfRawInput.setText(sRawInput);
            }
        } else if (e.getSource() == bThree) {
            if (operation == '=') {
                sDisplay = "3";
                sRawInput = "3";
                tfRawInput.setText(sRawInput);
                operation = ' ';
            } else {
                sDisplay = sDisplay + "3";
                sRawInput += "3";
                tfRawInput.setText(sRawInput);
            }
        } else if (e.getSource() == bFour) {
            if (operation == '=') {
                sDisplay = "4";
                sRawInput = "4";
                tfRawInput.setText(sRawInput);
                operation = ' ';
            } else {
                sDisplay = sDisplay + "4";
                sRawInput += "4";
                tfRawInput.setText(sRawInput);
            }
        } else if (e.getSource() == bFive) {
            if (operation == '=') {
                sDisplay = "5";
                sRawInput = "5";
                tfRawInput.setText(sRawInput);
                operation = ' ';
            } else {
                sDisplay = sDisplay + "5";
                sRawInput += "5";
                tfRawInput.setText(sRawInput);
            }
        } else if (e.getSource() == bSix) {
            if (operation == '=') {
                sDisplay = "6";
                sRawInput = "6";
                tfRawInput.setText(sRawInput);
                operation = ' ';
            } else {
                sDisplay = sDisplay + "6";
                sRawInput += "6";
                tfRawInput.setText(sRawInput);
            }
        } else if (e.getSource() == bSeven) {
            if (operation == '=') {
                sDisplay = "7";
                sRawInput = "7";
                tfRawInput.setText(sRawInput);
                operation = ' ';
            } else {
                sDisplay = sDisplay + "7";
                sRawInput += "7";
                tfRawInput.setText(sRawInput);
            }
        } else if (e.getSource() == bEight) {
            if (operation == '=') {
                sDisplay = "8";
                sRawInput = "8";
                tfRawInput.setText(sRawInput);
                operation = ' ';
            } else {
                sDisplay = sDisplay + "8";
                sRawInput += "8";
                tfRawInput.setText(sRawInput);
            }
        } else if (e.getSource() == bNine) {
            if (operation == '=') {
                sDisplay = "9";
                sRawInput = "9";
                tfRawInput.setText(sRawInput);
                operation = ' ';
            } else {
                sDisplay = sDisplay + "9";
                sRawInput += "9";
                tfRawInput.setText(sRawInput);
            }
        } else if (e.getSource() == bZero) {
            if (sDisplay.equals(""))//zero at first
            {
                sDisplay = "0";
                sRawInput += "0";
                tfRawInput.setText(sRawInput);
            } else {
                sDisplay = sDisplay + "0";
                sRawInput += "0";
                tfRawInput.setText(sRawInput);
            }
        } else if (e.getSource() == bPoint) ///when bPoint is clicked
        {
            if (sDisplay.equals(""))//bPoint at starting of a number
            {
                sDisplay = "0.";
                sRawInput += "0.";
                tfRawInput.setText(sRawInput);
            } else if (!isPoint)//when there is no bPoint till now then just add the bPoint
            {
                sDisplay = sDisplay + ".";
                sRawInput += ".";
                tfRawInput.setText(sRawInput);
            }
            isPoint = true;//when the bPoint button is clicked once set the bPoint flag to true
        } else if (e.getSource() == bPlusMinus && !sDisplay.equals("") && !isOperation)//plus minus(sign) button
        {
            if (isPlus) {
                sDisplay = "-" + sDisplay;
                sRawInput = sDisplay;
                tfRawInput.setText(sRawInput);
                isPlus = false;
            } else {
                sDisplay = sDisplay.substring(1, sDisplay.length());
                sRawInput = sDisplay.substring(1, sDisplay.length());
                tfRawInput.setText(sRawInput);
                isPlus = true;
            }
        } else if (e.getSource() == bAdd && (!sDisplay.equals("") || operation == '=')) // + button is clicked and input is not empty
        {
            if (!isOperation)//to check if plus without number1
            {
                number1 = Double.parseDouble(sDisplay);
                sDisplay = "";
                operation = '+';
                isPlus = true;
                sRawInput += " + ";
                tfRawInput.setText(sRawInput);
                if (isPoint)//when there is any bPoint number or any bDivision operation, there may be a bPoint in the result
                {
                    tfDisplay.setText("" + number1);
                } else if (!isPoint)//when there is no bPoint in the result
                {
                    tfDisplay.setText("" + (long) number1);
                }
            } else if (isOperation && operation != '=') {
                number2 = Double.parseDouble(sDisplay);

                result = Engine.calculate(number1, number2, operation);
                String temp = Engine.getResultToDisplay(isPoint, operation, result);
                tfDisplay.setText(temp);
                operation = '+';
                sDisplay = "";
                number1 = result;
                isPlus = true;
                isPoint = false;
                isOperation = true;
                sRawInput += " + ";
                tfRawInput.setText(sRawInput);
                sRawInput = temp + " + ";
            } else if (operation == '=') {
                sDisplay = "";
                operation = '+';
                isPlus = true;
                isOperation = true;
                sRawInput += " + ";
                tfRawInput.setText(sRawInput);
            }
            isOperation = true;
        } else if (e.getSource() == bSub && (!sDisplay.equals("") || operation == '='))  // - button is clicked and input is not empty
        {
            if (!isOperation)//to check if plus without number1
            {
                number1 = Double.parseDouble(sDisplay);
                sDisplay = "";
                operation = '-';
                isPlus = true;
                sRawInput += " - ";
                tfRawInput.setText(sRawInput);
                tfDisplay.setText(Engine.getResultToDisplay(isPoint, number1));
            } else if (isOperation && operation != '=') {
                number2 = Double.parseDouble(sDisplay);

                result = Engine.calculate(number1, number2, operation);

                String temp = Engine.getResultToDisplay(isPoint, operation, result);
                tfDisplay.setText(temp);

                operation = '-';
                sDisplay = "";
                number1 = result;
                isPlus = true;
                isPoint = false;
                isOperation = true;
                sRawInput += " - ";
                tfRawInput.setText(sRawInput);
                sRawInput = temp + " + ";
            } else if (operation == '=') {
                sDisplay = "";
                operation = '-';
                isPlus = true;
                isOperation = true;
                sRawInput += " - ";
                tfRawInput.setText(sRawInput);
            }
            isOperation = true;
        } else if (e.getSource() == bMul && (!sDisplay.equals("") || operation == '='))  // * button is clicked and input is not empty
        {
            if (!isOperation)//to check if plus without number1
            {
                number1 = Double.parseDouble(sDisplay);
                sDisplay = "";
                operation = '*';
                isPlus = true;
                sRawInput += " \u00D7 ";
                tfRawInput.setText(sRawInput);
                tfDisplay.setText(Engine.getResultToDisplay(isPoint, number1));
            } else if (isOperation && operation != '=') {
                number2 = Double.parseDouble(sDisplay);

                result = Engine.calculate(number1, number2, operation);
                String temp = Engine.getResultToDisplay(isPoint, operation, result);
                tfDisplay.setText(temp);
                operation = '*';
                sDisplay = "";
                number1 = result;
                isPlus = true;
                isPoint = false;
                isOperation = true;
                sRawInput += " \u00D7 ";
                tfRawInput.setText(sRawInput);
                sRawInput = temp + " \u00D7 ";
            } else if (operation == '=') {
                sDisplay = "";
                operation = '*';
                isPlus = true;
                isOperation = true;
                sRawInput += " \u00D7 ";
                tfRawInput.setText(sRawInput);
            }
            isOperation = true;
        } else if (e.getSource() == bDiv && (!sDisplay.equals("") || operation == '='))  // bDivision button is clicked and input is not empty
        {
            if (!isOperation)//to check if plus without number1
            {
                number1 = Double.parseDouble(sDisplay);
                sDisplay = "";
                operation = '/';
                isPlus = true;
                sRawInput += " / ";
                tfRawInput.setText(sRawInput);
                tfDisplay.setText(Engine.getResultToDisplay(isPoint, number1));
            } else if (isOperation && operation != '=') {
                number2 = Double.parseDouble(sDisplay);

                result = Engine.calculate(number1, number2, operation);
                String temp = Engine.getResultToDisplay(isPoint, operation, result);
                tfDisplay.setText(temp);
                operation = '*';
                sDisplay = "";
                number1 = result;
                isPlus = true;
                isPoint = false;
                isOperation = true;
                sRawInput += " / ";
                tfRawInput.setText(sRawInput);
                sRawInput = temp + " / ";
            } else if (operation == '=') {
                sDisplay = "";
                operation = '/';
                isPlus = true;
                isOperation = true;
                sRawInput += " / ";
                tfRawInput.setText(sRawInput);
            }
            isOperation = true;
        } else if (e.getSource() == bMod && (!sDisplay.equals("") || operation == '='))//Modules button
        {
            if (!isOperation)//to check if plus without number1
            {
                number1 = Double.parseDouble(sDisplay);
                sDisplay = "";
                operation = '%';
                isPlus = true;
                sRawInput += " mod ";
                tfRawInput.setText(sRawInput);
                tfDisplay.setText(Engine.getResultToDisplay(isPoint, number1));
            } else if (isOperation && operation != '=') {
                number2 = Double.parseDouble(sDisplay);

                result = Engine.calculate(number1, number2, operation);
                String temp = Engine.getResultToDisplay(isPoint, operation, result);
                tfDisplay.setText(temp);
                operation = '%';
                sDisplay = "";
                number1 = result;
                isPlus = true;
                isPoint = false;
                isOperation = true;
                sRawInput += " mod ";
                tfRawInput.setText(sRawInput);
                sRawInput = temp + " * ";
            } else if (operation == '=') {
                sDisplay = "";
                operation = '%';
                isPlus = true;
                isOperation = true;
                sRawInput += " mod ";
                tfRawInput.setText(sRawInput);
            }
            isOperation = true;
        } else if (e.getSource() == bEqual && !sDisplay.equals(""))//when bEqual button is clicked and the input is not empty
        {
            number2 = Double.parseDouble(sDisplay);

            if (operation == '+') {
                result = number1 + number2;
            } else if (operation == '-') {
                result = number1 - number2;
            } else if (operation == '*') {
                result = number1 * number2;
            } else if (operation == '/') {
                result = number1 / number2;
            } else if (operation == '%') {
                result = number1 % number2;
            } else {
                result = number2;
            }
            String temp = "";
            if (isPoint || operation == '/')//when there is any bPoint number or any bDivision operation, there may be a bPoint in the result
            {
                tfDisplay.setText("" + result);
                temp = "" + result;
            } else if (!isPoint)//when there is no bPoint in the result
            {
                tfDisplay.setText("" + (long) result);
                temp = "" + (long) result;
            }
            sDisplay = "";
            number1 = result;
            isPlus = true;
            isPoint = false;
            isOperation = true;
            sRawInput += " = ";
            tfRawInput.setText(sRawInput);
            sRawInput = temp;
            operation = '=';
        } else if (e.getSource() == bDel && !sDisplay.equals(""))//DE button
        {
            sDisplay = sDisplay.substring(0, sDisplay.length() - 1);
            sRawInput = sRawInput.substring(0, sRawInput.length() - 1);
            if (sRawInput.equals(""))//after deleting the last digit
            {
                //tfDisplay.setText("0");
                tfRawInput.setText("0");
            } else {
                //tfDisplay.setText(sDisplay);
                tfRawInput.setText(sRawInput);
            }
        } else if (e.getSource() == bClear)//Clear button
        {
            number1 = number2 = result = 0;
            sDisplay = "";
            operation = ' ';
            tfDisplay.setText("0");
            isPoint = false;
            isPlus = true;
            isOperation = false;
            sRawInput = "";
            tfRawInput.setText("0");
        } else if (e.getSource() == bSquare && !sDisplay.equals(""))//Square button
        {
            number1 = Double.parseDouble(sDisplay);
            result = Math.pow(number1, 2);
            String temp = Engine.getResultToDisplay(isPoint, result);
            tfDisplay.setText(temp);
            sRawInput += "^2 = ";
            tfRawInput.setText(sRawInput);
            sRawInput = temp;
            sDisplay = "";
            number1 = result;
            operation = '=';
            isPoint = false;
            isOperation = true;
            isPlus = true;
        } else if (e.getSource() == bSqrt && !sDisplay.equals(""))//root button
        {
            number1 = Double.parseDouble(sDisplay);
            result = Math.sqrt(number1);
            sRawInput = "\u221A" + sRawInput;
            tfRawInput.setText(sRawInput);
            tfDisplay.setText("" + result);
            sRawInput = "" + result;
            sDisplay = "";
            number1 = result;
            operation = '=';
            isPoint = true;
            isOperation = true;
            isPlus = true;
        } else if (e.getSource() == bCube && !sDisplay.equals("")) //Cube button
        {
            number1 = Double.parseDouble(sDisplay);
            result = Math.pow(number1, 3);
            String temp = Engine.getResultToDisplay(isPoint, result);
            tfDisplay.setText(temp);
            sRawInput += "^3 = ";
            tfRawInput.setText(sRawInput);
            sRawInput = temp;
            sDisplay = "";
            number1 = result;
            operation = '=';
            isPoint = false;
            isOperation = true;
            isPlus = true;

        } else if (e.getSource() == bOneByN && !sDisplay.equals(""))// 1/n button
        {
            number1 = Double.parseDouble(sDisplay);
            result = 1 / number1;
            if (isPoint) {
                sRawInput = "1 / " + number1;
            } else {
                sRawInput = "1 / " + (long) number1;
            }
            tfRawInput.setText(sRawInput);
            tfDisplay.setText("" + result);
            sDisplay = "";
            sRawInput = "" + result;
            number1 = result;
            operation = '=';
            isPoint = true;
            isOperation = true;
            isPlus = true;
        } else if (e.getSource() == bPercent && !sDisplay.equals("") && operation == '*')// % button is pressed
        {
            number2 = Double.parseDouble(sDisplay);
            result = number1 * (number2 / 100);
            sRawInput = number1 + " \u00D7 " + number2 + "%";
            tfRawInput.setText(sRawInput);
            tfDisplay.setText("" + result);
            sDisplay = "";
            number1 = result;
            operation = '=';
            isPlus = true;
            isOperation = true;
            isPoint = true;
            sRawInput = "" + result;
        } else if (e.getSource() == bSin && !sDisplay.equals(""))//sin function
        {
            number1 = Double.parseDouble(sDisplay);
            if (number1 == 30) {
                result = Math.sin(Math.toRadians(number1)) + 0.0000000000000001;
            } else {
                result = Math.sin(Math.toRadians(number1));
            }
            sRawInput = "sin(" + sRawInput + ")";
            tfRawInput.setText(sRawInput);
            tfDisplay.setText("" + result);
            sRawInput = "" + result;
            sDisplay = "";
            number1 = result;
            operation = '=';
            isPoint = true;
            isOperation = true;
            isPlus = true;
        } else if (e.getSource() == bCos && !sDisplay.equals(""))//cosine function
        {
            number1 = Double.parseDouble(sDisplay);
            if (number1 == 60) {
                result = Math.cos(Math.toRadians(number1)) - 0.0000000000000001;
            } else if (number1 == 90) {
                result = 0;
            } else {
                result = Math.cos(Math.toRadians(number1));
            }
            sRawInput = "cos(" + sRawInput + ")";
            tfRawInput.setText(sRawInput);
            tfDisplay.setText("" + result);
            sRawInput = "" + result;
            sDisplay = "";
            number1 = result;
            operation = '=';
            isPoint = true;
            isOperation = true;
            isPlus = true;
        } else if (e.getSource() == bTan && !sDisplay.equals(""))//tan function
        {
            number1 = Double.parseDouble(sDisplay);
            if (number1 == 45) {
                result = Math.tan(Math.toRadians(number1)) + 0.0000000000000001;
            } else if (number1 == 90) {
                result = 0;
                tfDisplay.setText("Invalid");
            } else {
                result = Math.tan(Math.toRadians(number1));
            }
            sRawInput = "tan(" + sRawInput + ")";
            tfRawInput.setText(sRawInput);
            if (number1 != 90) {
                tfDisplay.setText("" + result);
            }
            sRawInput = "" + result;
            sDisplay = "";
            number1 = result;
            operation = '=';
            isPoint = true;
            isOperation = true;
            isPlus = true;
        } else if (e.getSource() == bSinH && !sDisplay.equals(""))//sinh function
        {
            number1 = Double.parseDouble(sDisplay);
            result = Math.sinh(Math.toRadians(number1));
            sRawInput = "sinh(" + sRawInput + ")";
            tfRawInput.setText(sRawInput);
            tfDisplay.setText("" + result);
            sRawInput = "" + result;
            sDisplay = "";
            number1 = result;
            operation = '=';
            isPoint = true;
            isOperation = true;
            isPlus = true;
        } else if (e.getSource() == bCosH && !sDisplay.equals(""))//cosh function
        {
            number1 = Double.parseDouble(sDisplay);
            result = Math.cosh(Math.toRadians(number1));
            sRawInput = "cosh(" + sRawInput + ")";
            tfRawInput.setText(sRawInput);
            tfDisplay.setText("" + result);
            sRawInput = "" + result;
            sDisplay = "";
            number1 = result;
            operation = '=';
            isPoint = true;
            isOperation = true;
            isPlus = true;
        } else if (e.getSource() == bTanH && !sDisplay.equals(""))//tanh function
        {
            number1 = Double.parseDouble(sDisplay);
            result = Math.tanh(Math.toRadians(number1));
            sRawInput = "tanH(" + sRawInput + ")";
            tfRawInput.setText(sRawInput);
            tfDisplay.setText("" + result);
            sRawInput = "" + result;
            sDisplay = "";
            number1 = result;
            operation = '=';
            isPoint = true;
            isOperation = true;
            isPlus = true;
        } else if (e.getSource() == bAsin && !sDisplay.equals(""))//asin function
        {
            number1 = Double.parseDouble(sDisplay);
            result = Math.asin(Math.toRadians(number1));
            sRawInput = "asin(" + sRawInput + ")";
            tfRawInput.setText(sRawInput);
            tfDisplay.setText("" + result);
            sRawInput = "" + result;
            sDisplay = "";
            number1 = result;
            operation = '=';
            isPoint = true;
            isOperation = true;
            isPlus = true;
        } else if (e.getSource() == bAcos && !sDisplay.equals(""))//acos function
        {
            number1 = Double.parseDouble(sDisplay);
            result = Math.acos(Math.toRadians(number1));
            sRawInput = "acos(" + sRawInput + ")";
            tfRawInput.setText(sRawInput);
            tfDisplay.setText("" + result);
            sRawInput = "" + result;
            sDisplay = "";
            number1 = result;
            operation = '=';
            isPoint = true;
            isOperation = true;
            isPlus = true;
        } else if (e.getSource() == bAtan && !sDisplay.equals(""))//atan function
        {
            number1 = Double.parseDouble(sDisplay);
            result = Math.atan(Math.toRadians(number1));
            sRawInput = "atan(" + sRawInput + ")";
            tfRawInput.setText(sRawInput);
            tfDisplay.setText("" + result);
            sRawInput = "" + result;
            sDisplay = "";
            number1 = result;
            operation = '=';
            isPoint = true;
            isOperation = true;
            isPlus = true;
        } else if (e.getSource() == bLog && !sDisplay.equals(""))//log function
        {
            number1 = Double.parseDouble(sDisplay);
            result = Math.log10(number1);
            sRawInput = "log" + sRawInput;
            tfRawInput.setText(sRawInput);
            tfDisplay.setText("" + result);
            sRawInput = "" + result;
            sDisplay = "";
            number1 = result;
            operation = '=';
            isPoint = true;
            isOperation = true;
            isPlus = true;
        } else if (e.getSource() == bLn && !sDisplay.equals(""))//ln function
        {
            number1 = Double.parseDouble(sDisplay);
            result = Math.log(number1);
            sRawInput = "ln" + sRawInput;
            tfRawInput.setText(sRawInput);
            tfDisplay.setText("" + result);
            sRawInput = "" + result;
            sDisplay = "";
            number1 = result;
            operation = '=';
            isPoint = true;
            isOperation = true;
            isPlus = true;
        } else if (e.getSource() == bAbs && !sDisplay.equals(""))//abs function
        {
            number1 = Double.parseDouble(sDisplay);
            result = Math.abs(number1);
            sRawInput = "abs(" + sRawInput + ")";
            tfRawInput.setText(sRawInput);
            tfDisplay.setText("" + result);
            sRawInput = "" + result;
            sDisplay = "";
            number1 = result;
            operation = '=';
            isPoint = true;
            isOperation = true;
            isPlus = true;
        } else if (e.getSource() == bPowerOfTen && !sDisplay.equals(""))//power of ten function
        {
            number1 = Double.parseDouble(sDisplay);
            result = Math.pow(10, number1);
            sRawInput = "10^" + sRawInput;
            tfRawInput.setText(sRawInput);
            tfDisplay.setText("" + result);
            sRawInput = "" + result;
            sDisplay = "";
            number1 = result;
            operation = '=';
            isPoint = true;
            isOperation = true;
            isPlus = true;
        } else if (e.getSource() == bExit)//exit button
        {
            System.exit(0);
        }
    }
}