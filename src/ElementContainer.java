import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Map;

class ElementContainer extends JFrame {
    Map<String, ButtonHolder> buttonHolderMap;
    private JPanel screen = new JPanel();
    private JPanel keyPad = new JPanel();
    private JPanel footer = new JPanel();

    JTextField outputDisplay = new JTextField();
    JTextField inputDisplay = new JTextField();

    ElementContainer(int width, int height) {
        this.setSize(width, height);
        this.setBackground(Helper.darkGrey);
        this.setLayout(null);

        this.buttonHolderMap = ButtonHolder.getAll();

        this.setupDisplay();

        this.setupKeyPad();

        this.setupFooter();
    }

    private void setupDisplay() {
        System.out.println("[ElementContainer][setupDisplay] setting up display screens...");
        this.screen = new JPanel();
        this.screen.setLayout(null);
        int screenHeight = (int) (this.getHeight() * Helper.SCREEN_RATIO);
        this.add(this.screen).setBounds(0, 0, this.getWidth(), screenHeight);
        //Input display
        this.screen.add(inputDisplay);
        int inputDisplayHeight = (int) (this.screen.getHeight() * Helper.INPUT_DISPLAY_RATIO);
        this.inputDisplay.setBounds(0, 0, this.screen.getWidth(), inputDisplayHeight);
        this.inputDisplay.setHorizontalAlignment(JTextField.LEFT);
        this.inputDisplay.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        this.inputDisplay.setText("0");
        this.inputDisplay.setEditable(false);
        this.inputDisplay.setBackground(Helper.GREEN);
        this.inputDisplay.setForeground(Color.BLACK);

        //Output display
        this.screen.add(this.outputDisplay);
        int outputDisplayHeight = (int) (this.screen.getHeight() * Helper.OUTPUT_DISPLAY_RATIO);
        this.outputDisplay.setBounds(0, inputDisplayHeight, this.screen.getWidth(), outputDisplayHeight);
        this.outputDisplay.setHorizontalAlignment(JTextField.RIGHT);
        this.outputDisplay.setFont(Helper.SCREEN_FONT);
        this.outputDisplay.setText("0");
        this.outputDisplay.setEditable(false);
        this.outputDisplay.setBackground(Helper.GREEN);
        this.outputDisplay.setForeground(Color.BLACK);
        System.out.println("[ElementContainer][setupDisplay] Done!");
    }

    private void setupKeyPad() {
        System.out.println("[ElementContainer][setupKeyPad] setting up keypad...");
        //------------setting font, color and style of buttons-------
        ArrayList<String> mapKeys = ButtonHolder.getMapKeysByType(this.buttonHolderMap, "numeric");
        this.prepareButtons(mapKeys, Helper.KEY_FONT_MD, Helper.GREY);

        mapKeys = ButtonHolder.getMapKeysByType(this.buttonHolderMap, "operator");
        this.prepareButtons(mapKeys, Helper.KEY_FONT_MD, Helper.WHITE);

        mapKeys = ButtonHolder.getMapKeysByType(this.buttonHolderMap, "number_modifier");
        this.prepareButtons(mapKeys, Helper.KEY_FONT_MD, Helper.GREY);

        mapKeys = ButtonHolder.getMapKeysByType(this.buttonHolderMap, "answer");
        this.prepareButtons(mapKeys, Helper.KEY_FONT_MD, Helper.LIGHT_BLUE);

        mapKeys = ButtonHolder.getMapKeysByType(this.buttonHolderMap, "command");
        this.prepareButtons(mapKeys, Helper.KEY_FONT_MD, Helper.RED);

        mapKeys = ButtonHolder.getMapKeysByType(this.buttonHolderMap, "single_operator");
        this.prepareButtons(mapKeys, Helper.KEY_FONT_MD, Helper.WHITE);

        this.prepareButtonByKey("percent", Helper.KEY_FONT_MD, Helper.WHITE);

        this.keyPad = new JPanel();
        int keyPadY = (int) (this.getHeight() * Helper.SCREEN_RATIO);
        int keyPadHeight = (int) (this.getHeight() * Helper.KEYPAD_RATIO);
        this.add(this.keyPad).setBounds(0, keyPadY, this.getWidth(), keyPadHeight);
        this.keyPad.setLayout(null);
        this.keyPad.setBackground(Helper.darkGrey);

        this.fixButtonsPlacement();

        System.out.println("[ElementContainer][setupKeyPad] Done!");
    }

    private void setupFooter(){
        System.out.println("[ElementContainer][setupFooter] setting up footer...");
        int footerY = (int) (this.getHeight() * (Helper.SCREEN_RATIO + Helper.KEYPAD_RATIO));
        int footerHeight = (int)(this.getHeight() * Helper.FOOTER_RATIO);
        this.add(footer).setBounds(0, footerY, this.getWidth(), footerHeight);

        JLabel copyrightTag = new JLabel("\u00A9 2013  CI- Technology");
        copyrightTag.setForeground(Helper.BLUE);
        this.footer.add(copyrightTag).setBounds(0, 0, this.footer.getWidth(), this.footer.getHeight());
        System.out.println("[ElementContainer][setupFooter] Done!");
    }

    private void prepareButtons(ArrayList<String> buttonHolderMapKeys, Font font, Color bgColor) {
        for (String key : buttonHolderMapKeys) {
            this.prepareButtonByKey(key, font, bgColor);
        }
    }

    private void prepareButtonByKey(String key, Font font, Color bgColor) {
        this.buttonHolderMap.get(key).button.setFont(font);
        this.buttonHolderMap.get(key).button.setBackground(bgColor);
        this.buttonHolderMap.get(key).button.setFocusable(false);
        //this.buttonHolderMap.get(key).button.setBorderPainted(false);
    }

    private void fixButtonsPlacement() {
        String[] commonButtons = {"1", "2", "3", "add", "sub", "4", "5", "6", "mul", "div", "7", "8", "9", "mod", "0", "point", "percent", "equal"};
        this.setButtonByKeyList(commonButtons, Helper.BUTTON_HEIGHT);
        String[] scientificButtons = {"sin", "cos", "tan", "asin", "acos", "atan", "sinh", "cosh", "tanh", "log", "one_by_n", "square", "cube", "sqrt", "ten_power", "abs"};
        this.setButtonByKeyList(scientificButtons, 6*Helper.BUTTON_HEIGHT);
    }

    private void setButtonByKeyList(String[] buttonsKeys, int startY){
        int btnPerLine = 5;
        int btnWidth = this.keyPad.getWidth() / btnPerLine;
        int btnHeight = Helper.BUTTON_HEIGHT;
        int extraBlock = this.totalExtraBlock(buttonsKeys.length, btnPerLine);

        int rowCounter = 0, colCounter = 0, counter = 0;
        for(String buttonKey: buttonsKeys){
            int x = colCounter * btnWidth, y = rowCounter * btnHeight + startY;


            if(buttonKey.equalsIgnoreCase("mod") || buttonKey.equalsIgnoreCase("equal")){
                this.keyPad.add(this.buttonHolderMap.get(buttonKey).button).setBounds(x, y, btnWidth*2, btnHeight);
                counter +=2;
            }else{
                this.keyPad.add(this.buttonHolderMap.get(buttonKey).button).setBounds(x, y, btnWidth, btnHeight);
                counter++;
            }
            rowCounter = counter % btnPerLine == 0 ? rowCounter + 1 : rowCounter;
            colCounter = counter % btnPerLine == 0 ? 0 : colCounter + 1;
        }
    }

    private int totalExtraBlock(int numberOfBtn, int btnPerLine){
        return numberOfBtn - (numberOfBtn % btnPerLine);
    }
}
