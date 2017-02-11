import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class ButtonHolder {
    String type; //numeric, operator, single_operator, command, sign, percent, equal
    String pureName; //descriptive non-space name of the button
    JButton button;//Actual text to be shown in button
    String screenText; //Actual text to be shonw in screen

    ButtonHolder(String type, String pureName, JButton button, String screenText) {
        this.type = type;
        this.pureName = pureName;
        this.button = button;
        this.screenText = screenText;
    }

    public String toString() {
        return "{type: " + this.type + ", pureName: " + this.pureName + ", button:" + this.button.getText() + ", screenText: " + this.screenText + "}\n";
    }

    public boolean isOperator() {
        return this.type.equalsIgnoreCase("operator");
    }

    static Map<String, ButtonHolder> getAll() {
        Map<String, ButtonHolder> map = new HashMap<String, ButtonHolder>();
        for (int i = 0; i <= 9; i++) {
            map.put("" + i, new ButtonHolder("numeric", "" + i, new JButton("" + i), "" + i));
        }
        //operators keys
        map.put("add", new ButtonHolder("operator", "add", new JButton("+"), "+"));
        map.put("sub", new ButtonHolder("operator", "subtract", new JButton("\u02D7"), "\u02D7"));
        map.put("mul", new ButtonHolder("operator", "multiply", new JButton("\u00D7"), "\u00D7"));
        map.put("div", new ButtonHolder("operator", "divide", new JButton("\u00F7"), "\u00F7"));
        map.put("mod", new ButtonHolder("operator", "mod", new JButton("MOD"), "MOD"));
        //Answer keys
        map.put("equal", new ButtonHolder("answer", "equal", new JButton("="), "="));
        //number modifier keys
        map.put("point", new ButtonHolder("number_modifier", "point", new JButton("."), "."));
        //Command keys
        map.put("delete", new ButtonHolder("command", "delete", new JButton("DE"), ""));
        map.put("cancel", new ButtonHolder("command", "cancel", new JButton("C"), ""));
        map.put("exit", new ButtonHolder("command", "exit", new JButton("EXIT"), ""));

        //Percent keys
        map.put("percent", new ButtonHolder("percent", "percent", new JButton("%"), "%"));

        //signed keys
        //map.put("plus_minus", new ButtonHolder("signed", "plus_minus", new JButton("\u00B1"), "\u00B1"));

        //----------Single operator keys---------------
        map.put("one_by_n", new ButtonHolder("single_operator", "one_by_n", new JButton("1/n"), "1/n"));
        map.put("square", new ButtonHolder("single_operator", "square", new JButton("x\u00B2"), "x\u00B2"));
        map.put("cube", new ButtonHolder("single_operator", "cube", new JButton("x\u00B3"), "x\u00B3"));
        map.put("sqrt", new ButtonHolder("single_operator", "square_root", new JButton("\u221A"), "\u221A"));
        String[] strings = {"sin", "cos", "tan", "asin", "acos", "atan", "sinh", "cosh", "tanh", "log", "log"};
        for (String text : strings) {
            map.put(text, new ButtonHolder("single_operator", text, new JButton(text), text));
        }

        map.put("ten_power", new ButtonHolder("single_operator", "tan_power", new JButton("10^n"), "10^n"));
        map.put("abs", new ButtonHolder("single_operator", "absolute", new JButton("abs"), "abs"));
        return map;
    }

    static ArrayList<String> getMapKeysByType(Map<String, ButtonHolder> buttonHolderMap, String type) {
        ArrayList<String> keyList = new ArrayList<>();
        for (String mapKey : buttonHolderMap.keySet()) {
            ButtonHolder buttonHolder = buttonHolderMap.get(mapKey);
            if (buttonHolder.type.equalsIgnoreCase(type)) {
                keyList.add(mapKey);
            }
        }
        return keyList;
    }

}
