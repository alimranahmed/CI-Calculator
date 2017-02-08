import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class KeyPad {
    public String type; //numeric, operator, single_operator, command, sign, percent, equal
    public String pureName; //descriptive non-space name of the button
    public String buttonText;//Actual text to be shown in button
    public String screenText; //Actual text to be shonw in screen

    KeyPad(String type, String pureName, String buttonText, String screenText){
        this.type = type;
        this.pureName = pureName;
        this.buttonText = buttonText;
        this.screenText = screenText;
    }

    public String toString(){
        return "{type: "+this.type+", pureName: "+this.pureName+", buttonText:"+this.buttonText+", screenText: "+this.screenText+"}\n";
    }

    public boolean isOperator(){
        return this.type.equalsIgnoreCase("operator");
    }

    public static Map<String, KeyPad> getAllKeys(){
        Map<String, KeyPad> map = new HashMap<String, KeyPad>();
        for(int i = 0; i <= 9; i++){
            map.put(""+i, new KeyPad("numeric", ""+i, ""+i, ""+i));
        }
        //operators keys
        map.put("mul", new KeyPad("operator", "multiply", "\u00D7", "\u00D7"));
        map.put("div", new KeyPad("operator", "divide", "\u00F7", "\u00F7"));
        map.put("add", new KeyPad("operator", "add", "+", "+"));
        map.put("sub", new KeyPad("operator", "subtract", "\u02D7", "\u02D7"));
        map.put("mod", new KeyPad("operator", "mod", "MOD", "MOD"));
        //Answer keys
        map.put("equal", new KeyPad("answer", "equal", "=", "="));
        //number modifier keys
        map.put("point", new KeyPad("number_modifier", "point", ".", "."));
        //Command keys
        map.put("delete", new KeyPad("command", "delete", "DE", ""));
        map.put("cancel", new KeyPad("command", "cancel", "C", ""));
        map.put("exit", new KeyPad("command", "exit", "EXIT", ""));

        //Percent keys
        map.put("percent", new KeyPad("percent", "percent", "%", "%"));

        //signed keys
        map.put("plus_minus", new KeyPad("signed", "plus_minus", "\u00B1", "\u00B1"));

        //----------Single operator keys---------------
        map.put("one_by_n", new KeyPad("single_operator", "one_by_n", "1/n", "1/n"));
        map.put("square", new KeyPad("single_operator", "square", "x\u00B2", "x\u00B2"));
        map.put("cube", new KeyPad("single_operator", "cube", "x\u00B3", "x\u00B3"));
        map.put("sqrt", new KeyPad("single_operator", "square_root", "\u221A", "\u221A"));
        String[] strings = {"sin", "cos", "tan", "asin", "acos", "atan", "sinh", "cosh", "tanh", "log", "log"};
        for(String text: strings){
            map.put(text, new KeyPad("single_operator", text, text, text));
        }

        map.put("ten_power", new KeyPad("single_operator", "tan_power", "10^n", "10^n"));
        map.put("abs", new KeyPad("single_operator", "absolute", "abs", "abs"));
        return map;
    }

}
