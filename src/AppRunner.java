import javax.swing.*;

public class AppRunner {
    public static void main(String[] CHAND){
        Calculator calculator = new Calculator(450, 600);
        calculator.setTitle("CI- Calculator");
        calculator.getContentPane().setBackground(Helper.darkGrey);
        calculator.setLocationRelativeTo(null);
        calculator.setResizable(false);
        calculator.setIcon("assets/calculator-icon.png");
        calculator.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        calculator.setVisible(true);
    }
}
